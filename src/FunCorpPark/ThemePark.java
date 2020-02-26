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

    public double calculateTotalTransportDistance(){
        return 0.0;
    }

    public double calculateAverageGentleCapacity(){
        return 0.0;
    }

    public double calculateAverageCoasterSpeed(){
        return 0.0;
    }

}
