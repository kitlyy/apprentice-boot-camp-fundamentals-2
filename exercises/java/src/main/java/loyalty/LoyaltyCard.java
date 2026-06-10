package loyalty;

import javax.naming.InsufficientResourcesException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LoyaltyCard {

    HashMap<Integer, Integer> listOfPoints;
    int pointBalance = 0;


    LoyaltyCard() {
        this(new HashMap<>());
    }
    LoyaltyCard(HashMap<Integer, Integer> listOfPoints) {
        this.listOfPoints = listOfPoints;
    }
    int getPointsFromPurchaseCost(float purchaseCost) {
        if (purchaseCost <= 100) {
            return (int) purchaseCost;
        }
        return (int) (100 + 2*(purchaseCost-100));
    }

    public int getPointBalance() {
        return pointBalance;
    }

    public void makePurchase(int purchaseCost) {
        int points = getPointsFromPurchaseCost(purchaseCost);
        pointBalance += points;
        listOfPoints.put(points, 365);
        removeExpiredPoints();
        if (pointBalance > 5000) {
            pointBalance -= 5000;
            System.out.println("£50 in-store gift card has been issues");
        }
    }

    public void removeExpiredPoints() {
        HashMap<Integer, Integer> toRemove = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : listOfPoints.entrySet()) {
            if (entry.getValue() < 1) {
                toRemove.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<Integer, Integer> entry : toRemove.entrySet()) {
            listOfPoints.remove(entry.getKey());
        }
    }

    public HashMap<Integer, Integer> getListOfPoints() {
        return listOfPoints;
    }
}
