package nine;

//从0~9中选择自然数排列后等式成立

public class Nine {
	
	int[] box = new int[10];
	int[] book = new int[10];
	
	int n = 0;
	
	int total;
	
	public void printTotal() {
		System.out.println("total is " + total/2);
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public void dfs(int step) {
		if (step == n + 1) {
			
			if (box[1] * 100 + box[2] * 10 + box[3] + box[4] * 100 + box[5] * 10 + box[6]
					== box[7] * 100 + box[8] * 10 + box[9]) {
				System.out.printf("%d%d%d + %d%d%d = %d%d%d\n", box[1],box[2],box[3],box[4],box[5],box[6],box[7],box[8],box[9]);
			}
			total++;
//			for(int i = 1; i <= n; i++) {
//				System.out.print(box[i]);
//			}
//			System.out.println();
		}
		
		for(int i = 1; i <= n; i++) {
			if (book[i] == 0) {
				box[step] = i;
				book[i] = 1;
				
				dfs(step + 1);
				book[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Nine nine = new Nine();
		nine.setN(9);
		nine.dfs(1);
		nine.printTotal();
	}

}
