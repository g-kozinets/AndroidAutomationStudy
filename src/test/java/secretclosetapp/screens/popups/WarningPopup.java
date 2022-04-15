package secretclosetapp.screens.popups;

import aquality.appium.mobile.elements.interfaces.IButton;
import org.openqa.selenium.By;
import secretclosetapp.screens.abstractscreen.AndroidScreen;

public class WarningPopup extends AndroidScreen {

    IButton btnOk = getElementFactory().getButton(By.id("android:id/button1"), "Ok button");

    public WarningPopup() {
        super(By.id("android:id/alertTitle"),  "Warning popup");
    }

    public void clickOk() {
        btnOk.click();
    }
}
