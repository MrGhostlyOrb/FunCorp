/***********************************************************************************************************************

 File        : Attraction.java
 Author      : 100237847
 Date        : 20/03/2020
 Description :

 **********************************************************************************************************************/

package FunCorpPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //Main method to being program
    public static void main(String[] args) throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException, NoSuchFieldException, RideNotFoundException {

        ThemePark park = createThemePark();

        //Run 3 methods from ThemePark to return Total Distance, Capacity and Top Speed
        System.out.println(park.calculateTotalTransportDistance());
        System.out.println(park.calculateAverageGentleCapacity());
        System.out.println(park.calculateMedianCoasterSpeed());

        simulate(park);

    }

    //Method to create a ThemePark by reading in information from customers.txt and attractions.txt
    public static ThemePark createThemePark() throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException {


        ThemePark park = new ThemePark();

        Attraction newAttraction = new RollerCoaster("hi", 3, "ROL", 7, 12.1);
        park.addAttraction(newAttraction);

        System.out.println(park.getAttractions());

        readAttractions(park);
        readCustomers(park);

        System.out.println("Theme Park Created");
        System.out.println("Simulation about to begin");


        return park;
    }

    //Method to simulate the actions from transactions.txt
    public static void simulate(ThemePark park) throws FileNotFoundException, CustomerNotFoundException, RideNotFoundException {
        readTransactions(park);
    }

    //Method to simplify reading from files
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        File file = new File(fileName);
        Scanner line = new Scanner(file);
        line.useDelimiter(System.lineSeparator());
        while (line.hasNext()) {
            String lineInfo = line.next();
            lines.add(lineInfo);
        }
        return lines;
    }

    //Method to read information from attractions.txt and add to ThemePark
    public static void readAttractions(ThemePark park) throws FileNotFoundException, AttractionNotFoundException {

        ArrayList<String> list = readFile("attractions.txt");
        for (int i = 0; i < list.size(); i++) {
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("@");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }
            try {
                if (itemList.get(2).equals("ROL")) {
                    Attraction rol = new RollerCoaster(itemList.get(0).trim(), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)), Double.parseDouble(itemList.get(4)));
                    park.addAttraction(rol);
                } else if (itemList.get(2).equals("GEN")) {
                    Attraction gen = new GentleAttraction(itemList.get(0).trim(), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                    park.addAttraction(gen);
                } else if (itemList.get(2).equals("TRA")) {
                    Attraction tra = new TransportAttraction(itemList.get(0).trim(), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                    park.addAttraction(tra);
                } else {
                    System.out.println("Not Found");
                    throw new InvalidCreationException();

                }
            } catch (NumberFormatException | InvalidCreationException e) {
                System.out.println(e);
            }


        }
    }

    //Method to read information from the customers.txt file
    public static void readCustomers(ThemePark park) throws FileNotFoundException, CustomerNotFoundException {

        //Create list to store file information for parsing
        ArrayList<String> list = readFile("customers.txt");

        //Loop through list to get each piece of information
        for (int i = 0; i < list.size(); i++) {
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("#");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }

            //Try to add all customer information found to the ThemePark
            try {

                //If statement to determine the type of Customer to add the the ThemePark
                if (itemList.size() < 5) {

                    //Create new Customer with the information and add to the ThemePark
                    Customer none = new Customer(itemList.get(1), itemList.get(0), Integer.parseInt(itemList.get(2)), Integer.parseInt(itemList.get(3)), Customer.personalDiscountEnum.NONE);
                    System.out.println("Added " + none.toString());
                    park.addCustomer(none);
                } else if (itemList.get(4).trim().equals("FAMILY")) {


                    Customer fam = new Customer(itemList.get(1), itemList.get(0), Integer.parseInt(itemList.get(2)), Integer.parseInt(itemList.get(3)), Customer.personalDiscountEnum.valueOf(itemList.get(4).toUpperCase().trim()));
                    System.out.println("Added " + fam.toString());
                    park.addCustomer(fam);
                } else if (itemList.get(4).trim().equals("STUDENT")) {
                    Customer stu = new Customer(itemList.get(1), itemList.get(0), Integer.parseInt(itemList.get(2)), Integer.parseInt(itemList.get(3)), Customer.personalDiscountEnum.valueOf(itemList.get(4).toUpperCase().trim()));
                    System.out.println("Added " + stu.toString());
                    park.addCustomer(stu);
                } else {
                    throw new InvalidCreationException();
                }

                //Catch any information that could not be added to the ThemePark from the file
            } catch (InvalidCreationException e) {
                System.out.println(e);
            }


        }
    }

    //Method to read information from the transactions.txt file
    public static void readTransactions(ThemePark park) throws FileNotFoundException, NumberFormatException {

        boolean pass = false;

        ArrayList<String> list = readFile("transactions.txt");
        for (int i = 0; i < list.size(); i++) {
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter(",");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }
            System.out.println(itemList.get(0));

            //Try to determine the action to be done and the price to ride Attraction
            try {
                if (itemList.get(0).equals("USE_ATTRACTION")) {

                    Customer currentCustomer = park.getCustomer(itemList.get(2));
                    Attraction currentAttraction = park.getAttraction(itemList.get(3));

                    if (itemList.get(1).equals("STANDARD_PRICE")) {
                        //Find customer, determine ride type and apply reduction to funds
                        currentCustomer.useAttraction(currentAttraction.getBasePrice());
                    } else if (itemList.get(1).equals("OFF_PEAK")) {
                        //Apply off peak pricing to customer's purchase //TODO fix issue when customers are not found
                        if(pass == false) {
                            try {
                                if(pass = false){
                                    throw new CustomerNotFoundException();
                                }
                                else{
                                    currentCustomer.useAttraction(currentAttraction.getOffPeakPrice());
                                }


                            }
                            catch(CustomerNotFoundException e){

                            }
                            }
                        else{
                            System.out.println("Skipped action");
                            pass = false;
                        }

                        }
                } else if (itemList.get(0).equals("ADD_FUNDS")) {
                    //Add provided funds to the customer's account balance
                    Customer currentCustomer = park.getCustomer(itemList.get(1));
                    int amount = Integer.parseInt(itemList.get(2));
                    System.out.println("Amount before adding funds : " + currentCustomer.getAccountBalance());
                    currentCustomer.addFunds(amount);
                } else if (itemList.get(0).equals("NEW_CUSTOMER")) {
                    //Create a new customer object and add it to the park
                    System.out.println(itemList.size());

                    if(itemList.size() > 5) {
                        park.addCustomer(new Customer(itemList.get(1), itemList.get(2), Integer.parseInt(itemList.get(3)), Integer.parseInt(itemList.get(4)), Customer.personalDiscountEnum.valueOf(itemList.get(5))));
                    }
                    else{
                        park.addCustomer(new Customer(itemList.get(1), itemList.get(2), Integer.parseInt(itemList.get(3)), Integer.parseInt(itemList.get(4)), Customer.personalDiscountEnum.NONE));
                    }
                } else {
                    //Throw action not found Exception if the transaction line cannot be read
                    throw new ActionNotFoundException();
                }
            }
            catch (ActionNotFoundException | CustomerNotFoundException e){
                System.out.println(e);
                pass = true;
                System.out.println("(1)");
                readTransactions(park);
            }

        }
    }

}
