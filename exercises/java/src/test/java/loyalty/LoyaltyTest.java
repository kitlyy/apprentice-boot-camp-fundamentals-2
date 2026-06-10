package loyalty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class LoyaltyTest {

    /*
    if this method becomes private, as we have tested it and we know it works,
    we have to delete these tests because it is now private

    we can make it so that it has default visibility, but then children have access to it which
    might not be the desired behavior

    where is the paper-trail of tests that confirm the method actually works??
     */
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

        card.makePurchase(74);
        card.makePurchase(124);
        int actual = card.getPointBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test void purchaseOf5000LeavesBalanceOf4900() {
        LoyaltyCard card = new LoyaltyCard();
        int expected = 4900;

        card.makePurchase(5000);
        int actual = card.getPointBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test void removePointsThatHaveExpired() {
        LoyaltyCard card = new LoyaltyCard(new HashMap<>(Map.ofEntries(
                entry(60, 260),
                entry(100, 40),
                entry(5, 0),
                entry(600, -1))));
        HashMap<Integer, Integer> expectedList = new HashMap(Map.ofEntries(
                entry(60, 260),
                entry(100, 40)));

        //act

        card.removeExpiredPoints();
        HashMap<Integer, Integer> actualList = card.getListOfPoints();

        Assertions.assertEquals(expectedList, actualList);

    }
}


