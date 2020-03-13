package FunCorpPark;

public class InsufficientBalanceException extends Exception {

    private String message;

    public InsufficientBalanceException() {
        message = "Sorry, you do not have enough balance to complete that transaction, please add more funds";
    }

    @Override

    public String toString() {
        return message;
    }
}
