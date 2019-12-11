# Word Cloud Project
Assignment 3 and 4 for CISC 3130- Data Structures. 

## Assignment 3 Objective- Word Frequencies [x](https://github.com/alexfuoc/WordCounterApp)
Analyze a song for the frequency of word used by song utlizing different data structures.
  
  **1. Prepare a text file that contains text to analyze.**
In this case, I have chosen to prepare the songs from the 2019 album thank u, next by Ariana Grande. 

Each song is located in the thank u, next folder within the src folder. Each individual song has a text file with the lyrics gathered from [Genius](https://genius.com/albums/Ariana-grande/Thank-u-next). The distinction of the identifiers of Verse 1, Outro, Pre-Chorus, etc removed. *This could also be done with adding them to the stopwords, adding the specific words. This would be a good addition for next implementaion.*
  
  **2. With your code, you’ll read from the text file and capture the data into a data structure.**

The constructor of the Song object accepts a String inputFile and String songTitle. The inputFile string is the location of the song File with the lyrics, which is then instaites a File object, then instantiating Scanner object. The Scanner object reads in each individual word. Every non-alphanumeric symbol was taken out and changed to lowercase

```java
while(input.hasNext()){
  String next = input.next().toLowerCase();
  next = next.replaceAll("\\p{Punct}", "");
```

  **3. Using a data structure, write the code to count the appearance of each unique word in the lyrics.**

The Song words were inputted into a HashMap<String, Integer>. The key is a String or the word, and the value was the number of times it occured. This was used for easy access to each word to increment or add to. With a O(1) there does not need to be any searching or loops, making it the best data structure. 

It was also checked for stopwords. The stopwords were put into a HashSet, read into through the stopwords.txt file, which contained the Default English Stopwords List from [ranks.nl/stopwords]. The stopwords used a HashSet only needing keys for the stopwords and allows for easy access to compare to the inputting song word. *For every Song a new stopword HashSet was created, which may be unnecessary and instead could pass the stopword HashSet into the contructor of the Song Object.*

```java
if (stopwords.contains(next)) {
} else if (!songLyrics.containsKey(next)) {
    songLyrics.put(next, 1);
    totalWords++;
} else {
    songLyrics.put(next, songLyrics.get(next) + 1);
    totalWords++;
}     
```

  **4. Print out a word frequency list.**

Printing the Frequency List is done through the method in the Song Class. Accepting the HashMap<String, Integer> of the song. It wrote to the frequencyFile.txt. Using a for loop it looped through every key in the set, printing the key with its corresponding value pair. 
  
 ```java 
public void printFrequencyFile(HashMap<String, Integer> song){
  try (PrintWriter output = new PrintWriter("frequencyFile.txt")) {
    for (String word : song.keySet()) {
      int count = song.get(word);
      output.println(count + ": " + word);
    }
  } catch (IOException e){
            e.printStackTrace();
    }
  }    
}   
 ```
 
 *i.e Output File, thank u, next*
```
42: next
38: you
37: thank
15: yeah
8: my
7: say
6: taught
```
  ### Song Class
 
 The Song Class holds data for a song, including fields HashMap<String, Integer> songLyrics, String songTitle and HashSet<String> stopwords. The methods include the constructor, Song(String inputFile, String T) to input the song, void printLyrics(HashMap<String, Integer> song) to print the lyrics to the console, and void printLyricsFile(HashMap<String, Integer> song to print the lyrics to the output file. 
  
  ### Album Class 
The Album class holds the data for the entire album, including fields int NumOfSongs, NumOfWords, andh HashMap<String, Integer> albumLyrics. The methods include the constructor, Album(Song inputSong, int songIndex) to instantiate the album, addSong(Song inputSong, int songIndex) to input the song objects lyrics into the albumLyrics HashMap<String, Integer>, void printLyricsFile(HashMap<String, Integer> album) to print the lyrics to the output file.

*The Song and Album class fields are denoted as public, this could lead to data corruption and should be assigned private and accessed with getter and setter methods OR given package access, allowing the Album class to utilize the songs fields. They are denoted public so the album class can access the Song classes fields.*

***i.e Album class inputting a Song classes songLyrics HashMap<String, Integer>***
```java
inputSong.songLyrics.keySet().forEach((String word) -> {
            if(albumLyrics.containsKey(word)){
                albumLyrics.put(word,
                        inputSong.songLyrics.get(word)+ albumLyrics.get(word));
            }else{
                albumLyrics.put(word, inputSong.songLyrics.get(word));
            }
        });

```

## [Assignment 4- Word Cloud Visualization website](https://github.com/alexfuoc/WordClouds)
