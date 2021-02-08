package mobile.testing.configuration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import mobile.testing.utils.TestLogger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;

public class AddressConfigurator {
    private static final String ERROR_LOG_LEVEL = "error";
    private static final String KILL_NODE_COMMAND = "taskkill /F /IM node.exe";
    private static AppiumDriverLocalService appiumDriverLocalService;

    private AddressConfigurator() {
    }

    public static AppiumDriverLocalService getAppiumDriverLocalService(int port) {
        if (appiumDriverLocalService == null) startService(port);
        return appiumDriverLocalService;
    }

    public static void startService(int port) {
        makePortAvailableIfOccupied(port);
        appiumDriverLocalService = new AppiumServiceBuilder().
                withIPAddress(ConfigurationReader.get().appiumAddress()).
                usingPort(port).
                withArgument(SESSION_OVERRIDE).
                withArgument(LOG_LEVEL, ERROR_LOG_LEVEL).
                withArgument(PRE_LAUNCH).
                build();
        appiumDriverLocalService.start();
        TestLogger.writeInfoMessage("Appium server started on port {}", port);
    }

    public static void stopService() {
        Optional.ofNullable(appiumDriverLocalService).ifPresent(service -> {
            service.stop();
            TestLogger.writeInfoMessage("Appium server stopped");
        });
    }

    private static void makePortAvailableIfOccupied(int port) {
        if (!isPortFree(port)) {
            try {
                Runtime.getRuntime().exec(KILL_NODE_COMMAND);
            } catch (IOException e) {
                TestLogger.writeErrorMessage("Couldn't execute runtime command, message {}", e.getMessage());
            }
        }
    }


    private static boolean isPortFree(int port) {
        boolean isFree = true;
        try (ServerSocket ignored = new ServerSocket(port)) {
            TestLogger.writeInfoMessage("Specified port - {} is available and ready to use", port);
        } catch (Exception e) {
            isFree = false;
            TestLogger.writeWarnMessage("Specified port - {} is occupied by some process, process will be terminated", port);
        }
        return isFree;
    }
}
