package FunCorpPark;

public class Customer {

    private String name;
    private int accountNumber;
    private int age;
    private int accountBalance;
    private int personalDiscount;

    public Customer(String name, int accountNumber, int age, int accountBalance, int personalDiscount){
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.accountBalance = accountBalance;
        this.personalDiscount = personalDiscount;
    }

    @Override

    public String toString(){
        String accountNumberString = Integer.toString(accountNumber);
        String ageString = Integer.toString(age);
        String accountBalanceString = Integer.toString(accountBalance);
        String personalDiscountString = Integer.toString(personalDiscount);
        String out = name + " " + accountNumberString + " " + ageString + " " + accountBalanceString + " " + personalDiscountString;
        return out;
    }

    public void addFunds(int funds){
        accountBalance = accountBalance + funds;
        System.out.println("New balance is : " + accountBalance);
    }

    public void useAttraction(int price){

    }

    public String getAvailableDiscountInformation(){
        String info = "Discount available is : " + Integer.toString(personalDiscount);
        return info;
    }

    public static void main(String[] args) {
        Customer cus1 = new Customer("John", 1, 21, 0, 0);
        cus1.addFunds(10);
        System.out.println(cus1.toString());
        System.out.println(cus1.getAvailableDiscountInformation());
    }

}
