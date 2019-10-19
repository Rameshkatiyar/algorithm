package tech.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestDataProvider {
    public static List<Integer> getOrderedNumberList(int numberOfInputs){
        List<Integer> listOfNumber = new LinkedList<>();
        if (numberOfInputs <= 0){
            listOfNumber.add(1);
            return listOfNumber;
        }
        for (int i = 1; i <= numberOfInputs; i++){
            listOfNumber.add(i);
        }
        return listOfNumber;
    }

    public static List<Integer> getUnOrderedNumberList(int numberOfInputs){
        List<Integer> listOfNumber = new LinkedList<>();
        if (numberOfInputs <= 0){
            listOfNumber.add(1);
            return listOfNumber;
        }

        for (int i = 1; i <= numberOfInputs; i++){
            listOfNumber.add(getRandomNumberInts(1, numberOfInputs));
        }
        return listOfNumber;
    }

    public static int[] getOrderedNumberArray(int numberOfInputs){
        int[] array = new int[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++){
            array[i] = i+1;
        }
        return array;
    }

    public static int[] getUnOrderedNumberArray(int numberOfInputs){
        int[] array = new int[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++){
            array[i] = getRandomNumberInts(1, numberOfInputs);
        }
        return array;
    }

    private static int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
}
