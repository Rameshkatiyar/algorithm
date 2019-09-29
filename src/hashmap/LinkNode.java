package hashmap;

public class LinkNode<K,V> {
    private K key;
    private V value;
    private LinkNode<K,V> next = null;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public LinkNode<K, V> getNext() {
        return next;
    }

    public void setNext(LinkNode<K, V> next) {
        this.next = next;
    }
}
