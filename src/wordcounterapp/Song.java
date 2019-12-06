package wordcounterapp;

import java.io.*;
import java.util.*;
import java.lang.*;

/*
 Song Class
 */
public class Song {
    File songFile;
    File outputFile;
    File stopwordsFile;
    FileWriter fr = null;
    BufferedWriter br = null;
    PrintWriter pr = null;
    Scanner input;
    Scanner stopwordsInput;
    HashMap<String, Integer> songLyrics = new HashMap<>();
    HashSet<String> stopwords = new HashSet<>();
    int count;
    int totalWords = 0;
    String songTitle;

    public Song(String inputFile, String T) throws IOException {
        //creating stopwords input
        stopwordsFile = new File("stopwords.txt");
        stopwordsInput = new Scanner(stopwordsFile);
        //creating file input
        songFile = new File(inputFile);
        outputFile = new File("output.txt");
        input = new Scanner(songFile);
        songTitle = T;

        //Inputting the Stopwords into the set
        while (stopwordsInput.hasNext()) {
            //clean, remove punctuation and to lower case
            String stopword = stopwordsInput.next().toLowerCase();
            stopword = stopword.replaceAll("\\p{Punct}", "");
            //input stopword to set
            if (stopwords.contains(stopword)); else {
                stopwords.add(stopword);
            }
        }

        //Inputting the Lyrics to the HashMap
        while (input.hasNext()) {
            //clean the input, remove punctuation and to Lower Case
            String next = input.next().toLowerCase();
            next = next.replaceAll("\\p{Punct}", "");

            //catch for stopword or already in the dictionary to increment
            //or add it to dictionary and add 1
            if (stopwords.contains(next)) {
            } else if (!songLyrics.containsKey(next)) {
                songLyrics.put(next, 1);
                totalWords++;
            } else {
                songLyrics.put(next, songLyrics.get(next) + 1);
                totalWords++;
            }
        }
        //Sort the Hashmap
        songLyrics = Song.sortByValue(songLyrics);
        //printLyricsFile(songLyrics);
        //printFrequencyFile(songLyrics);
    }

    /*
    Print the Lyrics to console
     */
    public void printLyrics(HashMap<String, Integer> song) {
        for (String word : song.keySet()) {
            count = song.get(word);
            System.out.println(count + ": " + word);
        }
    }

    /*
    Print the Lyrics to txt file with all other songs
     */
    public void printLyricsFile(HashMap<String, Integer> song) throws IOException {
        //create a file first    
        try {
            // to append to file, you need to initialize FileWriter using below constructor
            fr = new FileWriter(outputFile, true);
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            pr.println(songTitle);
            for (String word : song.keySet()) {
                count = song.get(word);
                pr.println(count + ": " + word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pr.println();
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    /*
    Print the Lyrics to txt file
     */
    public void printFrequencyFile(HashMap<String, Integer> song, String outputFile){
        try (PrintWriter output = new PrintWriter(outputFile)) {
            for (String word : song.keySet()) {
                int count = song.get(word);
                output.println(count + ": " + word);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }   

    /*
     * Sort the Hashmap
     */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

      // Create a list from elements of HashMap
      java.util.List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

      // Sort the list
      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
        public int compare(Map.Entry<String, Integer> o1,
                           Map.Entry<String, Integer> o2) {
          return (o2.getValue()).compareTo(o1.getValue());
        }
      });

      // put data from sorted list to hashmap
      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
      for (Map.Entry<String, Integer> aa : list) {
        temp.put(aa.getKey(), aa.getValue());
      }
      return temp;
    }
    
}