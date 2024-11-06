import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellCheckHashMap {
    public static void main(String[] args) throws FileNotFoundException {
        String dictionaryFile = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        spellCheckWithHashMap(dictionaryFile, documentFile);
    }

    public static void spellCheckWithHashMap(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Map<String, Boolean> dictionary = readWordsToMap(dictionaryFile);
        List<String> documentWords = readWordsToList(documentFile);
        int misspelledCount = countMisspelledWords(dictionary, documentWords);
        System.out.println("HashMap - Number of misspelled words: " + misspelledCount);
    }

    private static Map<String, Boolean> readWordsToMap(String filename) throws FileNotFoundException {
        Map<String, Boolean> words = new HashMap<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.put(in.next().toLowerCase(), true);
        }
        return words;
    }

    private static List<String> readWordsToList(String filename) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    private static int countMisspelledWords(Map<String, Boolean> dictionary, List<String> document) {
        int count = 0;
        for (String word : document) {
            if (!dictionary.containsKey(word)) {
                count++;
            }
        }
        return count;
    }
}
