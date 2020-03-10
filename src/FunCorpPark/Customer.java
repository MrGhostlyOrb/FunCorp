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

    public void setPersonalDiscount(personalDiscountEnum personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public enum personalDiscountEnum {
        STUDENT(0.9), FAMILY(0.85), NONE(0);

        private final double discountEnum;

        personalDiscountEnum(double i) {
            this.discountEnum = i;
        }

        public double getDiscountEnum() {
            return discountEnum;
        }
    }

    private String accountNumber;
    private String name;
    private int age;
    private int accountBalance;
    private personalDiscountEnum personalDiscount;

    public Customer(String name, String accountNumber, int age, int accountBalance, personalDiscountEnum personalDiscount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.accountBalance = accountBalance;
        this.personalDiscount = personalDiscount;
    }

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

    @Override

    public String toString() {
        String accountNumberString = accountNumber;
        String ageString = Integer.toString(age);
        String accountBalanceString = Integer.toString(accountBalance);
        String out = name + " " + accountNumberString + " " + ageString + " " + accountBalanceString + " " + personalDiscount;
        return out;
    }

    public void addFunds(int amount) {
        accountBalance = accountBalance + amount;
        System.out.println("New balance is : " + accountBalance);
    }

    public void useAttraction(int price) {

        int newPrice = (int) (price * this.getPersonalDiscount().getDiscountEnum());
        System.out.println("Price for ride is : " + newPrice);

        try {

            if (accountBalance < (price * this.personalDiscount.getDiscountEnum())) {
                throw new InsufficientBalanceException();
            }

            accountBalance = (int) (accountBalance - (price * this.personalDiscount.getDiscountEnum()));

        } catch (Exception e) {
            System.out.println(e);
            System.out.println(accountBalance);
            System.out.println(price);
            System.out.println("Code here to fix InsufficientBalanceException");
        }
    }

    public void useAttraction(int price, int minimumAge) {

        int newPrice = (int) (price * this.getPersonalDiscount().getDiscountEnum());
        System.out.println("Price for ride is : " + newPrice);

        try {
            //TODO fix account being charged twice here
            System.out.println("Checking age");
            if (this.age >= minimumAge) {
                accountBalance = (int) (accountBalance - (price * this.personalDiscount.getDiscountEnum()));
            } else {
                throw new AgeRestrictionException();
            }
            System.out.println("Checking balance");
            if (this.accountBalance > (price * this.personalDiscount.getDiscountEnum())) {
                accountBalance = (int) (accountBalance - (price * this.personalDiscount.getDiscountEnum()));
            } else {
                throw new InsufficientBalanceException();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(accountBalance);
            System.out.println(price * this.personalDiscount.getDiscountEnum());
            System.out.println("Code here to fix InsufficientBalanceException (1)");
        }
    }

    public static String getAvailableDiscountInformation() {
        String info = "Discounts available are : Family - 15% and Student - 10%";
        System.out.println(info);
        return info;
    }

    public static void main(String[] args) {
        // Customer cus1 = new Customer("John", "1", 21, 0, "none");
        //cus1.addFunds(10);
        //System.out.println(cus1.toString());
        //System.out.println(cus1.getPersonalDiscount());
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public personalDiscountEnum getPersonalDiscount() {
        return this.personalDiscount;
    }

}
