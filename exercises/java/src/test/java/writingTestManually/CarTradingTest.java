package writingTestManually;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static writingTestManually.CarTrading.calculateBill;

class CarTradingTest {
    @Test
    void givenRetailerWith20AdsAnd1Enhancement() {
        //arrange
        int numberOfAdverts = 20;
        String customer = "retailer";
        int enhancements = 1;
        int expected = 1010;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        assertEquals(expected, actual);
    }

    @Test
    void givenRetailerWith1000AdsAnd1Enhancement() {
        //arrange
        int numberOfAdverts = 1000;
        String customer = "retailer";
        int enhancements = 1;
        int expected = 50010;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        assertEquals(expected, actual);
    }

    @Test
    void givenPrivateWith3AdsAnd2Enhancement() {
        //arrange
        int numberOfAdverts = 3;
        String customer = "private";
        int enhancements = 2;
        int expected = 80;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        assertEquals(expected, actual);
    }

    @Test
    void givenPrivateWith1AdsAnd1Enhancement() {
        //arrange
        int numberOfAdverts = 1;
        String customer = "private";
        int enhancements = 1;
        int expected = 30;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        assertEquals(expected, actual);
    }
}