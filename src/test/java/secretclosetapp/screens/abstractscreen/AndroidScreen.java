package secretclosetapp.screens.abstractscreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public abstract class AndroidScreen extends Screen {

    protected AndroidScreen(By locator, String name) {
        super(locator, name);
    }

    @SuppressWarnings("unchecked")
    protected void startActivity(Activity activity) {
        AqualityServices.getLocalizedLogger().info("loc.application.android.activity.start",
                activity.getAppActivity(),
                activity.getAppPackage());
        AndroidDriver driver = (AndroidDriver) AqualityServices.getApplication().getDriver();
        driver.startActivity(activity);
    }
}
