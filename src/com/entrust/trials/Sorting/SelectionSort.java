package com.entrust.trials.Sorting;

import java.util.Arrays;

/**
 * The idea of selection sort is rather simple: the next largest (or smallest) element in
 * the array is repeatedly found and moved to its final position in the sorted array.
 * In order to sort the array in increasing order, i.e. the smallest element at the beginning
 */
public class SelectionSort {
    public static void selectionSort (Comparable[] list)
    {
        int min;
        Comparable temp;

        for (int index = 0; index < list.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
                if (list[scan].compareTo(list[min]) < 0)
                    min = scan;

            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }
    public static void main(String args[]) {
        // getting unsorted integer array for sorting
        Integer[] randomOrder = getRandomArray(9);
        System.out.println("Random Integer array before Sorting : " +
                Arrays.toString(randomOrder));
        // sorting array using insertion sort in Java
        selectionSort(randomOrder);
        System.out.println("Sorted array uisng insretion sort : " + Arrays.toString(randomOrder));
        // one more example of sorting array using insertion sort
        randomOrder = getRandomArray(7);
        System.out.println("Before Sorting : " + Arrays.toString(randomOrder));
        selectionSort(randomOrder);
        System.out.println("After Sorting : " + Arrays.toString(randomOrder));
        // Sorting String array using Insertion Sort in Java
        String[] cities = {"London", "Paris", "Tokyo", "NewYork", "Chicago"};
        System.out.println("String array before sorting : " + Arrays.toString(cities));
        selectionSort(cities);
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
