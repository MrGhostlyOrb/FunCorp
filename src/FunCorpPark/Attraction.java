package FunCorpPark;

public abstract class Attraction {

    private String name;
    private int basePrice;
    private String type;

    public abstract int getOffPeakPrice();

    public String getName(){
        return name;
    }

    public String getType(){
        return this.type;
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

    public void setType(String type) {
        this.type = type;
    }

    public static void main(String[] args) {
        System.out.println("This is a test");

        Attraction att = new Attraction() {
            @Override
            public int getOffPeakPrice() {
                return 0;
            }
        };
        System.out.println(att.getBasePrice());
        System.out.println(att.getType());
        System.out.println(att.getName());
    }
}
