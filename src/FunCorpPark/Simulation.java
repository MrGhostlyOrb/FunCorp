package FunCorpPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException {
        //TODO Fix non Static - Static reference issue
        //ThemePark park = createThemePark();
        //simulate(park);
    }


    //Should return ThemePark type
    public ThemePark createThemePark() throws FileNotFoundException, AttractionNotFoundException, CustomerNotFoundException {
        ArrayList<Attraction> attractions = readAttractions();
        ArrayList<Customer> customers = readCustomers();

        ThemePark park = new ThemePark("park", attractions, customers);
        return park;

    }

    public void simulate(ThemePark park) throws FileNotFoundException {
        readTransactions(park);
    }

    public ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        File file = new File(fileName);
        Scanner line = new Scanner(file);
        line.useDelimiter(System.lineSeparator());
        while(line.hasNext()){
            String lineInfo = line.next();
            lines.add(lineInfo);
        }
        return lines;
    }

    public ArrayList<Attraction> readAttractions() throws FileNotFoundException, AttractionNotFoundException {
        ArrayList<Attraction> att = new ArrayList<Attraction>();

        ArrayList<String> list = readFile("attractions.txt");
        for(int i = 0; i < list.size(); i++){
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("@");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()){
                String item = scanner.next();
                itemList.add(item);
            }
            if(itemList.get(2).equals("ROL")){
                Attraction rol = new RollerCoaster(itemList.get(0), Integer.parseInt(itemList.get(1)), itemList.get(2), Double.parseDouble(itemList.get(3)));
                att.add(rol);
            }
            else if(itemList.get(2).equals("GEN")){
                Attraction gen = new GentleAttraction(itemList.get(0), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                att.add(gen);
            }
            else if(itemList.get(2).equals("TRA")){
                Attraction tra = new TransportAttraction(itemList.get(0), Integer.parseInt(itemList.get(1)), itemList.get(2), Integer.parseInt(itemList.get(3)));
                att.add(tra);
            }
            else{
                throw new AttractionNotFoundException();
            }



        }
        System.out.println(att.toString());
        return att;
    }

    public ArrayList<Customer> readCustomers() throws FileNotFoundException, CustomerNotFoundException {
        ArrayList<Customer> cus = new ArrayList<Customer>();

        ArrayList<String> list = readFile("customers.txt");
        for(int i = 0; i < list.size(); i++){
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter("#");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()){
                String item = scanner.next();
                itemList.add(item);
            }
            if(itemList.get(4).equals("FAMILY")){
                Customer fam = new Customer(itemList.get(1), Integer.parseInt(itemList.get(0)), Integer.parseInt(itemList.get(2)), Integer.parseInt(itemList.get(3)), itemList.get(4));
                cus.add(fam);
            }
            else if(itemList.get(4).equals("STUDENT")){
                Customer stu = new Customer(itemList.get(1), Integer.parseInt(itemList.get(0)), Integer.parseInt(itemList.get(2)), Integer.parseInt(itemList.get(3)), itemList.get(4));
                cus.add(stu);
            }
            else if(itemList.get(4).isEmpty()){
                Customer none = new Customer(itemList.get(1), Integer.parseInt(itemList.get(0)), Integer.parseInt(itemList.get(2)), Integer.parseInt(itemList.get(3)), "None");
                cus.add(none);
            }
            else{
                throw new CustomerNotFoundException();
            }



        }
        System.out.println(cus.toString());
        return cus;
    }

    public void readTransactions(ThemePark park) throws FileNotFoundException {
        ArrayList<String> list = readFile("transactions.txt");
        for(int i = 0; i < list.size(); i++){
            String info = list.get(i);
            Scanner scanner = new Scanner(info);
            scanner.useDelimiter(",");
            ArrayList<String> itemList = new ArrayList<String>();
            while (scanner.hasNext()){
                String item = scanner.next();
                itemList.add(item);
            }
            if(itemList.get(0).equals("USE_ATTRACTION")){
                if(itemList.get(1).equals("STANDARD_PRICE")){
                    //Find customer, determine ride type and apply reduction to funds
                }
            }
            else if(itemList.get(0).equals("ADD_FUNDS")){
                //Find customer and run add funds with amount
            }
            else if(itemList.get(0).equals("NEW_CUSTOMER")){
                //Create a new customer object and add it to the park
            }
            else{
                //TODO Create ActionNotFoundException
                //throw new ActionNotFoundException();
            }



        }
    }

}
