package FunCorpPark;

public class RollerCoaster extends Attraction {
    private String name;
    private int basePrice;
    private String type;
    private double speed;

    public RollerCoaster(String name, int basePrice, String type, double speed){
        this.name = name;
        this.basePrice = basePrice;
        this.type = type;
        this.speed = speed;
    }

    @Override
    public int getOffPeakPrice() {
        return 0;
    }

    @Override
    public String toString(){
        String out = this.name + "@" + Integer.toString(this.basePrice) + "@" + this.type + "@" + Double.toString(this.speed);
        return out;
    }

    public static void main(String[] args) {
        RollerCoaster rol1 = new RollerCoaster("Rol1", 100, "ROL", 12.3);
        System.out.println(rol1.toString());
    }

}
