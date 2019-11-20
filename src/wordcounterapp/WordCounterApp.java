/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author afuoc
 */
public class WordCounterApp {


    public static void main(String[] args) throws FileNotFoundException {
        File songFile = new File("7Rings.txt");
        Scanner input = new Scanner(songFile);
        HashMap<String,Integer> wordCounter = new HashMap<>();
        
        while(input.hasNext()){
            //clean the input
            String next = input.next().toLowerCase();
            if(!wordCounter.containsKey(next)){
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
    
}
