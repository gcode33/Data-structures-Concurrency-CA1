import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellCheckHashSet {
    public static void main(String[] args) throws FileNotFoundException {
        String dictionaryFile = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        spellCheckWithHashSet(dictionaryFile, documentFile);
    }

    public static void spellCheckWithHashSet(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Set<String> dictionaryWords = readWordsToSet(dictionaryFile);
        Set<String> documentWords = readWordsToSet(documentFile);
        int misspelledCount = countMisspelledWords(dictionaryWords, documentWords);
        System.out.println("HashSet - Number of misspelled words: " + misspelledCount);
    }

    private static Set<String> readWordsToSet(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    private static int countMisspelledWords(Set<String> dictionary, Set<String> document) {
        int count = 0;
        for (String word : document) {
            if (!dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
