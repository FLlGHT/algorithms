package string;

/**
 * 2138. Divide a String Into Groups of Size k
 * <p>
 * A string s can be partitioned into groups of size k using the following procedure:
 * <p>
 * The first group consists of the first k characters of the string,
 * the second group consists of the next k characters of the string, and so on. Each character can be a part of exactly one group.
 * For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
 * Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order,
 * the resultant string should be s.
 * <p>
 * Given the string s, the size of each group k and the character fill,
 * return a string array denoting the composition of every group s has been divided into, using the above procedure.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcdefghi", k = 3, fill = "x"
 * Output: ["abc","def","ghi"]
 * Explanation:
 * The first 3 characters "abc" form the first group.
 * The next 3 characters "def" form the second group.
 * The last 3 characters "ghi" form the third group.
 * Since all groups can be completely filled by characters from the string, we do not need to use fill.
 * Thus, the groups formed are "abc", "def", and "ghi".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abcdefghij", k = 3, fill = "x"
 * Output: ["abc","def","ghi","jxx"]
 * Explanation:
 * Similar to the previous example, we are forming the first three groups "abc", "def", and "ghi".
 * For the last group, we can only use the character 'j' from the string. To complete this group, we add 'x' twice.
 * Thus, the 4 groups formed are "abc", "def", "ghi", and "jxx".
 */
public class DivideStringIntoGroupsOfSizeK {

    public String[] divideString(String s, int k, char fill) {
        int groupsCount = s.length() / k + (s.length() % k > 0 ? 1 : 0);
        String[] divided = new String[groupsCount];

        for (int group = 0, index = 0; group < groupsCount; ++group, index += k)
            divided[group] = index + k < s.length() ? s.substring(index, index + k) : s.substring(index);

        while (divided[groupsCount - 1].length() < k)
            divided[groupsCount - 1] += fill;

        return divided;
    }
}
