package checkout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckoutTests {
    @Test
    public void oneA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        Assertions.assertEquals(50, checkout.total());
    }

    @Test
    public void twoA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        Assertions.assertEquals(100, checkout.total());

    }

    @Test
    public void threeA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        Assertions.assertEquals(130, checkout.total());
    }

    @Test
    public void sixA() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        Assertions.assertEquals(260, checkout.total());
    }

    @Test
    public void oneB() {
        Checkout checkout = new Checkout();

        checkout.scan("B");
        Assertions.assertEquals(30, checkout.total());
    }

    @Test
    public void twoB() {
        Checkout checkout = new Checkout();

        checkout.scan("B");
        checkout.scan("B");
        Assertions.assertEquals(45, checkout.total());

    }

    @Test
    public void fourB() {
        Checkout checkout = new Checkout();

        checkout.scan("B");
        checkout.scan("B");
        checkout.scan("B");
        checkout.scan("B");
        Assertions.assertEquals(90, checkout.total());
    }

    @Test
    public void simple() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        Assertions.assertEquals(50, checkout.total());
        checkout.scan("B");
        Assertions.assertEquals(80, checkout.total());
        checkout.scan("C");
        Assertions.assertEquals(100, checkout.total());
        checkout.scan("D");
        Assertions.assertEquals(115, checkout.total());

    }

    @Test
    public void incremental() {
        Checkout checkout = new Checkout();

        checkout.scan("A");
        Assertions.assertEquals(50, checkout.total());

        checkout.scan("B");
        Assertions.assertEquals(80, checkout.total());

        checkout.scan("A");
        Assertions.assertEquals(130, checkout.total());

        checkout.scan("A");
        Assertions.assertEquals(160, checkout.total());

        checkout.scan("B");
        Assertions.assertEquals(175, checkout.total());

        checkout.scan("C");
        Assertions.assertEquals(195, checkout.total());

        checkout.scan("B");
        Assertions.assertEquals(225, checkout.total());

        checkout.scan("C");
        Assertions.assertEquals(245, checkout.total());

        checkout.scan("D");
        Assertions.assertEquals(260, checkout.total());

        checkout.scan("D");
        Assertions.assertEquals(275, checkout.total());

        checkout.scan("D");
        Assertions.assertEquals(290, checkout.total());

        checkout.scan("C");
        Assertions.assertEquals(310, checkout.total());

    }
}