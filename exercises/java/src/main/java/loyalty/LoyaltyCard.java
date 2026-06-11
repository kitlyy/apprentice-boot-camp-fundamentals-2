package loyalty;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        listOfPoints = new HashMap<>(listOfPoints.entrySet()
                .stream()
                .filter(x -> x.getValue() >= 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public HashMap<Integer, Integer> getListOfPoints() {
        return listOfPoints;
    }
}
