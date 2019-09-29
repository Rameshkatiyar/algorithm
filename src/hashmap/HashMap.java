package hashmap;

public class HashMap<K,V> {
    private HashTable<K,V>[] hashTable;
    private int defaultSize = 16;

    public HashMap(){
        hashTable = new HashTable[defaultSize];
    }

    public void setDefaultSize(int defaultSize){
        this.defaultSize = defaultSize;
    }

    public void put(K key, V value){
        LinkNode<K, V> keyAlreadyExistInLinkedList = findKeyAlreadyExistInLinkedList(key);
        if (null != keyAlreadyExistInLinkedList){
            keyAlreadyExistInLinkedList.setValue(value);
            return;
        }

        int index = getIndex(key);
        HashTable<K, V> slot = hashTable[index];
        LinkNode<K, V> head = slot.getLinkHead().getNext();

        LinkNode<K,V> linkNode = new LinkNode<>();
        linkNode.setKey(key);
        linkNode.setValue(value);
        linkNode.setNext(head);
        slot.getLinkHead().setNext(linkNode);
    }

    public void delete(K key){

    }

    public V get(K key){
        LinkNode<K, V> linkNode = findKeyAlreadyExistInLinkedList(key);
        if (null != linkNode){
            return linkNode.getValue();
        }
        return null;
    }

    private LinkNode<K, V> findKeyAlreadyExistInLinkedList(K key){
        int index = getIndex(key);
        HashTable<K, V> slot = hashTable[index];
        LinkNode<K, V> head = slot.getLinkHead().getNext();
        while (null != head){
            if (head.getKey().equals(key)){
                return head;
            }else {
                head = head.getNext();
            }
        }
        return null;
    }

    //Hash function to get index
    private int getIndex(K key){
        int hashCode = key.toString().hashCode();
        int index = hashCode % defaultSize;
        return index;
    }
}
