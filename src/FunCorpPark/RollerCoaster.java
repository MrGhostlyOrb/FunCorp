/***********************************************************************************************************************

 File        : Attraction.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : Extension of the Attraction class in order to categorise Rollercoasters for the themepark
 **********************************************************************************************************************/

package FunCorpPark;

public class RollerCoaster extends Attraction {
    private String name;
    private int basePrice;
    private String type;
    private int minAge;
    private double speed;

    public RollerCoaster(String name, int basePrice, String type, int minAge, double topSpeed) {
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.minAge = minAge;
        this.speed = topSpeed;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public double getSpeed() {
        return this.speed;
    }

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

    public static void main(String[] args) {
        RollerCoaster rol1 = new RollerCoaster("Rol1", 100, "ROL", 12, 12.3);
        System.out.println(rol1.toString());
    }

}
