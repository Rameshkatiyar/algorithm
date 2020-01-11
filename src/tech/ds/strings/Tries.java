package tech.ds.strings;

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

    public void insert(String text){
        TrieNode nodePointer = rootNode;
        int index;
        int lengthOfText = text.length();
        for (index=0; index< lengthOfText; index++){
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
        if (index == lengthOfText){
            nodePointer.setEndOfWord(true);
        }
    }

    public boolean search(String text){
        return false;
    }

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
        System.out.print("Node: "+trieNode.hashCode()+" Characters: {");
        charNodeMap.keySet().stream()
                .forEach(
                        character -> {
                            System.out.print("["+character+" : "+charNodeMap.get(character).hashCode()+"]");
                        }
                );
        System.out.println("}");
    }
}
