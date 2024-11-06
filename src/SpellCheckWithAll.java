import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SpellCheckWithAll {

    public static void main(String[] args) throws FileNotFoundException {
        String dictionaryFile = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        String dictionaryFile1 = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile1 = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        String dictionaryFile2 = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile2 = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        String dictionaryFile3 = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile3 = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        String dictionaryFile4 = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile4 = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";
        String dictionaryFile5 = "C:\\Users\\t00244535\\Desktop\\words.txt";
        String documentFile5 = "C:\\Users\\t00244535\\Desktop\\spell-errors.txt";

        // Uncomment the method you want to use
        spellCheckWithLinkedList(dictionaryFile, documentFile);
         spellCheckWithArrayList(dictionaryFile1, documentFile1);
         spellCheckWithHashSet(dictionaryFile2, documentFile2);
        spellCheckWithHashMap(dictionaryFile3, documentFile3);
         spellCheckWithTreeMap(dictionaryFile4, documentFile4);
        spellCheckWithLinkedHashMap(dictionaryFile5, documentFile5);
    }

    public static void spellCheckWithLinkedList(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Collection<String> dictionaryWords = readWordsToCollection(dictionaryFile, new LinkedList<>());
        Collection<String> documentWords = readWordsToCollection(documentFile, new LinkedList<>());
        int misspelledCount = countMisspelledWords(dictionaryWords, documentWords);

        System.out.println("LinkedList - Number of misspelled words: " + misspelledCount);
    }

    public static void spellCheckWithArrayList(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Collection<String> dictionaryWords = readWordsToCollection(dictionaryFile, new ArrayList<>());
        Collection<String> documentWords = readWordsToCollection(documentFile, new ArrayList<>());
        int misspelledCount = countMisspelledWords(dictionaryWords, documentWords);

        System.out.println("ArrayList - Number of misspelled words: " + misspelledCount);
    }

    public static void spellCheckWithHashSet(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Set<String> dictionaryWords = readWordsToSet(dictionaryFile);
        Set<String> documentWords = readWordsToSet(documentFile);
        int misspelledCount = countMisspelledWords(dictionaryWords, documentWords);

        System.out.println("HashSet - Number of misspelled words: " + misspelledCount);
    }
    public static void spellCheckWithHashMap(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Map<String, Boolean> dictionary = readWordsToMap(dictionaryFile, new HashMap<>());
        List<String> documentWords = readWordsToList(documentFile);
        int misspelledCount = countMisspelledWords(dictionary, documentWords);

        System.out.println("HashMap - Number of misspelled words: " + misspelledCount);
    }

    public static void spellCheckWithTreeMap(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Map<String, Boolean> dictionary = readWordsToMap(dictionaryFile, new TreeMap<>());
        List<String> documentWords = readWordsToList(documentFile);
        int misspelledCount = countMisspelledWords(dictionary, documentWords);

        System.out.println("TreeMap - Number of misspelled words: " + misspelledCount);
    }

    public static void spellCheckWithLinkedHashMap(String dictionaryFile, String documentFile) throws FileNotFoundException {
        Map<String, Boolean> dictionary = readWordsToMap(dictionaryFile, new LinkedHashMap<>());
        List<String> documentWords = readWordsToList(documentFile);
        int misspelledCount = countMisspelledWords(dictionary, documentWords);

        System.out.println("LinkedHashMap - Number of misspelled words: " + misspelledCount);
    }
    private static Map<String, Boolean> readWordsToMap(String filename, Map<String, Boolean> map) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            map.put(in.next().toLowerCase(), true);
        }
        return map;
    }

    private static Collection<String> readWordsToCollection(String filename, Collection<String> collection) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            collection.add(in.next().toLowerCase());
        }
        return collection;
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
    private static List<String> readWordsToList(String filename) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }


    private static int countMisspelledWords(Collection<String> dictionary, Collection<String> document) {
        int count = 0;
        for (String word : document) {
            if (!dictionary.contains(word)) {
                count++;
            }
        }
        return count;
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

