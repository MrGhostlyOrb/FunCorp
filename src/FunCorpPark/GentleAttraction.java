package FunCorpPark;

public class GentleAttraction extends Attraction {

    private String name;
    private int basePrice;
    private String type;
    private int noPeople;

    public GentleAttraction(String name, int basePrice, String type, int noPeople){
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.noPeople = noPeople;
    }

    public int getNoPeople(){
        return this.noPeople;
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

    public void setNoPeople(int noPeople) {
        this.noPeople = noPeople;
    }
}
