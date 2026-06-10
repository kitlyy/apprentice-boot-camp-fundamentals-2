package writingTestManually;



public class Main {
    public static boolean isEligibleToVote(int age) {
        return age >= 18;
    }

    public static void main(String[] args) {

        //arrange
        int age = 20;
        boolean expected = true;

        //act
        boolean actual = isEligibleToVote(age);

        //assert
        if (expected == actual) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        System.out.println(calculateBill(1000, "retailer", 1));


        //running unit tests
        givenRetailerWith20AdsAnd1EnhancementReturn1010();
        givenRetailerWith1000AdsAnd1EnhancementReturn50010();
        givenPrivateWith3AdsAnd2EnhancementReturn80();
        givenPrivateWith1AdsAnd1EnhancementReturn30();
    }


    static int calculateBill(int numberOfAdverts, String customerType, int numberOfEnhanacements) {
        int monthlyCost = switch (customerType) {
            case "private" -> 20;
            case "retailer" -> 50;
            default -> 0;
        };

        return numberOfAdverts*monthlyCost + numberOfEnhanacements*10;

    }

    static void givenRetailerWith20AdsAnd1EnhancementReturn1010() {
        //arrange
        int numberOfAdverts = 20;
        String customer = "retailer";
        int enhancements = 1;
        int expected = 1010;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        if (actual == expected) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    static void givenRetailerWith1000AdsAnd1EnhancementReturn50010() {
        //arrange
        int numberOfAdverts = 1000;
        String customer = "retailer";
        int enhancements = 1;
        int expected = 50010;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        if (actual == expected) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }



    static void givenPrivateWith3AdsAnd2EnhancementReturn80() {
        //arrange
        int numberOfAdverts = 3;
        String customer = "private";
        int enhancements = 2;
        int expected = 80;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        if (actual == expected) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

    static void givenPrivateWith1AdsAnd1EnhancementReturn30() {
        //arrange
        int numberOfAdverts = 1;
        String customer = "retailer";
        int enhancements = 1;
        int expected = 30;
        //act
        int actual = calculateBill(numberOfAdverts, customer, enhancements);
        //assert
        if (actual == expected) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
    }

}
