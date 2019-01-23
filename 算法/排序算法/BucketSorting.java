package yikai.s.Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BucketSorting {
    public static void bucketSorting(int[] arr, int max) {
        int[] cnt = new int[max + 1];
        for(int t : arr) {
            cnt[t]++;
        }

        int n = 0;
        for(int i = 0; i < max + 1; i++) {
            for(int j = 0; j < cnt[i]; j++) {
                arr[n++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,4,5,1,2,6,4,1,2,1,45,14,1000};
        bucketSorting(arr,1000);
        System.out.println(Arrays.toString(arr));
    }
}
