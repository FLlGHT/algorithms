package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FLIGHT
 * <p>
 * 288. Unique Word Abbreviation
 * Solved
 * Medium
 * Topics
 * Companies
 * The abbreviation of a word is a concatenation of its first letter,
 * the number of characters between the first and last letter, and its last letter.
 * If a word has only two characters, then it is an abbreviation of itself.
 * <p>
 * For example:
 * <p>
 * dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
 * internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
 * it --> it because any word with only two characters is an abbreviation of itself.
 * Implement the ValidWordAbbr class:
 * <p>
 * ValidWordAbbr(String[] dictionary) Initializes the object with a dictionary of words.
 * boolean isUnique(string word) Returns true if either of the following conditions are met (otherwise returns false):
 * There is no word in dictionary whose abbreviation is equal to word's abbreviation.
 * For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]
 * [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], ["cake"]]
 * Output
 * [null, false, true, false, true, true]
 * <p>
 * Explanation
 * ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
 * validWordAbbr.isUnique("dear"); // return false, dictionary word "deer" and word "dear" have the same abbreviation "d2r" but are not the same.
 * validWordAbbr.isUnique("cart"); // return true, no words in the dictionary have the abbreviation "c2t".
 * validWordAbbr.isUnique("cane"); // return false, dictionary word "cake" and word "cane" have the same abbreviation  "c2e" but are not the same.
 * validWordAbbr.isUnique("make"); // return true, no words in the dictionary have the abbreviation "m2e".
 * validWordAbbr.isUnique("cake"); // return true, because "cake" is already in the dictionary and no other word in the dictionary has "c2e" abbreviation.
 */
public class ValidWordAbbr {

  private final Map<String, String> abbreviationToWord;

  public ValidWordAbbr(String[] dictionary) {
    abbreviationToWord = new HashMap<>();

    for (String word : dictionary) {
      String abbreviation = getAbbreviation(word);
      if (abbreviationToWord.containsKey(abbreviation) && !abbreviationToWord.get(abbreviation).equals(word))
        abbreviationToWord.put(abbreviation, "");
      else
        abbreviationToWord.put(abbreviation, word);
    }
  }

  public boolean isUnique(String word) {
    String abbreviation = getAbbreviation(word);
    return !abbreviationToWord.containsKey(abbreviation) || abbreviationToWord.get(abbreviation).equals(word);
  }

  private String getAbbreviation(String word) {
    return word.charAt(0) + (word.length() <= 2 ? "" : word.length() - 2 + "") + word.charAt(word.length() - 1);
  }
}
