package string;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. Subdomain Visit Count
 *
 * A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 *
 * A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.
 *
 * For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
 * Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: cpdomains = ["9001 discuss.leetcode.com"]
 * Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
 * Explanation: We only have one website domain: "discuss.leetcode.com".
 * As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 * Example 2:
 *
 * Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
 * For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 */
public class SubdomainVisitCount {


    public List<String> subdomainVisits(String[] domains) {
        Map<String, Integer> visits = new HashMap<>();

        for (String domain : domains) {
            int count = Integer.parseInt(domain.split(" ")[0]);

            String[] subdomainsParts = domain.split(" ")[1].split("\\.");
            StringBuilder builder = new StringBuilder();

            for (int i = subdomainsParts.length - 1; i >= 0; --i) {
                builder.insert(0, "." + subdomainsParts[i]);
                String subdomain = builder.substring(1);
                visits.put(subdomain, visits.getOrDefault(subdomain, 0) + count);
            }
        }

        return visits.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).toList();
    }
}
