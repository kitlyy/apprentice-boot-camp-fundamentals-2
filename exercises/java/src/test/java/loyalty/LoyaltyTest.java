package loyalty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoyaltyTest {
    @Test
    public void purchaseCostOf74PoundsGives74Points() {
        //arrange
        LoyaltyCard card = new LoyaltyCard();
        int expected = 74;
        //act
        int actual = card.getPointsFromPurchaseCost(74);
        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test void purchaseCostOf124PoundsGives148Points() {
        LoyaltyCard card = new LoyaltyCard();
        int expected = 148;

        int actual = card.getPointsFromPurchaseCost(124);

        Assertions.assertEquals(expected, actual);
    }

    @Test void purchaseOf74And124MakesBalance222() {
        LoyaltyCard card = new LoyaltyCard();
        int expected = 222;

        //act
        card.makePurchase(74);
        card.makePurchase(124);
        int actual = card.getPointBalance();

        Assertions.assertEquals(expected, actual);
    }
}
