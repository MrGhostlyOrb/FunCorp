package FunCorpPark;

public class Customer {

    public void setPersonalDiscount(personalDiscountEnum personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public enum personalDiscountEnum {
        STUDENT(0.9), FAMILY(0.85), NONE(0);

        private final double i;

        personalDiscountEnum(double i) {
            this.i = i;
        }

        public double getI() {
            return i;
        }
    }

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

    private String name;
    private String accountNumber;
    private int age;
    private int accountBalance;
    private personalDiscountEnum personalDiscount;

    @Override

    public String toString() {
        String accountNumberString = accountNumber;
        String ageString = Integer.toString(age);
        String accountBalanceString = Integer.toString(accountBalance);
        String out = name + " " + accountNumberString + " " + ageString + " " + accountBalanceString + " " + personalDiscount;
        return out;
    }

    public void addFunds(int funds) {
        accountBalance = accountBalance + funds;
        System.out.println("New balance is : " + accountBalance);
    }

    public void useAttraction(int price) {
        accountBalance = accountBalance - price;
    }

    public void useAttraction(int price, int minimumAge) throws AgeRestrictionException {
        if (this.age > minimumAge) {
            accountBalance = accountBalance - price;
        } else {
            throw new AgeRestrictionException();
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
