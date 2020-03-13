/***********************************************************************************************************************

 File        : TransportAttraction.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : This class is designed to store all of the information about a TransportAttraction such as its name,
 basePrice, type and distance. It also includes getters and setters along with an appropriate toString.
 **********************************************************************************************************************/

package FunCorpPark;

public class TransportAttraction extends Attraction {

    private String name;
    private int basePrice;
    private String type;
    private int distance;

    public TransportAttraction(String name, int basePrice, String type, int distance) {
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.distance = distance;

    }

    public int getDistance() {
        return distance;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public int getOffPeakPrice() {
        return (int) (basePrice * 0.5);
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

    @Override
    public String toString() {
        return name + "@" + basePrice + "@" + type + "@" + distance;
    }

    public static void main(String[] args) {
        TransportAttraction att = new TransportAttraction("Transport", 5, "TRA", 100);
        System.out.println(att.getDistance());
        System.out.println(att.getBasePrice());
        att.setName("Tra");
        System.out.println(att.getName());
    }
}
