package com.assessment.feefo;

import com.assessment.feefo.enums.StandardizedJobTitles;

public class JobStandardizer {

    // This is based off of Apache's FuzzyScore. Further reading @ https://commons.apache.org/sandbox/commons-text/jacoco/org.apache.commons.text.similarity/FuzzyScore.java.html

    public String standardize(String enteredJobTitle) {
        StandardizedJobTitles[] availableJobTitles = StandardizedJobTitles.values();
        int[] distanceValues = getFuzzyDistanceValues(enteredJobTitle, availableJobTitles);
        return availableJobTitles[minValueIndex(distanceValues)].toString();
    }

    private int[] getFuzzyDistanceValues(String enteredJobTitle, StandardizedJobTitles[] availableJobTitles) {
        int[] distanceValues = new int[StandardizedJobTitles.values().length];
        for (int i = 0; i < StandardizedJobTitles.values().length; i++) {
            distanceValues[i] = validateAndGetFuzzyScore(availableJobTitles[i].toString(), enteredJobTitle);
        }
        return distanceValues;
    }

    private int validateAndGetFuzzyScore(final String term, final String query) {
        if (term == null || query == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        final String termLowerCase = term.toLowerCase();
        final String queryLowerCase = query.toLowerCase();

        return calculateFuzzyScore(termLowerCase, queryLowerCase);
    }

    private int calculateFuzzyScore(String termLowerCase, String queryLowerCase) {
        int score = 0;
        int previousMatchingCharacterIndex = Integer.MIN_VALUE;

        for (int queryIndex = 0; queryIndex < queryLowerCase.length(); queryIndex++) {
            final char queryChar = queryLowerCase.charAt(queryIndex);
            boolean termCharacterMatchFound = false;
            for (int termIndex = 0; termIndex < termLowerCase.length()
                    && !termCharacterMatchFound; termIndex++) {
                final char termChar = termLowerCase.charAt(termIndex);
                if (queryChar == termChar) {
                    score++;
                    if (previousMatchingCharacterIndex + 1 == termIndex) {
                        score += 2;
                    }
                    previousMatchingCharacterIndex = termIndex;
                    termCharacterMatchFound = true;
                }
            }
        }
        return score;
    }

    public static int minValueIndex(int[] numbers) {
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
