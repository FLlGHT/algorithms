package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2418. Sort the People
 * <p>
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 * <p>
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * <p>
 * Return names sorted in descending order by the people's heights.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.
 * Example 2:
 * <p>
 * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * Output: ["Bob","Alice","Bob"]
 * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 */
public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        List<PersonInfo> personInfo = new ArrayList<>();
        for (int i = 0; i < names.length; ++i)
            personInfo.add(new PersonInfo(heights[i], names[i]));

        personInfo.sort(Comparator.comparing(PersonInfo::height).reversed());
        String[] sorted = new String[names.length];
        for (int i = 0; i < sorted.length; ++i)
            sorted[i] = personInfo.get(i).name();

        return sorted;
    }

    record PersonInfo(int height, String name) {

    }
}
