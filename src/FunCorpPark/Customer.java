package FunCorpPark;

public class Customer {

    public enum personalDiscountEnum{STUDENT(10), FAMILY(15), NONE(0);

        private final int i;

        personalDiscountEnum(int i) {
            this.i = i;
        }
        public int getI(){
            return i;
        }
    };

    private String name;
    private String accountNumber;
    private int age;
    private int accountBalance;
    private personalDiscountEnum personalDiscount;


    public Customer(String name, String accountNumber, int age, int accountBalance, personalDiscountEnum personalDiscount){
        this.name = name;
        this.accountNumber = accountNumber;
        this.age = age;
        this.accountBalance = accountBalance;
        this.personalDiscount = personalDiscount;
    }

    @Override

    public String toString(){
        String accountNumberString = accountNumber;
        String ageString = Integer.toString(age);
        String accountBalanceString = Integer.toString(accountBalance);
        String out = name + " " + accountNumberString + " " + ageString + " " + accountBalanceString + " " + personalDiscount;
        return out;
    }

    public void addFunds(int funds){
        accountBalance = accountBalance + funds;
        System.out.println("New balance is : " + accountBalance);
    }

    public void useAttraction(int price){

    }

    public static String getAvailableDiscountInformation(){
        String info = "Discount available is : ";
        return info;
    }

    public static void main(String[] args) {
       // Customer cus1 = new Customer("John", "1", 21, 0, "none");
        //cus1.addFunds(10);
        //System.out.println(cus1.toString());
        //System.out.println(cus1.getPersonalDiscount());
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public personalDiscountEnum getPersonalDiscount(){
        return this.personalDiscount;
    }

}
