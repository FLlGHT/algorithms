package string;


import java.util.Set;

/**
 * 824. Goat Latin
 *
 * You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
 * For example, the word "apple" becomes "applema".
 * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 * Return the final sentence representing the conversion from sentence to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: sentence = "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class GoatLatin {

    public String toGoatLatin(String sentence) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder result = new StringBuilder(); String[] words = sentence.split(" ");

        for (int index = 0; index < words.length; ++index) {
            String word = words[index];
            result.append(vowels.contains(word.charAt(0)) ? word : (word.substring(1)) + word.charAt(0));
            result.append("ma").append("a".repeat(index + 1)).append(index < words.length - 1 ? " " : "");
        }

        return result.toString();
    }
}
