package secretclosetapp.steps;

import org.checkerframework.checker.units.qual.C;
import secretclosetapp.screens.CitySelectScreen;

public class CitySelectSteps {

    public static void searchAndSelectCity(String cityName) {
        CitySelectScreen citySelectScreen = new CitySelectScreen();
        citySelectScreen.searchCity(cityName);
        citySelectScreen.selectCity(cityName);
        citySelectScreen.waitForSpinner();
    }
}
