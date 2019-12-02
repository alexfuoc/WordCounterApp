
package wordcounterapp;

import java.io.*;
import java.util.*;


/**
 *
 * @author afuoc
 */
public class WordCounterApp {


    public static void main(String[] args) throws IOException {

        int numOfSongs = 12;
        Song[] tunSongs = new Song[numOfSongs];
        Album TUN = new Album("thank u, next", numOfSongs);
        
        String[] inputFiles = {"imagine.txt", "needy.txt", "NASA.txt", 
                "bloodline.txt", "fake smile.txt", "bad idea.txt", 
                "make up.txt", "ghostin.txt", "in my head.txt", "7 rings.txt", 
                "thank u, next.txt", "break up with your girlfriend, im bored.txt"};
        
        String[] songNames = {"imagine", "needy", "NASA", 
                "bloodline", "fake smile", "bad idea", "make up", "ghostin", 
                "in my head", "7 rings", "thank u, next.txt", 
                "break up with your girlfriend, im bored.txt"};
        
        for(int i = 0; i < songNames.length; i++){
            tunSongs[i] = new Song(inputFiles[i], songNames[i]);
            TUN.addSong(tunSongs[i], i);
        }
        
        TUN.printLyrics();
        TUN.printLyricsFile(TUN.albumLyrics);

    }
}