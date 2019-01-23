package yikai.s.Sort;

import java.util.Random;
import java.util.Stack;

public class MergeSort {

	private static int cnt = 0;

	public static int[] mergeSort(int[] arr) {
        long startTime = System.currentTimeMillis();
		arr = mergeSort(arr, 0, arr.length);
        System.out.println(System.currentTimeMillis() - startTime);
        return arr;

	}

	public static int[] mergeSort(int[] arr, int begin, int end) {

		if (end - begin <= 1) {
			return arr;
		}
		int middle = (begin + end) / 2;
		mergeSort(arr, begin, middle);
		mergeSort(arr, middle, end);
		merge(arr, begin, middle, end);

		return arr;
	}

	private static void merge(int[] arr, int begin, int middle, int end) {
		Stack<Integer> A = new Stack<>();
		for (int i = middle - 1; i >= begin; i--) {
			A.push(arr[i]);
		}
		Stack<Integer> B = new Stack<>();
		for (int i = end - 1; i >= middle; i--) {
			B.push(arr[i]);
		}

		int i = begin;
		while (!A.isEmpty() && !B.isEmpty()) {
			if (A.peek() < B.peek()) {
				arr[i] = A.pop();
			} else {
				arr[i] = B.pop();
			}
			i++;
			cnt++;
		}

		if (A.isEmpty()) {
			while (!B.isEmpty()) {
				arr[i++] = B.pop();
			}
		} else {
			while (!A.isEmpty()) {
				arr[i++] = A.pop();
			}
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		int MAXSIZE = 100000;
		int[] arr = new int[MAXSIZE];
		for (int i = 0; i < MAXSIZE; i++) {
			arr[i] = random.nextInt(MAXSIZE);
		}

		int[] arr1 = new int[MAXSIZE];
		for (int i = 0; i < MAXSIZE; i++) {
			arr1[i] = arr[i];
		}

		new Thread(new Runnable() {

			@Override
			public void run() {
				double before = System.currentTimeMillis();
				
				// ��Ч����߸о�����һ������
				Bubblesort.bubbleSortFinal(arr1, 0, arr.length, true);
				System.out.println("Bubble yikai.s.Sort Finish");
//				System.out.println(Arrays.toString(arr));
				
				double after = System.currentTimeMillis();
				System.out.println("Bubble Running Time: " + (after - before));
			}
		}).run();

		new Thread(new Runnable() {

			@Override
			public void run() {
				double before = System.currentTimeMillis();
				
				mergeSort(arr);
				System.out.println("Merger yikai.s.Sort Finish \n cnt = " + cnt);
//				System.out.println(Arrays.toString(arr));
				
				double after = System.currentTimeMillis();
				System.out.println("Merger Running Time(ms): " + (after - before));

			}
		}).run();

	}

}
