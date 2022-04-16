package secretclosetapp.steps;

import secretclosetapp.models.Seller;
import secretclosetapp.screens.SellerInfoScreen;

public class SellerInfoSteps {

    public static Seller getCurrentSeller() {
        return new SellerInfoScreen().getSeller();
    }
}
