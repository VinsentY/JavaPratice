package Third;
import java.awt.TextField;
//: holding/UniqueWordsAlphabetic.java
// Producing an alphabetic listing.
import java.util.*;



class Person {

    @Override
    public String toString() {
	return "Person [name=" + name + "]";
    }
    private String name;
    public Person(String name) {
	this.name = name;
    }
    
}

class Dream {
    @Override
    public String toString() {
	return "Dream [difficulty=" + difficulty + ", name=" + name + "]";
    }
    private int difficulty;
    private String name;
    public Dream(int difficulty, String name) {
	this.difficulty = difficulty;
	this.name = name;
    }
    
}

public class Test {
    public static Map<Person, List<Dream>> 
    dreamer = new HashMap<Person, List<Dream>>();
    public static Person person = new Person("Vinsent");
    
    static {
	dreamer.put(person, 
		Arrays.asList(new Dream(6, "Make A Emotional Game"), new Dream(9, "Hold A Website Successful"), new Dream(9, "Find The Beautiful World")));
	dreamer.put(new Person("Stupid Man"), Arrays.<Dream>asList(new Dream(0, "Waste time to Love")));
    }
    
    public static void main(String[] args) {
	for(Person person : dreamer.keySet()) {
	    System.out.println(person);
	    for(Dream dream : dreamer.get(person)) {
		System.out.println(dream);
	    }
	}
	
    }
}







