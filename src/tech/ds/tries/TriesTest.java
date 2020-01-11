package tech.ds.tries;

public class TriesTest {
    public static void main(String args[]){
        Tries tries = new Tries();
        tries.insert("abc");
        tries.insert("abgl");
        tries.insert("cdf");
        //Traverse
        tries.traversTries(tries.getRootNode());
        //Searching
        System.out.println(tries.search("abc"));
    }
}
