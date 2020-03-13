package FunCorpPark;

public class CustomerNotFoundException extends Exception {

    private String message;

    public CustomerNotFoundException() {
        message = "Sorry, the customer you were looking for could not be found, please try again";
    }

    @Override

    public String toString() {
        return message;
    }
}
