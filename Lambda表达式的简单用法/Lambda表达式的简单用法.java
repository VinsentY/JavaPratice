package five;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;



class Person {
	private int age;

	public Person(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return age + "";
	}

}

public class five {

	public static void filter( List<Person> lists, HeroChecker hc) {
		
		List<Person> newList = new ArrayList<>();
		
		for(Person temp : lists) {
			if (hc.test(temp)) {
				newList.add(temp);
			}
		}
		
		lists.clear();
		lists.addAll(newList);
	}	

	public static void main(String[] args) throws IOException {

		ArrayList<Person> lists = new ArrayList<>();
		Random r = new Random();

		// lists.addAll(Arrays.asList(new Person(r.nextInt(8)),new Person(r.nextInt(8)),
		// new Person(r.nextInt(8)),new Person(r.nextInt(8)),new Person(r.nextInt(8))));

		for (int i = 0; i < 18; i++) {
			lists.add(new Person(r.nextInt(18) + 1));
		}
		
//		过滤器
//		HeroChecker hc = new HeroChecker(){
//			@Override
//			public boolean test(Person p) {
//				return p.getAge() > 10;
//			}
//		};
//		
//		filter(lists, hc);

//		Lambda表达式
//		filter(lists, h -> h.getAge() > 10);
		
//		比较器
		Comparator<Person> c = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() -  p2.getAge();
			}
			
		};
		
		Collections.sort(lists,c);
		
//		Lambda表达式
//		Collections.sort(lists, (p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1);
		
//		Collections.reverse(lists);
		
		System.out.println(lists);
	}
}