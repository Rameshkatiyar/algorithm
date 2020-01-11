package tech.ds.strings;

public class TriesTest {
    public static void main(String args[]){
        Tries tries = new Tries();
        tries.insert("abc");
        tries.insert("abgl");
        tries.insert("cdf");
        tries.traversTries(tries.getRootNode());
    }
}
