package FunCorpPark;

public class AttractionNotFoundException extends Exception {

    private String message;

    public AttractionNotFoundException() {
        message = "Sorry, the attraction you were looking for could not be found, please try again";
    }

    @Override

    public String toString() {
        return message;
    }
}
