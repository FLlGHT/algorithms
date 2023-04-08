package design;

import java.util.Arrays;
import java.util.List;

/**
 * 271. Encode and Decode Strings
 *
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * You are not allowed to solve the problem using any serialize methods (such as eval).
 */
public class Codec {

    private final String EOW = "E:O:W";
    private final String EMPTY = "EMPTYSTRING";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strings) {
        StringBuilder encoded = new StringBuilder();
        for (String string : strings) {
            encoded.append(string.isEmpty() ? EMPTY : string);

            encoded.append(EOW);
        }
        return encoded.substring(0, encoded.length() - EOW.length());
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String string) {
        String[] decoded = string.split(EOW);
        return Arrays.stream(decoded).map(word -> word.equals(EMPTY) ? "" : word).toList();
    }

}
