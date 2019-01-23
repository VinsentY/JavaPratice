package yikai.s.Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import static yikai.s.Sort.Bubblesort.*;

public class SelectSort {

    public static int[] selectSort(int[] arr, boolean descending) {
        long startTime = System.currentTimeMillis();

        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (descending) {
                    if (arr[j] > arr[k]) {
                       k = j;
                    }
                } else {
                    if (arr[j] < arr[k]) {
                        k = j;
                    }
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
        System.out.println(System.currentTimeMillis() - startTime);
        return arr;
    }


}
