package checkout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReceiptTests {
    @Test
    public void singleItem() {
        Checkout checkout = new Checkout();
        checkout.scan("A");
        Assertions.assertEquals("A: 50\nTotal: 50", checkout.receipt());
    }

    @Test
    public void singleItemMethodTwo() {
        Checkout checkout = new Checkout();
        checkout.scan("A");
        String expected =  "A: 50\nTotal: 50";
        // I would avoid this pattern as failure won't give meaningful information about the failure
        Assertions.assertTrue(checkout.receipt().equals(expected));
    }

    @Test
    public void singleItemMethodThree() {
        Checkout checkout = new Checkout();
        checkout.scan("A");
        String expected =  "A: 50\nTotal: 50";
        // I would avoid this pattern as failure won't give meaningful information about the failure
        Assertions.assertTrue(checkout.receipt().contains(expected));
    }

    @Test
    public void oneOfEach() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("C");
        checkout.scan("D");
        Assertions.assertEquals(
                "A: 50\n" +
                "B: 30\n" +
                "C: 20\n" +
                "D: 15\n" +
                "Total: 115",
                checkout.receipt());
    }

    @Test
    public void offers() {
        Checkout checkout = new Checkout();
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("A");
        checkout.scan("C");
        checkout.scan("D");
        checkout.scan("B");

        Assertions.assertEquals("""
                A: 50
                A: 50
                B: 30
                A: 50 - 20 (3 for 130)
                C: 20
                D: 15
                B: 30 - 15 (2 for 45)
                Total: 210""",
                checkout.receipt());
    }
}