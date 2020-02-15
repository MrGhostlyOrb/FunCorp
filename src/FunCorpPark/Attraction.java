package FunCorpPark;

public abstract class Attraction {

    private String name;
    private int basePrice;

    public int getOffPeakPrice(){
        int price = 0;
        return price;
    }

    public String getName(){
        return name;
    }

    public int getBasePrice(){
        return basePrice;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBasePrice(int basePrice){
        this.basePrice = basePrice;
    }

    @Override

    public String toString(){
        String basePriceString = Integer.toString(basePrice);
        return name + " " + basePriceString + ":Base price";
    }

}