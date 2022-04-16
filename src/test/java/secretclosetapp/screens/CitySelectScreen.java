package secretclosetapp.screens;

import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import secretclosetapp.screens.abstractscreen.SecretClosetScreen;

public class CitySelectScreen extends SecretClosetScreen {

    private ITextBox TXB_SEARCH = getElementFactory().getTextBox(By.id("com.zdv.secretcloset:id/etSearchTest"), "City Search");
    private static final String LOC_CITY_OPTION = "//*[@text = '%s' and contains(@resource-id, 'tvCityItemName')]";

    public CitySelectScreen() {
        super(By.id("com.zdv.secretcloset:id/searchBar"), ".CitySelectActivity", "City Select");
    }

    public void selectCity(String cityName) {
        IButton button = getElementFactory().getButton(By.xpath(String.format(LOC_CITY_OPTION, cityName)), cityName);
        button.state().waitForClickable();
        button.click();
    }

    public void searchCity(String cityName) {
        TXB_SEARCH.state().waitForExist();
        TXB_SEARCH.clearAndType(cityName);
    }
}
