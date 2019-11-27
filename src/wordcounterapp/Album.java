
package wordcounterapp;

import java.util.*;
import java.io.*;

public class Album {
    int NumOfSongs;
    String albumName;
    String[] songNames;
    HashMap<String, Integer> albumLyrics = new HashMap<>();
    
    public Album(String name, int songNum){
        NumOfSongs = songNum;
        songNames = new String[songNum];
        albumName = name;
    }
    
    /*
    addSong method
    @param - Song object
    @return - void
    */
    public void addSong(Song inputSong, int songIndex){
        songNames[songIndex] = inputSong.songTitle;
        //catch for stopword or already in the dictionary to increment
        //or add it to dictionary and add 1
        
    /*
    sortByValue method
    @param - HashMap<String, Integer> albumLyrics 
    @return - void
    called every adding of Song
    */
    }
}
