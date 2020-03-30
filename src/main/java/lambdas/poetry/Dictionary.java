package lambdas.poetry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Dictionary {
    private List<String> prepositions = new ArrayList<>();
    private List<Character> punctuationMarks = asList('.', ',', '!', '?', '—', ';', ':');
    private Map<Character, Letter> letters = new HashMap<>();

    public Dictionary() {
        readPrepositions();
        readLetters();
    }

    private void readLetters() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SvampX\\IdeaProjects\\StreamsLambdas\\src\\main\\resources\\letters.txt"))) {
            boolean isVowel = false;
            String s;
            Letter letter;
            while ((s = br.readLine()) != null) {
                if (s.charAt(0) == 'а') {
                    isVowel = true;
                }
                letter = new Letter(s.charAt(0));
                letter.isVowel = isVowel;
                letters.put(letter.character, letter);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void readPrepositions() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SvampX\\IdeaProjects\\StreamsLambdas\\src\\main\\resources\\prepositions.txt"))) {
            String s;
            while ((s = br.readLine()) != null) {
                prepositions.add(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<String> getPrepositions() {
        return prepositions;
    }

    public List<Character> getPunctuationMarks() {
        return punctuationMarks;
    }

    public Map<Character, Letter>  getLetters() {
        return letters;
    }

    class Letter {
        Character character;
        boolean isVowel;

        public Letter(Character character) {
            this.character = character;
        }

        @Override
        public String toString() {
            return character + "";
        }
    }
}
