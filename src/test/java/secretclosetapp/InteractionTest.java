package secretclosetapp;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.application.MobileModule;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import secretclosetapp.models.Seller;
import secretclosetapp.steps.*;

import java.util.Map;

import static secretclosetapp.screens.ItemInfoScreen.ItemInfo.*;

public class InteractionTest {
    private static final String CITY_NAME = "London";


    @BeforeClass
    public void setUp() {
        System.clearProperty("profile");
        AqualityServices.initInjector(new MobileModule(AqualityServices::getApplication));
    }

    @AfterClass
    public void tearDown() {
        AqualityServices.getApplication().quit();
    }

    @Test
    public void testSecretClosetApp() {
        MainActivitySteps.clickOnCitySelect();
        WarningPopupSteps.clickOk();
        CitySelectSteps.searchAndSelectCity(CITY_NAME);
        String actualCityName = MainActivitySteps.saveSelectedCityName();
        Assert.assertEquals(actualCityName, CITY_NAME, "City Names should be the same on City Select and Main screens");

        Map<String, String> expectedPrices = MainActivitySteps.getDiscountedItemInfoByIndex(1);
        MainActivitySteps.selectDiscountedItemByIndex(1);
        Map<String, String> actualPrices = ItemInfoSteps.getDiscountedItemInfo(BRAND, DISCOUNT, DISCOUNTED_PRICE, PRICE);
        Assert.assertEquals(actualPrices, expectedPrices, "Item's info should be the same on Main and Item Info screens");

        Seller expectedSeller = ItemInfoSteps.getCurrentSeller();
        ItemInfoSteps.clickOnItemInfo(NAME);
        Seller actualSeller = SellerInfoSteps.getCurrentSeller();
        Assert.assertTrue(actualSeller.equals(expectedSeller), "Seller should be the same on Item Info and Seller Info screens");
    }
}
