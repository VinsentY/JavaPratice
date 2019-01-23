package yikai.s.Sort;

import yikai.s.Link.Link;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Bubblesort {

	public static int[] bubblesort(int[] arr, boolean descending) {
        long startTime = System.currentTimeMillis();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (descending) {
					if (arr[j] < arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				} else {
					if (arr[j] > arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}
        System.out.println(System.currentTimeMillis() - startTime);
		return arr;
	}

	public static int[] bubblesortPro(int[] arr, boolean descending) {
        long startTime = System.currentTimeMillis();
		int length = arr.length;
		boolean sorted = false;
		while (!sorted) {
		    //发现队列有序后就直接退出循环
			sorted = true;
			for (int i = 0; i < length - 1; i++) {
				if (descending) {
					if (arr[i] < arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
						sorted = false;
					}
				} else {
					if (arr[i] > arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
						sorted = false;
					}
				}
			}
			length--;
		}
        System.out.println(System.currentTimeMillis() - startTime);
		return arr;
	}

	public static int[] bubbleSortFinal(int[] arr, int begin, int end, boolean descending) {
		long startTime = System.currentTimeMillis();
		int last;

		while (begin < end - 1) {
			last = begin;
			for (int i = begin; i < end - 1; i++) {
				if (descending) {
					if (arr[i] < arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
						last = i + 1;
					}
				} else {
					if (arr[i] > arr[i + 1]) {
						int temp = arr[i];
						arr[i] = arr[i + 1];
						arr[i + 1] = temp;
						last = i + 1;
					}
				}
			}
			//直接将终点设置到已检测的有序部分前一位
			end = last;
		}
        System.out.println(System.currentTimeMillis() - startTime);
		return arr;
	}

	public static void main(String[] args) {
		Random random = new Random();
		int MAXSIZE = 20000;
		Integer[] arr = new Integer[MAXSIZE];
		for (int i = 0; i < MAXSIZE; i++) {
			arr[i] = random.nextInt(MAXSIZE);
		}

		int[] arr1 = new int[MAXSIZE];
		for (int i = 0; i < MAXSIZE; i++) {
			arr1[i] = arr[i];
		}

		int[] arr2 = new int[MAXSIZE];
		for (int i = 0; i < MAXSIZE; i++) {
			arr2[i] = arr[i];
		}

        int[] arr3 = new int[MAXSIZE];
        for (int i = 0; i < MAXSIZE; i++) {
            arr3[i] = arr[i];
        }


		bubbleSortFinal(arr2, 0, arr2.length, false);
		System.out.println(Arrays.toString(arr2));

		SelectSort.selectSort(arr1,false);
        System.out.println(Arrays.toString(arr1));

        MergeSort.mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));

		Link<Integer> link = new Link<>(arr);
		InsertSort.insetSort(link, false);
        System.out.println(link);
	}

}
