package tech.dsa.strings;

public class MyStringBuilder {
    private final int MULTIPLIER = 2;
    private final int DEFAULT_SIZE = 16;

    private char[] str;
    private int size;
    private int charCount;

    public MyStringBuilder(String str){
        this.str = new char[DEFAULT_SIZE];
        this.str = str.toCharArray();
    }

    public MyStringBuilder append(String str) {
        while (resizeRequired(str)) {
            resizeBuffer(str);
        }
        addString(str);
        updateCharCount(str.length());
        return this;
    }

    private boolean resizeRequired(String newInput) {
        return this.charCount + newInput.length() > this.size;
    }

    private void resizeBuffer(String newInput) {
        int oldSize = this.size;
        this.size *= MULTIPLIER; // Update buffer size
        char[] newStr = new char[this.size];
        System.out.printf("Resizing array: Increasing size from %d to %d\n", oldSize, this.size);
        // Copy to new array
        System.arraycopy(this.str, 0, newStr, 0, oldSize);
        // Set new array
        this.str = newStr;
    }

    private void addString(String str) {
        // Copy elements from string to append into the underlying char array.
        System.arraycopy(str.toCharArray(), 0,
                this.str,  this.charCount , str.length());
    }

    private void updateCharCount(int charCount) {
        this.charCount += charCount;
    }

}
