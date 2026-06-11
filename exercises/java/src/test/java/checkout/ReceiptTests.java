package checkout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReceiptTests {
    @Test
    public void singleItem() {
        Checkout checkout = new Checkout();
        Item a = new Item("A", 50, 3, 20);

        checkout.scan(List.of(a));
        Assertions.assertEquals("A: 50\nTotal: 50", checkout.receipt());
    }

    @Test
    public void oneOfEach() {
        Checkout checkout = new Checkout();

        Item b = new Item("B", 30, 2, 15);
        Item a = new Item("A", 50, 3, 20);
        Item c = new Item("C", 20, 0, 0);
        Item d = new Item("D", 15, 0, 0);

        checkout.scan(List.of(a, b, c, d));
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
        Item b = new Item("B", 30, 2, 15);
        Item a = new Item("A", 50, 3, 20);
        Item c = new Item("C", 20, 0, 0);
        Item d = new Item("D", 15, 0, 0);

        checkout.scan(List.of(a, a, b, a, c, d, b));

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