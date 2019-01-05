package ninty;

public class Match {
	
	public static int f(int x) {
		int num = 0;
		
		//每个数字需要的火柴
		int[] f = {6,2,5,5,4,5,6,3,7,6};
		
		while(x/10 != 0) {
			num  += f[x % 10];
			x /= 10;
			
		}
		num += f[x];
		return num;
		
	}
	
	public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		int m = 18;
		int sum = 0;
		
		int max = initMax(Math.round((m - 4)/4));
		
		for(a = 0; a < max; a++) {
			for(b = 0; b < max; b++) {
				c = a + b;
				if (f(a) + f(b) + f(c) == m - 4 ) {
					System.out.printf("%d + %d = %d\n",a,b,c);
					sum++;
				}
			}
		}
		
		System.out.printf("一共可以拼出%d个不同的等式",sum);
		
	}

	private static int initMax(int i) {
			
		return (int) ((Math.pow(10, i + 1) - 1) / 9);
	}

}
