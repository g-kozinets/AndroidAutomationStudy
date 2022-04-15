package secretclosetapp.screens;

import aquality.appium.mobile.elements.interfaces.ILabel;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import secretclosetapp.models.Seller;
import secretclosetapp.screens.abstractscreen.SecretClosetScreen;
import secretclosetapp.utils.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ItemInfoScreen extends SecretClosetScreen {

    public ItemInfoScreen() {
        super(By.id("com.zdv.secretcloset:id/rlBasicInfo"), ".AdditionalAttributesActivity", "Item Info");
    }

    private ILabel getLabel(By locator, String name) {
        return getElementFactory().getLabel(locator, name);
    }

    public void clickItemInfo(ItemInfo info) {
        getLabel(By.id(info.getLocator()), info.name()).click();
    }

    private String getItemInfo(ItemInfo itemInfo) {
        By locator = By.id(itemInfo.getLocator());
        return getLabel(locator, itemInfo.name()).getText();
    }

    public Map<String, String> getDiscountItemInfo(ItemInfo... info) {
        HashMap<String, String> prices = new HashMap<>();

        Arrays.stream(info).forEach(item -> {
            prices.put(item.name(), getItemInfo(item));
        });

        return prices;
    }

    public Seller getSeller() {
        String name = getLabel(By.id(ItemInfo.NAME.getLocator()), ItemInfo.NAME.name()).getText();
        String city = getLabel(By.id(ItemInfo.CITY.getLocator()), ItemInfo.CITY.name()).getText();

        return new Seller(name, city);
    }


    @AllArgsConstructor
    public enum ItemInfo {
        BRAND("tvItemBrand"),
        PRICE("tvItemOriginalPrice"),
        DISCOUNT("tvItemDiscount"),
        DISCOUNTED_PRICE("tvItemPrice"),
        NAME("tvItemSellerName"),
        CITY("tvItemSellerCity");

        String locator;

        public String getLocator() {
            return String.format(Constants.ID_LOC_FORMAT, ItemInfoScreen.packageName, locator);
        }
    }
}
