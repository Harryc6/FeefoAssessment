package com.assessment.feefo;

import java.util.Arrays;

public class ArrayStatExtractor {

    public void getStats(int[] randomArray) {
        sortArrayViaBubbleSort(randomArray, randomArray.length);
        String median = String.valueOf(getMedian(randomArray));
        String mean = String.valueOf(getMean(randomArray));
        String mode = String.valueOf(getMode(randomArray));
        String range = getRange(randomArray);

        printInformation(median, mean, mode, range, randomArray);
    }

    private void sortArrayViaBubbleSort(int[] randomArray, int arrayLength) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < arrayLength - 1; i++) {
            swapped = false;
            for (j = 0; j < arrayLength - i - 1; j++) {
                if (randomArray[j] > randomArray[j + 1]) {
                    temp = randomArray[j];
                    randomArray[j] = randomArray[j + 1];
                    randomArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private double getMedian(int[] randomArray) {
        int middleIndex = randomArray.length / 2;
        if (randomArray.length % 2 == 1) {
            return randomArray[middleIndex];
        } else {
            return (randomArray[middleIndex-1] + randomArray[middleIndex]) / 2.0;
        }
    }

    private Double getMean(int[] randomArray) {
        long sum = 0;
        for (int i : randomArray) {
            sum += i;
        }
        return (double) sum / randomArray.length;
    }
    
    private int getMode(int[] randomArray) {
        int maxKey = 0;
        int maxKeyCount = 0;
        int currentKey = 0;
        int currentCount = 0;

        for (int i : randomArray) {
            if (currentKey == i) {
                currentCount++;
                if (currentCount > maxKeyCount) {
                    maxKey = currentKey;
                    maxKeyCount = currentCount;
                }
            } else {
                currentKey = i;
                currentCount = 0;
            }
        }
        return maxKey;
    }
    
    private String getRange(int[] randomArray) {
        return randomArray[0] + " - " + randomArray[randomArray.length - 1];
    }

    private void printInformation(String median, String mean, String mode, String range, int[] randomArray) {
        System.out.println();
        System.out.println("Stats extracted from the array generated:");
        System.out.println("    Median: " + median);
        System.out.println("    Mean: " + mean);
        System.out.println("    Mode: " + mode);
        System.out.println("    Range: " + range);
//
//        System.out.println();
//        System.out.println("Array generated for checking:");
//        System.out.println(Arrays.toString(randomArray));
    }

}
