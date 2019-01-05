package five; 

import java.util.Arrays;
import java.util.Random;

import javax.swing.text.TabSet;

public class Test {
		
	static private Random random = new Random(47);
	
	public int[] arr1;
	public int[] arr2;
	public int[] arr3;
	
	public Test() {
		arr1 = new int[7];
		arr2 = new int[4];
		arr3 = new int[11];
		initArr(arr1);
		initArr(arr2);
		initArr(arr3);
	}
	
	public void initArr(int[] arr) {	
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10) + 1;
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		// 第一个参数表示源数组
        // 第二个参数表示开始位置(取得到)
        // 第三个参数表示结束位置(取不到)
		test.arr3 = Arrays.copyOfRange(test.arr1, 2, 7);	//第一个，数组复制	
		System.out.println(Arrays.toString(test.arr1));
		System.out.println(Arrays.toString(test.arr3));	//第二个，直接打印数组
		Arrays.sort(test.arr3);
		System.out.println(Arrays.toString(test.arr3));
		System.out.println(Arrays.toString(test.arr2));
		Arrays.sort(test.arr2);
		System.out.println("数字 62出现的位置:"+Arrays.binarySearch(test.arr2, 8));	//第三个，二进制搜搜
		
		System.out.println(Arrays.equals(test.arr1, test.arr3));	//第四个，比较两个数组元素是否相等
		
		//像这样的方法一般都有很多种重载方法，所以填充和复制的方法很自由
		Arrays.fill(test.arr2, 9);	//第五个，填充数组	
		
		System.out.println(Arrays.toString(test.arr2));
    
		
	}

}
