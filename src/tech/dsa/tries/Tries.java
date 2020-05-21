package tech.dsa.tries;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Tries {
    private TrieNode rootNode;

    public TrieNode getRootNode() {
        return rootNode;
    }

    public Tries(){
        this.rootNode = new TrieNode();
    }

    /**
     * Insert Complexity: O(l) = length of text
     * @param text
     */
    public void insert(String text){
        TrieNode nodePointer = rootNode;

        for (int index=0; index< text.length(); index++){
            char c = text.charAt(index);
            if (isTrieNodeContainChar(nodePointer, c)){
                TrieNode childNode = nodePointer.getCharNodeMap().get(c);
                nodePointer = childNode;
            }else {
                Map<Character, TrieNode> childNodeMap = nodePointer.getCharNodeMap();
                TrieNode newNode = new TrieNode();
                childNodeMap.put(c, newNode);
                nodePointer = newNode;
            }
        }
        nodePointer.setEndOfWord(true);
    }

    /**
     * Search Complexity: O(l) = length of text
     * @param text
     * @return
     */
    public boolean search(String text){
        TrieNode nodePointer = rootNode;

        for (int index=0; index< text.length(); index++){
            char c = text.charAt(index);
            if (isTrieNodeContainChar(nodePointer, c)){
                nodePointer = nodePointer.getCharNodeMap().get(c);
            }else {
                return false;
            }
        }
        return nodePointer.getEndOfWord();
    }

    //TODO
    public boolean delete(String text){
        return false;
    }

    private boolean isTrieNodeContainChar(TrieNode trieNode, Character character){
        return trieNode.getCharNodeMap().containsKey(character);
    }

    public void traversTries(TrieNode rootNode){
        Queue<TrieNode> trieNodeQueue = new LinkedList<>();
        trieNodeQueue.add(rootNode);

        while (!trieNodeQueue.isEmpty()){
            TrieNode trieNode = trieNodeQueue.poll();
            printNode(trieNode);

            Map<Character, TrieNode> charNodeMap = trieNode.getCharNodeMap();
            charNodeMap.keySet().stream()
                    .forEach(
                            character -> {
                                TrieNode childNode = charNodeMap.get(character);
                                trieNodeQueue.add(childNode);
                            }
                    );
        }
    }

    private void printNode(TrieNode trieNode){
        Map<Character, TrieNode> charNodeMap = trieNode.getCharNodeMap();
        System.out.print("Node: "+trieNode.hashCode()+" CharNodeMap: {");
        charNodeMap.keySet().stream()
                .forEach(
                        character -> {
                            System.out.print("["+character+" : "+charNodeMap.get(character).hashCode()+"]");
                        }
                );
        System.out.println("}");
    }
}
