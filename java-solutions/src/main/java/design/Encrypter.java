package design;

import java.util.*;

/**
 * @author FLIGHT
 * <p>
 * 2227. Encrypt and Decrypt Strings
 * <p>
 * You are given a character array keys containing unique characters and a string array values containing strings of length 2.
 * You are also given another string array dictionary that contains all permitted original strings after decryption.
 * You should implement a data structure that can encrypt or decrypt a 0-indexed string.
 * <p>
 * A string is encrypted with the following process:
 * <p>
 * For each character c in the string, we find the index i satisfying keys[i] == c in keys.
 * Replace c with values[i] in the string.
 * Note that in case a character of the string is not present in keys, the encryption process cannot be carried out,
 * and an empty string "" is returned.
 * <p>
 * A string is decrypted with the following process:
 * <p>
 * For each substring s of length 2 occurring at an even index in the string, we find an i such that values[i] == s.
 * If there are multiple valid i, we choose any one of them.
 * This means a string could have multiple possible strings it can decrypt to.
 * Replace s with keys[i] in the string.
 * Implement the Encrypter class:
 * <p>
 * Encrypter(char[] keys, String[] values, String[] dictionary) Initializes the Encrypter class with keys, values, and dictionary.
 * String encrypt(String word1) Encrypts word1 with the encryption process described above and returns the encrypted string.
 * int decrypt(String word2) Returns the number of possible strings word2 could decrypt to that also appear in dictionary.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Encrypter", "encrypt", "decrypt"]
 * [[['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"], ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]], ["abcd"], ["eizfeiam"]]
 * Output
 * [null, "eizfeiam", 2]
 * <p>
 * Explanation
 * Encrypter encrypter = new Encrypter([['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"], ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]);
 * encrypter.encrypt("abcd"); // return "eizfeiam".
 * // 'a' maps to "ei", 'b' maps to "zf", 'c' maps to "ei", and 'd' maps to "am".
 * encrypter.decrypt("eizfeiam"); // return 2.
 * // "ei" can map to 'a' or 'c', "zf" maps to 'b', and "am" maps to 'd'.
 * // Thus, the possible strings after decryption are "abad", "cbad", "abcd", and "cbcd".
 * // 2 of those strings, "abad" and "abcd", appear in dictionary, so the answer is 2.
 */
public class Encrypter {

  private final Map<Character, String> keyValue;
  private final Map<String, List<Character>> valueKeys;
  private final Map<String, Integer> dictionaryCount;

  public Encrypter(char[] keys, String[] values, String[] dictionary) {
    this.keyValue = new HashMap<>();
    this.valueKeys = new HashMap<>();
    this.dictionaryCount = new HashMap<>();

    initCollections(keys, values, dictionary);
  }

  private void initCollections(char[] keys, String[] values, String[] dictionary) {
    for (int i = 0; i < keys.length; ++i) {
      char key = keys[i]; String value = values[i];
      keyValue.put(key, value);
      valueKeys.computeIfAbsent(value, p -> new ArrayList<>()).add(key);
    }

    for (String word : dictionary) {
      String encrypted = encrypt(word);
      dictionaryCount.merge(encrypted, 1, Integer::sum);
    }
  }

  public String encrypt(String word1) {
    StringBuilder encrypted = new StringBuilder();
    for (char letter : word1.toCharArray()) {
      if (!keyValue.containsKey(letter))
        return "";

      encrypted.append(keyValue.get(letter));
    }

    return encrypted.toString();
  }

  public int decrypt(String word2) {
    return dictionaryCount.getOrDefault(word2, 0);
  }
}
