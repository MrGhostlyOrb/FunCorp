package FunCorpPark;

public class ActionNotFoundException extends Exception {

    private String message;

    public ActionNotFoundException() {
        message = "Sorry, the action you were looking for could not be found, please try again";
    }

    @Override

    public String toString() {
        return message;
    }
}
