package two;

public class Two {

	public static int[] arr = {1, 4, 5, 6};
	
	public static int[] arr1 = {2, 5, 6, 7};
	
	public static void print(int[] arr, int x) {
		int sum  = 0;
		for(int i = 0 ; i < arr.length; i++) {
			sum += arr[i] * Math.pow(x, i);
		}
		System.out.println("Result is " + sum);
		
	}
	
	public static int print2(int[] arr, int x, int index) {
		int sum = 0;
		
		if (index == -1) {
			return 0;
		} else {
			sum += arr[index] * Math.pow(x, index) + print2(arr, x, index - 1);
			return sum;
		}
		
			
	}
	
	public static void other(int[] a, int[] b) {
		int sum = 0;
		for(int i = 0; i < a.length; i++ ) {
			sum += a[i] * b[i];
		}
		System.out.println("Result is " + sum);	
	}
	
	public static int other2(int[] a, int[] b, int length) {
		if (length == -1) {
			return 0;
		} else {
			return a[length] * b[length] +  other2(a, b, length - 1);
		}
		
	}
	
	public static int Ack(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if (n == 0) {
			return Ack(m - 1, 1);
		} else {
			return Ack(m - 1, Ack(m, n - 1));
		}
	}
	
	public static void main(String[] args) {
//		print(arr, 9);
//		System.out.println("Result is " + print2(arr, 9, arr.length - 1));
		
//		other(arr, arr1);
//		System.out.println(other2(arr, arr1,arr.length - 1));
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(Ack(i, j) + "  ");
			}
		}
		
	}

}
