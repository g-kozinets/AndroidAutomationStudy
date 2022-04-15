package secretclosetapp.screens;

import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import secretclosetapp.screens.abstractscreen.SecretClosetScreen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivityScreen extends SecretClosetScreen {

    private final IButton btnCity = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "City button");

    private static final By LOC_DISCOUNT = By.xpath("//*[@resource-id = 'com.zdv.secretcloset:id/rlBanner']");

    public MainActivityScreen() {
        super(By.id("com.zdv.secretcloset:id/action_bar_root"), ".MainActivity", "secretcloset main");
    }

    public void clickCity() {
        btnCity.state().waitForClickable();
        btnCity.click();
    }

    public String getCityName() {
        return btnCity.getText();
    }

    private ILabel getDiscountItemByIndex(int index) {
        List<ILabel> discounts = getElementFactory().findElements(LOC_DISCOUNT, "Discount", ElementType.LABEL);
        return discounts.get(--index);
    }

    private String getDiscountItemPrice(ILabel discountItem, ItemInfo itemInfo) {
        By locator = By.id(itemInfo.getLocator());
        return discountItem.findChildElement(locator, itemInfo.name(), ElementType.LABEL).getText();
    }

    public void selectDiscountByIndex(int index) {
        getDiscountItemByIndex(index).click();
    }

    public Map<String, String> getDiscountItemInfo(int itemIndex) {
        ILabel label = getDiscountItemByIndex(itemIndex);
        HashMap<String, String> prices = new HashMap<>();

        Arrays.stream(ItemInfo.values()).forEach(item -> {
            prices.put(item.name(), getDiscountItemPrice(label, item));
        });

        return prices;
    }

    @AllArgsConstructor
    public enum ItemInfo {
        BRAND("com.zdv.secretcloset:id/tvBrand"),
        PRICE("com.zdv.secretcloset:id/tvSumm"),
        DISCOUNT("com.zdv.secretcloset:id/tvDiscount"),
        DISCOUNTED_PRICE("com.zdv.secretcloset:id/tvPrice");

        @Getter
        String locator;
    }
}
