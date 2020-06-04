package tech.problems;

import java.util.LinkedList;
import java.util.List;

public class PureNumber4And5 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++){
            System.out.println(getPureNumber(i));
        }
    }

    public static int getPureNumber(int n) {
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 44;
        }

        if (n == 2){
            return 55;
        }

        List<Integer> currentList = new LinkedList<>();
        currentList.add(44);
        currentList.add(55);
        List<Integer> newList = new LinkedList<>();
        int count = 2;

        while (count < n) {
            //Adding 4
            int i = 0;
            while (count < n && i < currentList.size()) {
                int newBlock = add4InBlock(currentList.get(i));
                count++;
                i++;
                newList.add(newBlock);
            }

            //Adding 5
            i = 0;
            while (count < n && i < currentList.size()) {
                int newBlock = add5InBlock(currentList.get(i));
                count++;
                i++;
                newList.add(newBlock);
            }

            if (count == n) {
                return newList.get(newList.size()-1);
            }

            currentList = newList;
            newList = new LinkedList<>();
        }

        return 0;
    }

    // Return 4<block>4
    public static int add4InBlock(int n) {
        int blk = n;
        blk = blk + (int) (4 * (Math.pow(10, sizeOfNumber(blk))));
        blk = (blk * 10) + 4;
        return blk;
    }

    // Return 5<block>5
    public static int add5InBlock(int n) {
        int blk = n;
        blk = blk + (int) (5 * (Math.pow(10, sizeOfNumber(blk))));
        blk = (blk * 10) + 5;
        return blk;
    }

    public static int sizeOfNumber(int num) {
        if (num == 0) {
            return 1;
        }
        int size = 0;
        while (num > 0) {
            num = num / 10;
            size++;
        }
        return size;
    }
}
