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

    private String name;
    private int basePrice;
    private String type;
    private int noPeople;

    public GentleAttraction(String name, int basePrice, String type, int noPeople) {
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.noPeople = noPeople;
    }

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

    public static void main(String[] args) {
        GentleAttraction att = new GentleAttraction("Gentle", 5, "GEN", 100);
        System.out.println(att.getNoPeople());
        System.out.println(att.getBasePrice());
        att.setName("Gen");
        System.out.println(att.getName());
    }

}
