package com.entrust.trials.Sorting;

import java.util.Arrays;

/**
 *
 Start with the result as the first element of the input.

 Loop over the input until it is empty, "removing" the first remaining (leftmost) element.
 Compare the removed element against the current result, starting from the highest (rightmost) element,
 and working left towards the lowest element.

 If the removed input element is lower than the current result element,
 copy that value into the following element to make room for the new element below,
 and repeat with the next lowest result element.

 Otherwise, the new element is in the correct location; save it in the cell left
 by copying the last examined result up, and start again from (2) with the next input element.
 *
 */

public class InsertionSort {


    /* * Method to Sort String array using insertion sort in Java.
    * * This can also sort any object array which implements * Comparable interface. */
    public static void insertionSort(Comparable[] objArray) {
        // insertion sort starts from second element
        for (int i = 1; i < objArray.length; i++) {
            Comparable objectToSort = objArray[i];
            int j = i;
            while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 0) {
                objArray[j] = objArray[j - 1];
                j--;
            }
            objArray[j] = objectToSort;
        }
    }

    public static void main(String args[]) {
        // getting unsorted integer array for sorting
        Integer[] randomOrder = getRandomArray(9);
        System.out.println("Random Integer array before Sorting : " +
                Arrays.toString(randomOrder));
        // sorting array using insertion sort in Java
        insertionSort(randomOrder);
        System.out.println("Sorted array uisng insretion sort : " + Arrays.toString(randomOrder));
        // one more example of sorting array using insertion sort
        randomOrder = getRandomArray(7);
        System.out.println("Before Sorting : " + Arrays.toString(randomOrder));
        insertionSort(randomOrder);
        System.out.println("After Sorting : " + Arrays.toString(randomOrder));
        // Sorting String array using Insertion Sort in Java
        String[] cities = {"London", "Paris", "Tokyo", "NewYork", "Chicago"};
        System.out.println("String array before sorting : " + Arrays.toString(cities));
        insertionSort(cities);
        System.out.println("String array after sorting : " + Arrays.toString(cities));
    }

    public static Integer[] getRandomArray(int length) {
        Integer[] numbers = new Integer[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        return numbers;
    }

}

