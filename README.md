# Word Cloud Project
Assignment 3 and 4 for CISC 3130- Data Structures. 

## Assignment 3 Objective- Word Frequencies
Analyze a song for the frequency of word used by song utlizing different data structures.
  
  **1. Prepare a text file that contains text to analyze.**
In this case, I have chosen to prepare the songs from the 2019 album thank u, next by Ariana Grande. 

Each song is located in the thank u, next folder within the src folder. Each individual song has a text file with the lyrics gathered from [Genius](https://genius.com/albums/Ariana-grande/Thank-u-next). The distinction of the identifiers of Verse 1, Outro, Pre-Chorus, etc removed. *This could also be done with adding them to the stopwords, adding the specific words. This would be a good addition for next implementaion.*
  
  **2. With your code, you’ll read from the text file and capture the data into a data structure.**
Reading in the data I used a Scanner object to read in each individual word. Every non-alphanumeric symbol was taken out and changed to lowercase

```java
while(input.hasNext()){
  String next = input.next().toLowerCase();
  next = next.replaceAll("\\p{Punct}", "");
```

  **3. Using a data structure, write the code to count the appearance of each unique word in the lyrics.**
The Song words were inputted into a HashMap. This was used for easy access to each word to increment or add to. 
It was also checked for stopwords. The stopwords were put into a HashSet, read into through the stopwords.txt file, for easy access and input. The stopwords used a HashSet only needing keys for the stopwords and allows for easy access to compare to the inputting song word. *For every Song a new stopword HashSet was created, only needing keys for the stopwords and allows for easy access to compare to the inputting song word. Which may be unnecessary and instead could pass the stopword hashmap into the contructor of the Song Object.*

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
  
  ### Song Class
  This class is used to hold the 
  ### Album Class 

## Example
```java
System.out.println("Does this even work");
```

