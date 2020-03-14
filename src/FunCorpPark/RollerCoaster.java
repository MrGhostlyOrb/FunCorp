/***********************************************************************************************************************

 File        : Attraction.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : Extension of the Attraction class in order to categorise Rollercoasters for the themepark
 **********************************************************************************************************************/

package FunCorpPark;

public class RollerCoaster extends Attraction {
    private int minAge;
    private double speed;

    //Constructor for the RollerCoaster class that inherits from the super Attraction class
    public RollerCoaster(String name, int basePrice, String type, int minAge, double topSpeed) {
        super(name, basePrice, type);
        this.minAge = minAge;
        this.speed = topSpeed;
    }

    //Getter and setter methods
    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public double getSpeed() {
        return this.speed;
    }

    //Method inherited from the Attraction class to get the off peak price
    @Override
    public int getOffPeakPrice() {
        return this.basePrice;
    }

    @Override
    public String toString() {
        return name + "@" + basePrice + "@" + type + "@" + speed;
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

    public int getMinAge() {
        return minAge;
    }

    //Test harness for the RollerCoaster class
    public static void main(String[] args) {
        RollerCoaster rol1 = new RollerCoaster("Rol1", 100, "ROL", 12, 12.3);
        System.out.println(rol1.toString());
    }

}
