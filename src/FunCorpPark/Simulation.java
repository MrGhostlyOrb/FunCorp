/***********************************************************************************************************************

 File        : Simulation.java
 Author      : 100237847
 Date        : 20/03/2020
 Description : This is the main class of the project that is used to read in all of the information from the various
 source files and create a new ThemePark that can then be simulated through the tasks in the transactions.txt file.
 **********************************************************************************************************************/

package FunCorpPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //Main method to being program
    public static void main(String[] args) throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException, NoSuchFieldException, RideNotFoundException, AgeRestrictionException {

        ThemePark park = createThemePark();

        //Run 3 methods from ThemePark to return Total Distance, Capacity and Top Speed
        System.out.println("Total Distance : " + park.calculateTotalTransportDistance());
        System.out.println("Average Capacity : " + park.calculateAverageGentleCapacity());
        System.out.println("Median Speed : " + park.calculateMedianCoasterSpeed());

        simulate(park);

    }

    //Method to create a ThemePark by reading in information from customers.txt and attractions.txt
    public static ThemePark createThemePark() throws FileNotFoundException, AttractionNotFoundException {


        ThemePark park = new ThemePark();

        readAttractions(park);
        readCustomers(park);

        System.out.println("Theme Park Created");
        System.out.println("Simulation about to begin");


        return park;
    }

    //Method to simulate the actions from transactions.txt
    public static void simulate(ThemePark park) throws FileNotFoundException {
        readTransactions(park);
    }

    //Method to simplify reading from files
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
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
        for (String info : list) {
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("@");
            ArrayList<String> itemList = new ArrayList<>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }
            try {
                switch (itemList.get(2)) {
                    case "ROL":
                        Attraction rol = new RollerCoaster(itemList.get(0).trim(), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)), Double.parseDouble(itemList.get(4)));
                        park.addAttraction(rol);
                        break;
                    case "GEN":
                        Attraction gen = new GentleAttraction(itemList.get(0).trim(), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                        park.addAttraction(gen);
                        break;
                    case "TRA":
                        Attraction tra = new TransportAttraction(itemList.get(0).trim(), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                        park.addAttraction(tra);
                        break;
                    default:
                        System.out.println("Not Found");
                        throw new InvalidCreationException();

                }
            } catch (NumberFormatException | InvalidCreationException e) {
                System.out.println(e);
            }


        }
    }

    //Method to read information from the customers.txt file
    public static void readCustomers(ThemePark park) throws FileNotFoundException {

        //Create list to store file information for parsing
        ArrayList<String> list = readFile("customers.txt");

        //Loop through list to get each piece of information
        for (String info : list) {
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("#");
            ArrayList<String> itemList = new ArrayList<>();
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
                System.out.println(e.toString());
            }


        }
    }

    //Method to read information from the transactions.txt file
    public static void readTransactions(ThemePark park) throws FileNotFoundException, NumberFormatException {

        //Variable to store the total profit for the transactions file
        int tot = 0;

        ArrayList<String> list = readFile("transactions.txt");
        for (String info : list) {
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter(",");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }
            //Print out the action about to be taken
            System.out.println("\n" + itemList.get(0));

            try {

                //Run helper methods to check which action to take and take it
                switch (itemList.get(0)) {
                    case "USE_ATTRACTION":
                        int prof = useAttractionHelp(itemList, park);
                        tot = tot + prof;
                        System.out.println("total = " + tot);
                        break;
                    case "ADD_FUNDS":
                        addFundsHelp(itemList, park);
                        break;
                    case "NEW_CUSTOMER":
                        newCustomerHelp(itemList, park);
                        break;
                    default:
                        throw new ActionNotFoundException();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        NumberFormat formatter = new DecimalFormat("#0.00");
        String profit = formatter.format(tot / 100);
        System.out.println("Total profit for the day : £" + profit);
    }

    private static void newCustomerHelp(ArrayList<String> itemList, ThemePark park) {
        if (itemList.size() > 5) {
            park.addCustomer(new Customer(itemList.get(2), itemList.get(1), Integer.parseInt(itemList.get(3)), Integer.parseInt(itemList.get(4)), Customer.personalDiscountEnum.valueOf(itemList.get(5))));
        } else {
            park.addCustomer(new Customer(itemList.get(2), itemList.get(1), Integer.parseInt(itemList.get(3)), Integer.parseInt(itemList.get(4)), Customer.personalDiscountEnum.NONE));
        }
        System.out.print(itemList.get(2));
    }

    private static void addFundsHelp(ArrayList<String> itemList, ThemePark park) {
        Customer currentCustomer = null;

        try {
            currentCustomer = park.getCustomer(itemList.get(1));
            if (currentCustomer == null) {
                throw new CustomerNotFoundException();
            }

            int amount = Integer.parseInt(itemList.get(2));
            System.out.println("Amount before adding funds : " + currentCustomer.getAccountBalance());
            currentCustomer.addFunds(amount);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.toString());
        }

    }

    private static int useAttractionHelp(ArrayList<String> itemList, ThemePark park) {

        int tot = 0;

        Customer currentCustomer = null;
        Attraction currentAttraction = null;

        //Find the customer and attraction from the file
        try {
            currentCustomer = park.getCustomer(itemList.get(2));
            currentAttraction = park.getAttraction(itemList.get(3));
            if (currentCustomer == null) {
                throw new CustomerNotFoundException();
            } else if (currentAttraction == null) {
                throw new RideNotFoundException();
            }

            System.out.println("Balance before using attraction : " + currentCustomer.getAccountBalance());

            if (itemList.get(0).equals("USE_ATTRACTION")) {
                //Check the price for the attraction
                if (itemList.get(1).equals("STANDARD_PRICE")) {
                    //Check the type of attraction that the customer wishes to use
                    if (currentAttraction.getType().equals("ROL")) {
                        //Perform the action
                        RollerCoaster rolAttraction = (RollerCoaster) currentAttraction;
                        tot = currentCustomer.useAttraction(currentAttraction.getBasePrice(), rolAttraction.getMinAge());
                    } else {
                        tot = currentCustomer.useAttraction(currentAttraction.getBasePrice());
                    }
                } else {
                    if (currentAttraction.getType().equals("ROL")) {
                        RollerCoaster rolAttraction = (RollerCoaster) currentAttraction;
                        tot = currentCustomer.useAttraction(currentAttraction.getOffPeakPrice(), rolAttraction.getMinAge());
                    } else {
                        tot = currentCustomer.useAttraction(currentAttraction.getOffPeakPrice());
                    }
                }
                System.out.println(tot);
            }

            System.out.println("Current balance : " + currentCustomer.getAccountBalance());

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        //Check for use attraction action
        return tot;
    }
}
