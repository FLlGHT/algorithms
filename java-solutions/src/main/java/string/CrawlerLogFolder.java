package string;

/**
 * 1598. Crawler Log Folder
 * <p>
 * The Leetcode file system keeps a log each time some user performs a change folder operation.
 * <p>
 * The operations are described below:
 * <p>
 * "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
 * "./" : Remain in the same folder.
 * "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
 * You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
 * <p>
 * The file system starts in the main folder, then the operations in logs are performed.
 * <p>
 * Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: logs = ["d1/","d2/","../","d21/","./"]
 * Output: 2
 * Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: logs = ["d1/","d2/","./","d3/","../","d31/"]
 * Output: 3
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: logs = ["d1/","../","../","../"]
 * Output: 0
 */
public class CrawlerLogFolder {

    public int minOperations(String[] logs) {
        int level = 0;

        for (String log : logs) {
            if (log.startsWith("..") && level > 0)
                level--;

            else if (!log.startsWith("."))
                level++;
        }
        return level;
    }
}
