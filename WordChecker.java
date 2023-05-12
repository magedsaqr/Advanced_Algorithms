import java.util.*;

public class WordChecker{
    private List<String> lexicon; // List to store the dictionary of words.

    // Constructor to initialize the lexicon of words.
    public WordChecker(List<String> words){
        lexicon = words;
    }

    // Method to check if a word is valid or not. if not make suggestions
    public List<String> check(String s){
        List<String> WordResult = new ArrayList<>(); // List to store the suggestions.
        if (lexicon.contains(s)){ // If the word is valid, if valid add it to the list and return it.
            WordResult.add(s);
            return WordResult;
        }

        // Check for single-character deletions.
        for (int i = 0; i < s.length(); i++){
            StringBuilder build_string = new StringBuilder(s);
            build_string.deleteCharAt(i);
            String candidate = build_string.toString();
            if (lexicon.contains(candidate)){
                WordResult.add(candidate);
            }
        }

        // Check for adjacent character swaps.
        for (int i = 0; i < s.length() - 1; i++){
            StringBuilder build_string = new StringBuilder(s);
            char t = build_string.charAt(i);
            build_string.setCharAt(i, build_string.charAt(i+1));
            build_string.setCharAt(i+1, t);
            String candidate = build_string.toString();
            if (lexicon.contains(candidate)){
                WordResult.add(candidate);
            }
        }

        // Check for single-character insertions.
        for (int i = 0; i <= s.length(); i++){
            for (char c = 'a'; c <= 'z'; c++){
                StringBuilder build_string = new StringBuilder(s);
                build_string.insert(i, c);
                String candidate = build_string.toString();
                if (lexicon.contains(candidate)){
                    WordResult.add(candidate);
                }
            }
        }

        // Check for single-character replacements.
        for (int i = 0; i < s.length(); i++){
            for (char c = 'a'; c <= 'z'; c++){
                StringBuilder build_string = new StringBuilder(s);
                build_string.setCharAt(i, c);
                String candidate = build_string.toString();
                if (lexicon.contains(candidate)){
                    WordResult.add(candidate);
                }
            }
        }

        return WordResult; // Return the list of suggestions.
    }

    // Main method to test the WordChecker class.
    public static void main(String[] args){
        List<String> words = Arrays.asList("maged", "saqr", "barcelona", "messi","programming"); // Create a List of valid words.
        WordChecker spellChecker = new WordChecker(words); // Create a WordChecker object with the List of valid words.

        // create a list of word to check their spelling
        String[] testWords ={"magez", "sarq", "barcelona", "programmin"};
        for (String word : testWords){
            List<String> suggestions = spellChecker.check(word); // Get a list of suggestions for the misspelled word.
            if (suggestions.isEmpty()){ // If the list is empty, the word is valid.
                System.out.println(word + " is spelled correctly.");
            } 
            else{ //print the misspelled word and its suggestions.
                System.out.println(word + " is spelled incorrectly. Suggestions:");
                for (String suggestion : suggestions){
                    System.out.println("- " + suggestion);
                }
            }
        }
    }
}