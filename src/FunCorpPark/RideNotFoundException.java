package FunCorpPark;

import java.io.CharArrayReader;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class RideNotFoundException extends Exception {
    public RideNotFoundException(ArrayList<Attraction> attractions, String name) {

        checkAttrName(attractions, name);

    }

    public String checkAttrName(ArrayList<Attraction> attractions, String name){

        int points = 0;
        boolean t = false;
        String name2 = null;

        for(int i = 0; i < attractions.size(); i++){

            int[] arr = attractions.get(i).getName().chars().toArray();
            int[] arr2 = name.chars().toArray();

            for(int j = 0; j < arr.length; j++){
                for(int k = 0; k < arr2.length; k++){
                    if(arr[j] == arr2[k]){
                        points = points + 1;
                    }
                }
            }
            if(points > arr2.length * 0.8){
                for(int l = 0; l < arr.length; l++){
                    CharArrayReader read = new CharArrayReader(arr);
                }
            }
            else{
                name2 = arr2.toString();
            }

        }

        return name2;
    }
}
