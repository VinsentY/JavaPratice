package three;

import java.util.Stack;

public class Three {
	
	public static int[] things = {1,1,2,2,4,5,5,6,7,8,8,8,9};
	
	public static boolean knapsackl(int leftover, int index) {
		int choicedThing = 0;
		boolean isFind = false;
		
		if (leftover == 0) {
			return true;
		} else if (leftover < things[0] || index == -1) {
			return false;
			
		} else {
			do {
				choicedThing = things[index];
				index--;
				isFind = knapsackl(leftover - choicedThing, index);
			} while ( index!= -1 && !isFind);
			if (!isFind) {
				return false;
			} else {
				System.out.print(choicedThing + "  ");
				return true;
			}
		}
	}
	
	public static void knapsackl2(int capacity, int index) {
		//我倒是觉得这个方法更好理解
		class Element {
			int weight;
			int index;
			
			
			
			public Element(int weight, int index) {
				super();
				this.weight = weight;
				this.index = index;
			}
			
		}
		Stack<Element> stack = new Stack<>();
		
		boolean noFail = true;
		int nowWeight = 0;
		
		while(nowWeight != capacity && noFail) {
			if ( nowWeight + things[0] <= capacity && index != -1) {
				stack.push(new Element(things[index], index));
				nowWeight += things[index];
				index--;
			} else {
				if (index == -1) {
					
					nowWeight -= stack.pop().weight;
				}
				if (stack.isEmpty()) {
					noFail = false;
					
				} else {
					Element temp = stack.pop();
					index = temp.index - 1;
					nowWeight -= temp.weight;
				}
			}
			
		}
		if (nowWeight == capacity) {
			while(!stack.isEmpty()) {
				System.out.print(stack.pop().weight + "  ");
			}
		} else {
			System.out.println("There is no ant selection!");
		}
	}
	
	

	public static void main(String[] args) {
		knapsackl2(20, things.length - 1);
				
	}

}
