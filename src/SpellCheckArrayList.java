import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellCheckArrayList {
    public static void main(String[] args) throws FileNotFoundException {
        String dictionaryFile = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        spellCheckWithArrayList(dictionaryFile, documentFile);
    }

    public static void spellCheckWithArrayList(String dictionaryFile, String documentFile) throws FileNotFoundException {
        List<String> dictionaryWords = readWordsToList(dictionaryFile);
        List<String> documentWords = readWordsToList(documentFile);
        int misspelledCount = countMisspelledWords(dictionaryWords, documentWords);
        System.out.println("ArrayList - Number of misspelled words: " + misspelledCount);
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

    private static int countMisspelledWords(List<String> dictionary, List<String> document) {
        int count = 0;
        for (String word : document) {
            if (!dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
