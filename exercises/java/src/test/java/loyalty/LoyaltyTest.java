package loyalty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoyaltyTest {
    @Test
    public void purchaseCostOf74PoundsGives74Points(){
        //arrange
        LoyaltyCard card = new LoyaltyCard();
        int expected = 74;
        //act
        int actual = card.getPointsFromPurchaseCost(74);
        //assert
        Assertions.assertEquals(expected, actual);
    }
}
