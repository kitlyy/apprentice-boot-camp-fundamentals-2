package loyalty;

public class LoyaltyCard {

    int pointBalance = 0;


    public int getPointsFromPurchaseCost(float purchaseCost) {
        if (purchaseCost <= 100) {
            return (int) purchaseCost;
        } else {
            return (int) (100 + 2*(purchaseCost-100));
        }
    }
}
