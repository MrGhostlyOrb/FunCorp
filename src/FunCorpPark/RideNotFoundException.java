package FunCorpPark;

public class RideNotFoundException extends Exception {

    private String message;

    public RideNotFoundException() {
        message = "Sorry, the ride you are looking for could not be found, please try again";
    }

    @Override

    public String toString() {
        return message;
    }
}
