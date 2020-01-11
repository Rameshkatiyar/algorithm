package tech.ds.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> charNodeMap;
    Boolean endOfWord;

    public TrieNode() {
        this.charNodeMap = new HashMap<>();
        this.endOfWord = false;
    }

    public Map<Character, TrieNode> getCharNodeMap() {
        return charNodeMap;
    }

    public void setCharNodeMap(Map<Character, TrieNode> charNodeMap) {
        this.charNodeMap = charNodeMap;
    }

    public Boolean getEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(Boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
