package com.assessment.feefo;

public class Main {

    public static void main(String[] args) {
        int[] randomArray = generateRandomArray();
        ArrayStatExtractor statExtractor = new ArrayStatExtractor();
        statExtractor.getStats(randomArray);
    }

    private static int[] generateRandomArray() {
        System.out.println("Generating random array.");
        int randomArraySize = (int) Math.round(Math.random() * 1000);
        int[] randomArray = new int[randomArraySize];
        for (int i = 0; i < randomArraySize; i++) {
            randomArray[i] = (int) Math.round((Math.random() * 100) * (Math.random() * 100));
        }
        System.out.println("Array generated.");
        return randomArray;
    }
}
