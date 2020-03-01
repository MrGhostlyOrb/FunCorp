package FunCorpPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException, NoSuchFieldException, RideNotFoundException {

        ThemePark park = createThemePark();

        System.out.println(park.calculateTotalTransportDistance());
        System.out.println(park.calculateAverageGentleCapacity());
        System.out.println(park.calculateMedianCoasterSpeed());

        simulate(park);

    }

    public static ThemePark createThemePark() throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException {


        ThemePark park = new ThemePark();

        readAttractions(park);
        readCustomers(park);

        System.out.println("Theme Park Created");
        System.out.println("Simulation about to begin");


        return park;
    }

    public static void simulate(ThemePark park) throws FileNotFoundException, CustomerNotFoundException, RideNotFoundException {
        readTransactions(park);
    }

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

    public static void readAttractions(ThemePark park) throws FileNotFoundException, AttractionNotFoundException {

        ArrayList<String> list = readFile("src/attractions.txt");
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
                    Attraction rol = new RollerCoaster(itemList.get(0), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)), Double.parseDouble(itemList.get(4)));
                    park.addAttraction(rol);
                } else if (itemList.get(2).equals("GEN")) {
                    Attraction gen = new GentleAttraction(itemList.get(0), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                    park.addAttraction(gen);
                } else if (itemList.get(2).equals("TRA")) {
                    Attraction tra = new TransportAttraction(itemList.get(0), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                    System.out.println("got here");
                    park.addAttraction(tra);
                } else {
                    System.out.println("Not Found");
                    throw new AttractionNotFoundException();

                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }


        }
    }

    public static void readCustomers(ThemePark park) throws FileNotFoundException, CustomerNotFoundException {
        ArrayList<Customer> cus = new ArrayList<Customer>();

        ArrayList<String> list = readFile("src/customers.txt");
        for (int i = 0; i < list.size(); i++) {
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("#");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }

            try {
                if (itemList.get(4).length() < 5) {
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
                    throw new CustomerNotFoundException();
                }
            } catch (CustomerNotFoundException e) {
                System.out.println(e);
            }


        }
    }

    public static void readTransactions(ThemePark park) throws FileNotFoundException, CustomerNotFoundException, RideNotFoundException {
        ArrayList<String> list = readFile("src/transactions.txt");
        for (int i = 0; i < list.size(); i++) {
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter(",");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()) {
                String item = scanner.next();
                itemList.add(item);
            }


            try {
                if (itemList.get(0).equals("USE_ATTRACTION")) {

                    Customer currentCustomer = park.getCustomer(itemList.get(2));
                    Attraction currentAttraction = park.getAttraction(itemList.get(3));

                    if (itemList.get(1).equals("STANDARD_PRICE")) {
                        //Find customer, determine ride type and apply reduction to funds
                        currentCustomer.useAttraction(currentAttraction.getBasePrice());
                    } else if (itemList.get(1).equals("OFF_PEAK")) {
                        currentCustomer.useAttraction(currentAttraction.getOffPeakPrice());
                    }
                } else if (itemList.get(0).equals("ADD_FUNDS")) {
                    Customer currentCustomer = park.getCustomer(itemList.get(1));
                    int amount = Integer.parseInt(itemList.get(2));
                    System.out.println("Amount before adding funds : " + currentCustomer.getAccountBalance());
                    currentCustomer.addFunds(amount);
                    System.out.println("Amount after adding funds : " + currentCustomer.getAccountBalance());
                } else if (itemList.get(0).equals("NEW_CUSTOMER")) {
                    //Create a new customer object and add it to the park
                    park.addCustomer(new Customer(itemList.get(1), itemList.get(2), Integer.parseInt(itemList.get(3)), Integer.parseInt(itemList.get(5)), Customer.personalDiscountEnum.valueOf(itemList.get(6))));

                } else {
                    throw new ActionNotFoundException();
                }
            }
            catch (ActionNotFoundException e){
                System.out.println(e);
            }

        }
    }

}
