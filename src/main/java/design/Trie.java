package design;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private final Map<Character, TrieNode> nodes;

    public Trie() {
        nodes = new HashMap<>();
    }

    public void insert(String word) {
        insert(word, 0, nodes);
    }

    private void insert(String word, int index, Map<Character, TrieNode> nodeMap) {
        boolean isEnd = index == word.length() - 1;
        char letter = word.charAt(index);

        if (!nodeMap.containsKey(letter))
            nodeMap.put(letter, new TrieNode(1, (isEnd? 1 : 0), new HashMap<>()));

        else {
            TrieNode node = nodeMap.get(letter);
            node.setStartsWith(node.getStartsWith() + 1);
            node.setEndsWith(node.getEndsWith() + (isEnd? 1 : 0));
        }

        if (!isEnd)
            insert(word, index + 1, nodeMap.get(letter).getChildren());
    }

    public int countWordsEqualTo(String word) {
        return find(word, 0, nodes, false);
    }

    private int find(String word, int index, Map<Character, TrieNode> nodeMap, boolean startWith) {
        if (index >= word.length() || !nodeMap.containsKey(word.charAt(index)))
            return 0;

        char letter = word.charAt(index);

        if (index == word.length() - 1 && nodeMap.containsKey(letter)) {
            return startWith ? nodeMap.get(letter).getStartsWith() : nodeMap.get(letter).getEndsWith();
        }

        return find(word, index + 1, nodeMap.get(letter).getChildren(), startWith);
    }

    public int countWordsStartingWith(String prefix) {
        return find(prefix, 0, nodes, true);
    }


    public void erase(String word) {
        decreaseCount(word, 0, nodes);
    }

    private void decreaseCount(String word, int index, Map<Character, TrieNode> nodeMap) {
        char letter = word.charAt(index);
        TrieNode node = nodeMap.get(letter);
        node.setStartsWith(node.getStartsWith() - 1);

        if (node.getStartsWith() == 0)
            nodeMap.remove(letter);
        else if (index == word.length() - 1)
            node.setEndsWith(node.getEndsWith() - 1);
        else
            decreaseCount(word, index + 1, nodeMap.get(letter).getChildren());
    }

    private class TrieNode {
        private int startsWith;
        private int endsWith;
        private final Map<Character, TrieNode> children;

        public TrieNode(int startsWith, int endsWith, Map<Character, TrieNode> children) {
            this.startsWith = startsWith;
            this.endsWith = endsWith;
            this.children = children;
        }

        public int getStartsWith() {
            return startsWith;
        }

        public void setStartsWith(int startsWith) {
            this.startsWith = startsWith;
        }

        public int getEndsWith() {
            return endsWith;
        }

        public void setEndsWith(int endsWith) {
            this.endsWith = endsWith;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }
    }
}
