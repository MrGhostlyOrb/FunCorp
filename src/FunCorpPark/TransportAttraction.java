package FunCorpPark;

public class TransportAttraction extends Attraction {

    private String name;
    private int basePrice;
    private String type;
    private int distance;

    public TransportAttraction(String name, int basePrice, String type, int distance){
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.distance = distance;

    }

    public int getDistance() {
        return distance;
    }

    public String getType(){
        return this.type;
    }

    @Override
    public int getOffPeakPrice() {
        return 0;
    }
}
