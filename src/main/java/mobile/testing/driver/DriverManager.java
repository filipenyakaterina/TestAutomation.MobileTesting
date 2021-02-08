package mobile.testing.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mobile.testing.configuration.AddressConfigurator;
import mobile.testing.configuration.CapabilitiesConfigurator;
import mobile.testing.configuration.ConfigurationReader;
import mobile.testing.configuration.EnvironmentType;
import mobile.testing.utils.TestLogger;

import java.io.IOException;
import java.util.Optional;

import static java.lang.String.format;

public class DriverManager {
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(ConfigurationReader.get().env().toUpperCase());
    private static AppiumDriver<MobileElement> driver;

    private DriverManager() {
    }

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private static AppiumDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                driver = new AndroidDriver<MobileElement>(AddressConfigurator.getAppiumDriverLocalService(ConfigurationReader.get().appiumPort()),
                        CapabilitiesConfigurator.getLocalCapabilities());
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected environment value: %s", ENVIRONMENT_TYPE));
        }
        TestLogger.writeInfoMessage("Driver is created");
        TestLogger.writeInfoMessage("Environment type is {}", ENVIRONMENT_TYPE);
        return driver;
    }

    public static void closeDriver() {
        Optional.ofNullable(getDriver()).ifPresent(driverInstance -> {
            driverInstance.quit();
            driver = null;
            TestLogger.writeInfoMessage("Driver is closed");
        });
    }

    public static void closeAppium() {
        AddressConfigurator.stopService();
    }

    public static void closeEmulator() {
        try {
            Runtime.getRuntime().exec(format("adb -s %s emu kill", ConfigurationReader.get().udid()));
            TestLogger.writeInfoMessage("AVD is closed");
        } catch (IOException e) {
            TestLogger.writeInfoMessage("AVD was not closed, message: {}", e.getMessage());
        }
    }
}
