package FunCorpPark;

public class AgeRestrictionException extends Exception {

    private String message;

    public AgeRestrictionException() {
        message = "Sorry, you are not old enough to ride this attraction";
    }

    @Override

    public String toString() {
        return message;
    }

}
