package lambdas.poetry;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class PoetryUtil {
    private AtomicInteger punctuationMarksCounter = new AtomicInteger();
    private AtomicInteger prepositionsCounter = new AtomicInteger();
    private AtomicInteger vowelsCounter = new AtomicInteger();
    private AtomicInteger consonantsCounter = new AtomicInteger();
    private Dictionary dictionary = new Dictionary();

    public void showStatistics(List<String> poetry) {
        vowelsCounter.set(0);
        consonantsCounter.set(0);
        prepositionsCounter.set(0);

        poetry.stream()
                .peek(string -> {
                    for (char c : string.toCharArray()) {
                        if (dictionary.getPunctuationMarks().contains(c)) {
                            punctuationMarksCounter.incrementAndGet();
                        }
                    }
                }).collect(Collectors.toList());

        poetry.stream().forEach(s -> {
            Stream.of(s.split("[^A-Za-zА-Яа-я]+"))
                    .map(String::toLowerCase)
                    .distinct()
                    .peek(str -> {
                        for (String word : dictionary.getPrepositions()) {
                            if (str.equals(word)) {
                                prepositionsCounter.incrementAndGet();
                            }
                        }
                    })
                    .map(String::toCharArray)
                    .peek(chars -> {
                        for (char c : chars) {
                            if (dictionary.getLetters().containsKey(c)) {
                                if (dictionary.getLetters().get(c).isVowel) {
                                    vowelsCounter.incrementAndGet();
                                } else {
                                    consonantsCounter.incrementAndGet();
                                }
                            }
                        }
                    }).collect(Collectors.toList());
        });
        System.out.println("prepositionsCounter = " + prepositionsCounter);
        System.out.println("vowelsCounter = " + vowelsCounter);
        System.out.println("consonantsCounter = " + consonantsCounter);
        System.out.println("punctuationMarksCounter = " + punctuationMarksCounter);
    }

    public AtomicInteger getPunctuationMarksCounter() {
        return punctuationMarksCounter;
    }

    public AtomicInteger getPrepositionsCounter() {
        return prepositionsCounter;
    }

    public AtomicInteger getVowelsCounter() {
        return vowelsCounter;
    }

    public AtomicInteger getConsonantsCounter() {
        return consonantsCounter;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }
}
