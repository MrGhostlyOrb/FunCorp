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

    @Override
    public int getOffPeakPrice() {
        return 0;
    }
}
