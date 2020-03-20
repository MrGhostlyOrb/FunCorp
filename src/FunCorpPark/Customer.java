/***********************************************************************************************************************

 File        : Customer.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : This class is designed to store various information about a customer in the ThemePark. The information
 stored consists of: accountNumber, name, age, accountBalance and personalDiscount. This class also includes methods
 for using various attractions, it has been overloaded in order to accommodate for RollerCoasters having a minimum
 age to ride along with several getter and setter methods.
 **********************************************************************************************************************/

package FunCorpPark;

public class Customer {

    //Enum to store the discount information as numbers so that it can be converted easily
    public enum personalDiscountEnum {
        STUDENT(0.9), FAMILY(0.85), NONE(1);

        private final double discountEnum;

        personalDiscountEnum(double i) {
            this.discountEnum = i;
        }

        public double getDiscountEnum() {
            return discountEnum;
        }
    }

    //Fields for the customer class
    private String accountNumber;
    private String name;
    private int age;
    private int accountBalance;
    private personalDiscountEnum personalDiscount;

    //Constructor for the customer class
    public Customer(String name, String accountNumber, int age, int accountBalance, personalDiscountEnum personalDiscount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.accountBalance = accountBalance;
        this.personalDiscount = personalDiscount;
    }

    //Get and set methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public personalDiscountEnum getPersonalDiscount() {
        return this.personalDiscount;
    }

    @Override

    //To string method to print out the customer as it was received in the txt file
    public String toString() {
        return name + "#" + accountNumber + "#" + age + "#" + accountBalance + "#" + personalDiscount;
    }

    //Method for the customer to add funds to their account balance
    public void addFunds(int amount) {
        accountBalance = accountBalance + amount;
        System.out.println("New balance is : " + accountBalance);
    }

    //Method to use an attraction and deduct the price of the attraction from the customers account balance
    public int useAttraction(int price) throws InsufficientBalanceException {

        int newPrice = (int) (price * this.getPersonalDiscount().getDiscountEnum());
        System.out.println("Price after discount : " + newPrice);

        if (accountBalance < newPrice) {
            throw new InsufficientBalanceException();
        } else {
            accountBalance = accountBalance - newPrice;
        }

        return newPrice;
    }

    //Overloaded method to use a RollerCoaster attraction with both a price and a minimum age
    public int useAttraction(int price, int minimumAge) throws AgeRestrictionException, InsufficientBalanceException {

        int newPrice = (int) (price * this.getPersonalDiscount().getDiscountEnum());
        System.out.println("Price for ride is : " + newPrice);

        System.out.println("Checking age");
        if (this.age < minimumAge) {
            throw new AgeRestrictionException();
        }
        System.out.println("Checking balance");

        if (this.accountBalance >= price) {
            accountBalance = accountBalance - newPrice;
        } else {
            throw new InsufficientBalanceException();
        }

        return newPrice;
    }

    //Method to print out all of the available discount information as a String
    public static String getAvailableDiscountInformation() {
        String info = "Discounts available are : Family - 15% and Student - 10%";
        System.out.println(info);
        return info;
    }

    //Test harness to test the methods created in the Customer class
    public static void main(String[] args) throws InsufficientBalanceException {
        Customer cus1 = new Customer("John", "1", 21, 0, personalDiscountEnum.NONE);
        cus1.addFunds(10);
        System.out.println(cus1.getAccountNumber());
        System.out.println(cus1.useAttraction(67));
        System.out.println(cus1.toString());
        System.out.println(cus1.getPersonalDiscount());
    }



}
