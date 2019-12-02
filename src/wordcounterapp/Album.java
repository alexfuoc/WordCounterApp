package wordcounterapp;

import java.util.*;
import java.io.*;

public class Album {
    int NumOfSongs;
    int NumOfWords=0;
    String albumName;
    String[] songNames;
    HashMap<String, Integer> albumLyrics = new HashMap<>();
    
    public Album(String name, int songNum){
        NumOfSongs = songNum;
        songNames = new String[NumOfSongs];
        albumName = name;
    }
    
    /*
    addSong method, inputs each songs hashmap into Album hashmap haha
    @param - Song object
    @return - void
    */
    public void addSong(Song inputSong, int songIndex){
        songNames[songIndex] = inputSong.songTitle;
        NumOfWords = NumOfWords + inputSong.totalWords;
        
        inputSong.songLyrics.keySet().forEach((String word) -> {
            if(albumLyrics.containsKey(word)){
                albumLyrics.put(word,
                        inputSong.songLyrics.get(word)+ albumLyrics.get(word));
            }else{
                albumLyrics.put(word, inputSong.songLyrics.get(word));
            }
        });
        
        albumLyrics = sortByValue(albumLyrics);
    }
    
    /*
    sortByValue method
    @param - HashMap<String, Integer> albumLyrics 
    @return - void
    calls song class static method of sortByValue
    */
    public HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        return Song.sortByValue(hm);
    }
    
    /*
    Print the Lyrics to console
    */
    public void printLyrics(){
        for (String word : albumLyrics.keySet()) {
            int count = albumLyrics.get(word);
            System.out.println(count + ": " + word);
        }
    }
    
    
    /*
    Print the Album Lyrics to txt file
    */
    public void printLyricsFile(HashMap<String, Integer> album) throws IOException{
        //create a file first    
        PrintWriter output = new PrintWriter("albumOutput.txt");
        output.println("Album Title: " + albumName);
        output.println("Number of songs: " + NumOfSongs);
        output.println("Total Number of Words Sung: " + NumOfWords);
        for (String word : album.keySet()) {
            int count = album.get(word);
            output.println(count + ": " + word);
        }
        output.close();
    }
}