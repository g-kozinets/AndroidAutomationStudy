package secretclosetapp.steps;

import secretclosetapp.screens.MainActivityScreen;

import java.util.Map;

public class MainActivitySteps {

    public static void clickOnCitySelect() {
        MainActivityScreen mainActivityScreen = new MainActivityScreen();
        mainActivityScreen.waitForSpinner();
        mainActivityScreen.clickCity();
    }

    public static Map<String, String> getDiscountedItemInfoByIndex(int index) {
        return new MainActivityScreen().getDiscountItemInfo(index);
    }

    public static void selectDiscountedItemByIndex(int index) {
        new MainActivityScreen().selectDiscountByIndex(index);
    }

    public static String saveSelectedCityName() {
        return new MainActivityScreen().getCityName();
    }
}
