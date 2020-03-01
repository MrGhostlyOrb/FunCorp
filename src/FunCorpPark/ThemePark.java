package FunCorpPark;

import java.util.ArrayList;

public class ThemePark {

    private String name;
    private ArrayList<Attraction> attractions;
    private ArrayList<Customer> customers;

    public ThemePark(){
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

    public void addAttraction(Attraction newAttraction){
        this.attractions.add(newAttraction);
    }

    public void addCustomer(Customer newCustomer){
        this.customers.add(newCustomer);
    }

    public Customer getCustomer(String accountNumber) throws CustomerNotFoundException {

        Customer foundCustomer = null;

        for(int i = 0; i < customers.size(); i++){
            try {

                if (customers.get(i).getAccountNumber().equals(accountNumber)) {
                    foundCustomer = customers.get(i);
                } else {
                    throw new CustomerNotFoundException();
                }
            }
            catch (CustomerNotFoundException e){
                System.out.println(e);
                System.out.println("Sorry, customer could not be found");
            }
        }
        return foundCustomer;
    }

    public void removeCustomer(String accountNumber){

        for(int i = 0; i < customers.size(); i++){
            try {

                if (customers.get(i).getAccountNumber().equals(accountNumber)) {
                    customers.remove(i);
                } else {
                    throw new CustomerNotFoundException();
                }
            }
            catch (CustomerNotFoundException e){
                System.out.println(e);
                System.out.println("Sorry, customer could not be found");
            }
        }
    }

    public Attraction getAttraction(String attractionName){
        Attraction foundAttraction = null;

        for(int i = 0; i < attractions.size(); i++){
            try {

                if (attractions.get(i).getName().equals(attractionName)) {
                    foundAttraction = attractions.get(i);
                } else {
                    throw new AttractionNotFoundException();
                }
            }
            catch (AttractionNotFoundException e){
                System.out.println(e);
                System.out.println("Sorry, attraction could not be found");
            }
        }
        return foundAttraction;
    }

    public void removeAttraction(String attractionName){

        for(int i = 0; i < attractions.size(); i++){
            try {

                if (attractions.get(i).getName().equals(attractionName)) {
                    attractions.remove(i);
                } else {
                    throw new AttractionNotFoundException();
                }
            }
            catch (AttractionNotFoundException e){
                System.out.println(e);
                System.out.println("Sorry, attraction could not be found");
            }
        }
    }

}
