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
        
        String[] inputFiles = {"src\\thank u, next\\imagine.txt", 
            "src\\thank u, next\\needy.txt", 
            "src\\thank u, next\\NASA.txt", 
            "src\\thank u, next\\bloodline.txt", 
            "src\\thank u, next\\fake smile.txt", 
            "src\\thank u, next\\bad idea.txt",
            "src\\thank u, next\\make up.txt",
            "src\\thank u, next\\ghostin.txt",
            "src\\thank u, next\\in my head.txt",
            "src\\thank u, next\\7 rings.txt",
            "src\\thank u, next\\thank u, next.txt",
            "src\\thank u, next\\break up with your girlfriend, im bored.txt"};

        String[] songNames = {"imagine", "needy", "NASA",
            "bloodline", "fake smile", "bad idea", "make up", "ghostin",
            "in my head", "7 rings", "thank u, next",
            "break up with your girlfriend, im bored"};

        String[] picFiles = {"imagine.png", "needy.png", "NASA.png",
            "bloodline.png", "fake smile.png", "bad idea.png", "make up.png",
            "ghostin.png", "in my head.png", "7 rings.png",
            "thank u, next.png",
            "break up with your girlfriend, im bored.png"};

        String[] songFF = new String[numOfSongs];
        for (int i = 0; i < songFF.length; i++) {
            songFF[i] = "src\\thank u, next\\Output-" + songNames[i] + ".txt";
        }

        for(int i = 0; i < songNames.length; i++){
            tunSongs[i] = new Song(inputFiles[i], songNames[i]);
            TUN.addSong(tunSongs[i], i);
            tunSongs[i].printFrequencyFile(tunSongs[i].songLyrics, songFF[i]);
        }
        //tunSongs[10].printFrequencyFile(tunSongs[10].songLyrics);
        //TUN.printLyrics();
        //TUN.printLyricsFile(TUN.albumLyrics);

    }
}