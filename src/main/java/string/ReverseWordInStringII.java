package string;


/**
 * 186. Reverse Words in a String II
 * <p>
 * Given a character array s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = ["a"]
 * Output: ["a"]
 */
public class ReverseWordInStringII {


    public void reverseWords(char[] s) {
        String[] words = new String(s).split(" ");

        for (int i = words.length - 1, index = 0; i >= 0; --i) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                s[index++] = c;
            }

            if (index < s.length)
                s[index++] = ' ';
        }
    }
}
