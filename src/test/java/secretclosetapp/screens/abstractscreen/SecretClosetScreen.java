package secretclosetapp.screens.abstractscreen;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;

import java.util.concurrent.TimeoutException;

public abstract class SecretClosetScreen extends AndroidScreen{

    private String activityName;
    public static String packageName = "com.zdv.secretcloset";

    private final ILabel lblSpinner = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/pbImageLoading"), "Spinner");

    protected SecretClosetScreen(By locator, String activityName, String name) {
        super(locator, name);
        this.activityName = activityName;
        checkActivityIsOpened();
    }

    private void checkActivityIsOpened() {
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> state().isDisplayed(), activityName.concat(" was not opened"));
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    public void startActivity() {
        Activity activity = new Activity(packageName, activityName);
        super.startActivity(activity);
    }

    public void waitForSpinner() {
        lblSpinner.state().waitForDisplayed();
        lblSpinner.state().waitForNotDisplayed();
    }
}
