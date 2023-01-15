package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 937. Reorder Data in Log Files
 * <p>
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
 * <p>
 * There are two types of logs:
 * <p>
 * Letter-logs: All words (except the identifier) consist of lowercase English letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * <p>
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 * Example 2:
 * <p>
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class ReorderDataInLogFiles {

  public String[] reorderLogFiles(String[] logs) {
    List<Log> letterLogs = new ArrayList<>();
    List<Log> digitLogs = new ArrayList<>();

    for (String word : logs) {
      int secondWordStart = word.indexOf(" ");
      String identifier = word.substring(0, secondWordStart);
      String content = word.substring(secondWordStart + 1);
      Log log = new Log(identifier, content);

      if (Character.isDigit(content.charAt(0)))
        digitLogs.add(log);
      else
        letterLogs.add(log);
    }

    List<Log> sorted = new ArrayList<>(letterLogs.stream()
      .sorted(Comparator.comparing(Log::content).thenComparing(Log::identifier))
      .toList());

    sorted.addAll(digitLogs);
    return sorted.stream().map(log -> log.identifier() + " " + log.content()).toArray(String[]::new);
  }

  private record Log(String identifier, String content) {
  }
}
