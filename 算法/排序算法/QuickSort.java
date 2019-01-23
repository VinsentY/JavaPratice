package yikai.s.Sort;

import yikai.s.util.GeneratingArrays;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static Random random = new Random();

    private static int[] _arr;

    public static void quickSort(int[] arr) {
        _arr = arr;
        quickSort(0, arr.length - 1);
    }


    private static void quickSort(int lo, int hi) {
        if (hi <= lo) return;
        int mi = partition(lo, hi);
        quickSort(lo, mi - 1);
        quickSort(mi + 1, hi);
    }

    private static int partition(int lo, int hi) {
        int m = random.nextInt(hi - lo + 1) + lo; //在[lo, hi]中随机生成m
        int t = _arr[m]; _arr[m] = _arr[lo]; _arr[lo] = t;

        int pivot = _arr[lo];
        while (lo != hi) {
            while (lo != hi && _arr[hi] >= pivot) hi--;
            _arr[lo] = _arr[hi];
            while (lo != hi && _arr[lo] <= pivot) lo++;
            _arr[hi] = _arr[lo];
        }
        _arr[lo] = pivot;
        return lo; //return pivitpos' index
    }

    public static void main(String[] args) {
        int[] arr = GeneratingArrays.generatingArrays(0,500, 1000);
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
