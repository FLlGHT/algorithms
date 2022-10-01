package string;

import java.util.*;

/**
 * 1152. Analyze User Website Visit Pattern
 * <p>
 * You are given two string arrays username and website and an integer array timestamp.
 * All the given arrays are of the same length and the tuple [username[i], website[i], timestamp[i]]
 * indicates that the user username[i] visited the website website[i] at time timestamp[i].
 * <p>
 * A pattern is a list of three websites (not necessarily distinct).
 * <p>
 * For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.
 * The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared in the pattern.
 * <p>
 * For example, if the pattern is ["home", "away", "love"],
 * the score is the number of users x such that x visited "home" then visited "away" and visited "love" after that.
 * Similarly, if the pattern is ["leetcode", "love", "leetcode"],
 * the score is the number of users x such that x visited "leetcode" then visited "love" and visited "leetcode" one more time after that.
 * Also, if the pattern is ["luffy", "luffy", "luffy"],
 * the score is the number of users x such that x visited "luffy" three different times at different timestamps.
 * Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the lexicographically smallest such pattern.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
 * timestamp = [1,2,3,4,5,6,7,8,9,10],
 * website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation: The tuples in this example are:
 * ["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],["james","cart",5],
 * ["james","maps",6],["james","home",7],["mary","home",8],["mary","about",9], and ["mary","career",10].
 * The pattern ("home", "about", "career") has score 2 (joe and mary).
 * The pattern ("home", "cart", "maps") has score 1 (james).
 * The pattern ("home", "cart", "home") has score 1 (james).
 * The pattern ("home", "maps", "home") has score 1 (james).
 * The pattern ("cart", "maps", "home") has score 1 (james).
 * The pattern ("home", "home", "home") has score 0 (no user visited home 3 times).
 * Example 2:
 * <p>
 * Input: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website = ["a","b","a","a","b","c"]
 * Output: ["a","b","a"]
 */
public class AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, Set<String>> patternInfo = new HashMap<>();
        Map<String, List<String>> usersHistory = new HashMap<>();

        List<VisitInfo> visitInfo = new ArrayList<>();
        for (int i = 0; i < username.length; ++i) {
            visitInfo.add(new VisitInfo(username[i], timestamp[i], website[i]));
            usersHistory.putIfAbsent(username[i], new ArrayList<>());
        }

        visitInfo.sort(Comparator.comparing(VisitInfo::timestamp));
        String mostVisitedPattern = "";
        for (VisitInfo info : visitInfo) {
            List<String> userHistory = usersHistory.get(info.userName());
            userHistory.add(info.website());

            if (userHistory.size() >= 3)
                mostVisitedPattern = checkMostVisitedPattern(patternInfo, mostVisitedPattern, info, userHistory);
        }

        String[] mostVisitedSites = mostVisitedPattern.split(" ");
        return List.of(mostVisitedSites[0], mostVisitedSites[1], mostVisitedSites[2]);
    }

    private String checkMostVisitedPattern(Map<String, Set<String>> patternInfo, String mostVisitedPattern,
                                           VisitInfo info, List<String> userHistory) {
        for (int i = 0; i < userHistory.size() - 2; ++i) {
            for (int j = i + 1; j < userHistory.size() - 1; ++j) {
                for (int k = j + 1; k < userHistory.size(); ++k) {
                    String pattern = userHistory.get(i) + " " + userHistory.get(j) + " " + userHistory.get(k);

                    patternInfo.putIfAbsent(pattern, new HashSet<>());
                    patternInfo.get(pattern).add(info.userName());

                    int mostVisitedPatternViews = patternInfo.getOrDefault(mostVisitedPattern, new HashSet<>()).size();
                    int currentPatternViews = patternInfo.get(pattern).size();

                    if ((mostVisitedPattern.isEmpty()) || (mostVisitedPatternViews < currentPatternViews)
                            || (mostVisitedPatternViews == currentPatternViews && pattern.compareTo(mostVisitedPattern) < 0))
                        mostVisitedPattern = pattern;
                }
            }
        }
        return mostVisitedPattern;
    }

    record VisitInfo(String userName, int timestamp, String website) {

    }
}
