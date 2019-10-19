package tech.ds.hashmap;

public class HashTable<K,V> {
    private int count;
    private LinkNode<K,V> linkHead;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LinkNode<K, V> getLinkHead() {
        return linkHead;
    }

    public void setLinkHead(LinkNode<K, V> linkHead) {
        this.linkHead = linkHead;
    }

}
