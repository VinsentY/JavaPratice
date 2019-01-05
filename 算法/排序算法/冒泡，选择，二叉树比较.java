package eleven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import seven.*;


public class Test {

	public static long bubbleSort(int[] arr) {
		int size = arr.length;

		long start = System.currentTimeMillis();

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		long end = System.currentTimeMillis();

		return end - start;
	}

	public static long SelectSort(int[] arr) {

		int size = arr.length;

		int minIndex, temp;
		long start = System.currentTimeMillis();
		for (int i = 0; i < size - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}

		long end = System.currentTimeMillis();

		return end - start;

	}
	
	public static int[] initArr() {
		int[] arr = new int[40000];
		Random random = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(40000) + 1;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		System.out.println("冒泡法排序算法时间: " + bubbleSort(initArr()));
		
		System.out.println("选择法排序算法时间: " + SelectSort(initArr()));
		
		int[] arr = initArr();
		
		Node<Integer> tree = new Node<>();
		
		long start = System.currentTimeMillis();	
		for(int temp : arr) {
			tree.add(temp);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("二叉树排序算法时间: " + (end - start));
	}
}
