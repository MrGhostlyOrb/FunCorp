package FunCorpPark;

public class InvalidCreationException extends Exception {

    private String message;

    public InvalidCreationException() {
        message = "Sorry, that Attraction/Customer could not be created";
    }

    @Override

    public String toString() {
        return message;
    }
}
