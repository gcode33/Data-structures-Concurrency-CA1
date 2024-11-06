/*****************************************************
 *	Title: SpellCheck source code
 *	Author: Horstmann
 *	Site owner/sponsor: Wiley
 *  Date:
 *	Code version: edited October 9th 2023
 *	Availability: Instructor Companion Site (online) to Big Java: Late Objects, 1st Edition (Wiley) (Accessed 9th October 2023)
 *	Modified:
 *       Collection used instead of Set for dictionaryWords to allow us experiment with different collections.
  *****************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellCheck {
   public static void main(String[] args) throws FileNotFoundException {
      String dictionaryFile = "C:\\Users\\t00244535\\Desktop\\words.txt";
      String documentFile = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
      spellCheckWithLinkedList(dictionaryFile, documentFile);
   }

   public static void spellCheckWithLinkedList(String dictionaryFile, String documentFile) throws FileNotFoundException {
      LinkedList<String> dictionaryWords = readWordsToLinkedList(dictionaryFile);
      LinkedList<String> documentWords = readWordsToLinkedList(documentFile);
      int misspelledCount = countMisspelledWords(dictionaryWords, documentWords);
      System.out.println("LinkedList - Number of misspelled words: " + misspelledCount);
   }

   private static LinkedList<String> readWordsToLinkedList(String filename) throws FileNotFoundException {
      LinkedList<String> words = new LinkedList<>();
      Scanner in = new Scanner(new File(filename));
      in.useDelimiter("[^a-zA-Z]+");
      while (in.hasNext()) {
         words.add(in.next().toLowerCase());
      }
      return words;
   }

   private static int countMisspelledWords(LinkedList<String> dictionary, LinkedList<String> document) {
      int count = 0;
      for (String word : document) {
         if (!dictionary.contains(word)) {
            count++;
         }
      }
      return count;
   }
}