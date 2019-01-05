package seven;

import java.util.*;



class Person implements Comparable<Person>{
	
	private int age;
	
	public Person(int age) {
		
		this.age = age;
	}

	@Override
	public int compareTo(Person obj) {
		//异常判断
        if(obj == null){
            throw new NullPointerException("所比较对象不能为空");
        }

        Person p = (Person)obj;
        return this.age - p.age;
	}

	@Override
	public String toString() {
		return age + "";
	}
	
	
		
}

public class Node<T extends Comparable<T>> {
	
	public Node<T> leftNode;
	
	public Node<T> rightNode;
	
	private T value;
	
	public void add(T input) {
		if (value == null) {
			value = input;
		} else {
			if ((input.compareTo(value) <= 0)) {
				if (leftNode == null) {
					leftNode = new Node<>();
				}
				leftNode.add(input);
			} else {
				if (rightNode == null) {
					rightNode = new Node<>();
				}
				rightNode.add(input);
			}
		}
	}
	
	public List<T> values() {
		List<T> values = new ArrayList<>();
		
		if (leftNode != null) {
			values.addAll(leftNode.values());
		} 
		values.add(value);
		if (rightNode != null) {
			values.addAll(rightNode.values());
		}
		
		return values;
	}
	
	public static void main(String[] args) {
		
		//int[] randoms = new int[] {67,7,30,73,13,0,78,81,10,74};
		
				
		Person[] randoms = new Person[] { new Person(17), new Person(20), new Person(6)};
		
		Node<Person> roots = new Node<>();
		
		for(Person number : randoms) {
			roots.add(number);
		}
		
		System.out.println(roots.values());
		
	}

}
