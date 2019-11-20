
package wordcounterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author afuoc
 */
public class WordCounterApp {


    public static void main(String[] args) throws FileNotFoundException {
        File songFile = new File("7Rings.txt");
        File stopwordsFile = new File("stopwords.txt");
        Scanner input = new Scanner(songFile);
        Scanner stopwordsInput = new Scanner(stopwordsFile);
        HashMap<String,Integer> wordCounter = new HashMap<>();
        HashSet<String> stopwords = new HashSet<>();
        
        //Inputting the Stopwords into the set
        while(stopwordsInput.hasNext()){
            //clean and to lower case
            String stopword = stopwordsInput.next().toLowerCase();
            stopword = stopword.replaceAll("\\p{Punct}", "");
            if(stopwords.contains(stopword));
            else{
                stopwords.add(stopword);
            }
        }
        
        //Inputting the Lyrics to the HashMap
        while(input.hasNext()){
            //clean the input, remove punctuation and to Lower Case
            String next = input.next().toLowerCase();
            next = next.replaceAll("\\p{Punct}", "");
           
            //catch for stopword or already in the dictionary to increment
            //or add it to dictionary and add 1
            if(stopwords.contains(next)) {
            } else if(!wordCounter.containsKey(next)){
                wordCounter.put(next, 1);
            }else{
                wordCounter.put(next, wordCounter.get(next) + 1);
             }
        }
        
        wordCounter.keySet().forEach((word) -> {
            int count = wordCounter.get(word);
            System.out.println(count + " " + word);
        });
    }
    
    /*
    Sort the Hashmap
    */
    public HashMap<String, Integer> sortMap(HashMap<String, Integer> song){
        
        return song;
    }
}
