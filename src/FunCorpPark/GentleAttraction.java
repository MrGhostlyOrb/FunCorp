/***********************************************************************************************************************

 File        : GentleAttraction.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : This is a class designed to store information about GentleAttractions in the ThemePark. It includes
 information such as: name, basePrice, type, and the noPeople for the attraction along with various getters and setters
 and an appropriate toString.
 **********************************************************************************************************************/

package FunCorpPark;

public class GentleAttraction extends Attraction {

    private int noPeople;

    //Constructor for the GentleAttraction class that inherits from the super Attraction class
    public GentleAttraction(String name, int basePrice, String type, int noPeople) {
        super(name, basePrice, type);
        this.noPeople = noPeople;
    }

    //Getter and setter methods
    public int getNoPeople() {
        return this.noPeople;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public int getOffPeakPrice() {
        return (int) (this.basePrice * 0.8);
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

    @Override

    public String toString() {
        return name + "@" + basePrice + "@" + type + "@" + noPeople;
    }

    //Test harness for the GentleAttraction class
    public static void main(String[] args) {
        GentleAttraction att = new GentleAttraction("Gentle", 5, "GEN", 100);
        System.out.println(att.getNoPeople());
        System.out.println(att.getBasePrice());
        att.setName("Gen");
        System.out.println(att.getName());
    }

}
