package FunCorpPark;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
	// write your code here
    }

    public ThemePark createThemePark(){
        readAttractions();
        readCustomers();

    }

    public void simulate(){
        readTransactions();
    }

    public ArrayList<String> readFile(String fileName){
        ArrayList<String> lines = new ArrayList<String>();
        Scanner line = new Scanner;
        File file = new File(fileName);
        line.useDelimiter(System.lineSeparator());
        while(line.hasNext()){
            String lineInfo = line.next();
            lines.add(lineInfo);
        }
        return lines;
    }

    public ArrayList<Attraction> readAttractions(){
        ArrayList<String> list = readFile("attractions.txt");
        for(int i = 0; i < list.size(); i++){
            String info = list.get(i);
            Scanner scanner = new Scanner;


        }
    }

}
