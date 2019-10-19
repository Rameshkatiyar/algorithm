package tech.ds.hashmap;

public class HashMap<K,V> {
    private HashTable<K,V>[] hashTable;
    private int defaultSize = 16;

    public HashMap(){
        hashTable = new HashTable[defaultSize];
        createHashTable();
    }

    private void createHashTable(){
        for (int i = 0; i<hashTable.length; i++){
            HashTable<K,V> hashTable = new HashTable<>();
            hashTable.setCount(0);
            hashTable.setLinkHead(null);
            this.hashTable[i] = hashTable;
        }
    }

    public void put(K key, V value){
        LinkNode<K, V> keyAlreadyExistInLinkedList = findKeyAlreadyExistInLinkedList(key);
        if (null != keyAlreadyExistInLinkedList){
            System.out.println("Key already existing. Key: "+key+" Overriding value: "+value);
            keyAlreadyExistInLinkedList.setValue(value);
            return;
        }

        int index = getIndex(key);
        HashTable<K, V> slot = hashTable[index];
        LinkNode<K, V> head = slot.getLinkHead();

        LinkNode<K,V> linkNode = new LinkNode<>();
        linkNode.setKey(key);
        linkNode.setValue(value);
        linkNode.setNext(head);

        slot.setLinkHead(linkNode);
    }

    public void delete(K key){
        int index = getIndex(key);
        HashTable<K, V> slot = hashTable[index];
        LinkNode<K, V> head = slot.getLinkHead();

        while (null != head){
            LinkNode<K, V> previous = head;
            if (head.getKey().equals(key)){
                previous = head.getNext();
                slot.setLinkHead(previous);
                System.out.println("Value Removed For Key: "+key);
                return;
            }else {
                head = head.getNext();
            }
        }
        System.out.println("For remove the value not found Key: "+key);
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
        LinkNode<K, V> head = slot.getLinkHead();
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
        System.out.println(index+" Index For Key: "+key+" Hashcode: "+hashCode);
        return index;
    }
}
