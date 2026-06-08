package checkout;

public class Checkout {
    private int total = 0;
    private int numberOfA = 0;
    private int numberOfB = 0;
    private Receipt receipt = new Receipt();

    void scan(String sku) {
        if ("A".equals(sku)) {
            total += 50;
            if (++numberOfA % 3 == 0) {
                total -= 20;
            }
            receipt.scannedA();
        } else if ("B".equals(sku)) {
            total += 30;
            if (++numberOfB % 2 == 0) {
                total -= 15;
            }
            receipt.scannedB();
        } else if ("C".equals(sku)) {
            total += 20;
            receipt.scannedC();
        } else if ("D".equals(sku)) {
            total += 15;
            receipt.scannedD();
        }
    }

    int total() {
        return total;
    }

    String receipt() {
        return receipt.text();
    }
}