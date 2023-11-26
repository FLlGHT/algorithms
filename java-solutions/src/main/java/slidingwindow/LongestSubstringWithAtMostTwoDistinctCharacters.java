package slidingwindow;

import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int longest = 0;

        for (int left = 0, right = 0; left < s.length(); left++, right = left) {
            Set<Character> letters = new HashSet<>();

            while (right < s.length() && letters.size() <= 2) {
                char nextLetter = s.charAt(right);
                letters.add(nextLetter);
                if (letters.size() <= 2) right++;
            }

            longest = Math.max(longest, right - left);
        }

        return longest;
    }


    public int lengthOfLongestSubstringTwoDistinct_2(String s) {
        int longest = 0;
        Map<Character, Integer> letterToIndex = new HashMap<>();

        int left = 0, right = 0;

        while (right < s.length()) {
            letterToIndex.put(s.charAt(right), right++);

            if (letterToIndex.size() == 3) {
                int leftIndex = Collections.min(letterToIndex.values());
                letterToIndex.remove(s.charAt(leftIndex));
                left = leftIndex + 1;
            }

                longest = Math.max(longest, right - left);
        }

        return longest;
    }

}
