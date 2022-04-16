package secretclosetapp.screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import secretclosetapp.models.Seller;
import secretclosetapp.screens.abstractscreen.SecretClosetScreen;

public class SellerInfoScreen extends SecretClosetScreen {

    private final ILabel sellerName = getElementFactory()
            .getLabel(By.xpath("//*[@resource-id='com.zdv.secretcloset:id/toolbar']//android.widget.TextView[contains(@text, '')]"), "Seller's Name");
    private final ILabel sellerCity = getElementFactory()
            .getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "Seller's City");

    public SellerInfoScreen() {
        super(By.id("com.zdv.secretcloset:id/ivSellerAvatar"), ".SellerInfoActivity", "Seller Info");
    }

    public Seller getSeller() {
        return new Seller(sellerName.getText(), sellerCity.getText());
    }
}
