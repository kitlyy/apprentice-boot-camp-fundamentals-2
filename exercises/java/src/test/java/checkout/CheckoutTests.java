package checkout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CheckoutTests {
    @Test
    public void oneA() {
        Checkout checkout = new Checkout();
        Item a = new Item("A", 50, 3, 20);
        List<Item> stockKeepingUnits = List.of(a);
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(50, checkout.total());
    }

    @Test
    public void twoA() {
        Checkout checkout = new Checkout();
        Item a = new Item("A", 50, 3, 20);
        List<Item> stockKeepingUnits = List.of(a, a);
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(100, checkout.total());

    }

    @Test
    public void threeA() {
        Checkout checkout = new Checkout();
        Item a = new Item("A", 50, 3, 20);
        List<Item> stockKeepingUnits = List.of(a, a, a);
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(130, checkout.total());
    }


    @Test
    public void sixA() {
        Checkout checkout = new Checkout();
        Item a = new Item("A", 50, 3, 20);
        List<Item> stockKeepingUnits = List.of(a, a, a, a, a, a);

        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(260, checkout.total());
    }

    @Test
    public void oneB() {
        Checkout checkout = new Checkout();
        Item b = new Item("B", 30, 2, 15);
        List<Item> stockKeepingUnits = List.of(b);
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(30, checkout.total());
    }

    @Test
    public void twoB() {
        Checkout checkout = new Checkout();
        Item b = new Item("B", 30, 2, 15);
        List<Item> stockKeepingUnits = List.of(b, b);
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(45, checkout.total());

    }

    @Test
    public void fourB() {
        Checkout checkout = new Checkout();
        Item b = new Item("B", 30, 2, 15);
        List<Item> stockKeepingUnits = List.of(b, b, b, b);
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(90, checkout.total());
    }

    @Test
    public void simple() {
        Checkout checkout= new Checkout();

        Item a = new Item("A", 50, 3, 20);
        Item b = new Item("B", 30, 2, 15);
        Item c = new Item("C", 20, 0, 0);
        Item d = new Item("D", 15, 0, 0);

        List<Item> stockKeepingUnits = new ArrayList<>(List.of(a, b, c, d));
        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(115, checkout.total());

    }

    @Test
    public void incremental() {
        Checkout checkout = new Checkout();

        Item b = new Item("B", 30, 2, 15);
        Item a = new Item("A", 50, 3, 20);
        Item c = new Item("C", 20, 0, 0);
        Item d = new Item("D", 15, 0, 0);

        List<Item> stockKeepingUnits = new ArrayList<>(List.of(
                a, b, a, a,
                b, c, b, c,
                d, d, d, c));

        checkout.scan(stockKeepingUnits);
        Assertions.assertEquals(310, checkout.total());

    }
}