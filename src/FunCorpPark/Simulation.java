package FunCorpPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
        createThemePark();
    }

    public ThemePark createThemePark() throws FileNotFoundException {
        readAttractions();
        readCustomers();

    }

    public void simulate(){
        readTransactions();
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
                Attraction rol = new RollerCoaster(itemList.get(1));
                att.add(rol);
            }
            else if(itemList.get(2).equals("GEN")){
                Attraction gen = new GentleAttraction();
                att.add(gen);
            }
            else if(itemList.get(2).equals("TRA")){
                Attraction tra = new TransportAttraction();
                att.add(tra);
            }
            else{
                throw new AttractionNotFoundException();
            }



        }
    }

}
