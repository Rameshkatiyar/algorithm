package tech.ds.hashmap;

public class HashTest {

    public static void main(String rn[]){
        HashMap<String, String> hashMap = new HashMap<>();

        System.out.println("Start:  "+hashMap.get("a"));

        hashMap.put("a", "123");
        hashMap.put("b", "456");
        hashMap.put("c", "789");
        hashMap.put("b", "000");
        hashMap.put("q", "111");

        System.out.println("End:  "+hashMap.get("a"));
        System.out.println("End:  "+hashMap.get("b"));
        System.out.println("End:  "+hashMap.get("c"));
        System.out.println("End:  "+hashMap.get("d"));
        System.out.println("End:  "+hashMap.get("q"));

        hashMap.delete("c");
        System.out.println("End:  "+hashMap.get("c"));
        hashMap.delete("f");

    }

}