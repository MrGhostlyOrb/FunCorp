package FunCorpPark;

import java.util.ArrayList;

public class ThemePark {

    private String name;
    private ArrayList<Attraction> attractions;
    private ArrayList<Customer> customers;

    public ThemePark(String name, ArrayList<Attraction> attractions, ArrayList<Customer> customers){
        this.name = name;
        this.attractions = attractions;
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }

    public ArrayList<Attraction> getAttractions(){
        return this.attractions;
    }

    public int calculateTotalTransportDistance() throws NoSuchFieldException {
        int totalDist = 0;
        for(int i = 0; i < attractions.size(); i++){
            if(attractions.get(i).getType().equals("TRA")){
                TransportAttraction attr = (TransportAttraction) attractions.get(i);
                totalDist = totalDist + attr.getDistance();
            }
        }
        return totalDist;
    }

    public double calculateAverageGentleCapacity(){
        double totalCapacity = 0;
        int count = 0;
        for(int i = 0; i < attractions.size(); i++){
            if(attractions.get(i).getType().equals("GEN")){
                GentleAttraction attr = (GentleAttraction) attractions.get(i);
                totalCapacity = totalCapacity + attr.getNoPeople();
                count++;
            }
        }
        return totalCapacity / count;
    }

    public double calculateMedianCoasterSpeed(){ //TODO Median
        double avgSpeed = 0;
        int count = 0;
        for(int i = 0; i < attractions.size(); i++){
            if(attractions.get(i).getType().equals("ROL")){
                RollerCoaster attr = (RollerCoaster) attractions.get(i);
                avgSpeed = avgSpeed + attr.getSpeed();
                count++;
            }
        }
        return avgSpeed/count;
    }

}
