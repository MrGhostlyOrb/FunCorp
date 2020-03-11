/***********************************************************************************************************************

 File        : ThemePark.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : This class is used to store information about a ThemePark such as a name, list of attractions at the
 ThemePark and a list of all the customers. It also contains several methods for adding and removing
 attractions/customers from the ThemePark and 3 special methods for calculating the totalTransportDistance,
 averageGentleCapacity and the medianCoasterSpeed.

 **********************************************************************************************************************/

package FunCorpPark;

import java.util.ArrayList;

public class ThemePark {

    private String name;
    private ArrayList<Attraction> attractions;
    private ArrayList<Customer> customers;

    public ThemePark() {
        this.attractions = new ArrayList<Attraction>();
        this.customers = new ArrayList<Customer>();
        this.name = "";
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public ArrayList<Attraction> getAttractions() {
        return this.attractions;
    }

    public int calculateTotalTransportDistance() {
        int totalDist = 0;
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getType().equals("TRA")) {
                TransportAttraction attr = (TransportAttraction) attractions.get(i);
                totalDist = totalDist + attr.getDistance();
            }
        }
        return totalDist;
    }

    public double calculateAverageGentleCapacity() {
        double totalCapacity = 0;
        int count = 0;
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getType().equals("GEN")) {
                GentleAttraction attr = (GentleAttraction) attractions.get(i);
                totalCapacity = totalCapacity + attr.getNoPeople();
                count++;
            }
        }
        return totalCapacity / count;
    }

    public double calculateMedianCoasterSpeed() {
        //Use ArrayList to store    l speeds and then choose middle value to find median
        ArrayList<Double> avgSpeed = new ArrayList<Double>();
        int count = 0;
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getType().equals("ROL")) {
                RollerCoaster attr = (RollerCoaster) attractions.get(i);
                avgSpeed.add(attr.getSpeed());
                count++;
            }
        }
        return avgSpeed.get(count / 2);
    }

    public void addAttraction(Attraction newAttraction) {
        this.attractions.add(newAttraction);
    }

    public void addCustomer(Customer newCustomer) {
        this.customers.add(newCustomer);
    }

    public Customer getCustomer(String accountNumber) {

        Customer foundCustomer = null;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getAccountNumber().equals(accountNumber)) {
                System.out.println("Found customer : " + customers.get(i).getName());
                foundCustomer = customers.get(i);
                break;
            } else if (i == customers.size() - 1) {
            }
        }
        return foundCustomer;
    }

    public void removeCustomer(String accountNumber) {

        for (int i = 0; i < customers.size(); i++) {
            try {

                if (customers.get(i).getAccountNumber().equals(accountNumber)) {
                    customers.remove(i);
                } else {
                    throw new CustomerNotFoundException();
                }
            } catch (CustomerNotFoundException e) {
                System.out.println(e);
                System.out.println("Sorry, customer could not be found");
            }
        }
    }

    public Attraction getAttraction(String attractionName) {
        Attraction foundAttraction = null;

        for (int i = 0; i < attractions.size(); i++) {
            try {

                if (attractions.get(i).getName().equals(attractionName)) {
                    System.out.println("Found attraction : " + attractions.get(i).getName());
                    foundAttraction = attractions.get(i);
                    break;
                } else if (i == attractions.size() - 1) {
                    throw new AttractionNotFoundException();
                }
            } catch (AttractionNotFoundException e) {
                System.out.println(e);
                System.out.println("Sorry, attraction could not be found");
                //TODO fix attractions with space at the end not being found
            }
        }
        return foundAttraction;
    }

    public void removeAttraction(String attractionName) {

        for (int i = 0; i < attractions.size(); i++) {
            try {

                if (attractions.get(i).getName().equals(attractionName)) {
                    attractions.remove(i);
                } else {
                    throw new AttractionNotFoundException();
                }
            } catch (AttractionNotFoundException e) {
                System.out.println(e);
                System.out.println("Sorry, attraction could not be found");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttractions(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public static void main(String[] args) {
        ThemePark park = new ThemePark();

        Customer cus = new Customer("Dave", "12000", 15, 1200, Customer.personalDiscountEnum.FAMILY);
        park.addCustomer(cus);

        System.out.println(park.getCustomers());

        Attraction rol = new RollerCoaster("roller coaster ", 12, "ROL", 7, 12.1);
        park.addAttraction(rol);

        Attraction rol2 = new RollerCoaster("roller coaster2", 12, "ROL", 7, 12.1);
        park.addAttraction(rol);

        System.out.println(rol.toString() + rol2.toString());
        System.out.println(rol.getName().trim());
        System.out.println(rol2.getName().trim());
    }


}
