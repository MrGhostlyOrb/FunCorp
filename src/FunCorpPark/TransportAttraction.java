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

    @Override
    public String toString() {
        return "Ride : " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getBasePrice() {
        return basePrice;
    }

    @Override
    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
