/***********************************************************************************************************************

 File        : Attraction.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : This class is designed to be an abstract class to store the basic information about all of the
 attractions at a ThemePark. It includes an abstract method for returning the offPeakPrice for any of the attractions
 along with various getter and setter methods and a toString.
 **********************************************************************************************************************/

package FunCorpPark;

public abstract class Attraction {

    protected String name;
    protected int basePrice;
    protected String type;

    //Constructor for the super attraction class
    public Attraction(String name, int basePrice, String type){
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
    }

    //Abstract method to return the off peak price for a particular attraction
    public abstract int getOffPeakPrice();

    public String getName() {
        return name;
    }

    public String getType() {
        return this.type;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override

    public String toString() {
        String basePriceString = Integer.toString(basePrice);
        return name + " " + basePriceString + ":Base price";
    }

    public static void main(String[] args) {
        System.out.println("This is a test");
    }
}
