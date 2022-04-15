package secretclosetapp.steps;

import secretclosetapp.models.Seller;
import secretclosetapp.screens.ItemInfoScreen;

import java.util.Map;

public class ItemInfoSteps {

    public static Map<String, String> getDiscountedItemInfo(ItemInfoScreen.ItemInfo ...info) {
        return new ItemInfoScreen().getDiscountItemInfo(info);
    }

    public static Seller getCurrentSeller() {
        return new ItemInfoScreen().getSeller();
    }

    public static void clickOnItemInfo(ItemInfoScreen.ItemInfo info) {
        new ItemInfoScreen().clickItemInfo(info);
    }
}
