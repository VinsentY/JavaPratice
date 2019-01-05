package First;

//: holding/UniqueWords.java
import java.util.*;

import net.mindview.util.*;

class InterfaceVsIterator {
    public static void display(Iterator<String> it) {
      while(it.hasNext()) {
        String p = it.next();
        System.out.print(p + " ");
      }
      System.out.println();
    }
    public static void display(Collection<String> Strings) {
      for(String p : Strings)
        System.out.print(p + " ");
      System.out.println();
    }	
   
  }


public class CollectionSequence extends AbstractCollection<String> {

    public String[] strings = { "Try", "Fall", "Crush", "Upset", "Change", "Pursuit", "Happiness" };

    public static void main(String[] args) {
	CollectionSequence c = new CollectionSequence();
	InterfaceVsIterator.display(c);
	
	
    }

    @Override
    public Iterator<String> iterator() {

	return new Iterator<String>() {
	    private int index = 0;

	    @Override
	    public String next() {
		return strings[index++];
	    }

	    @Override
	    public boolean hasNext() {
		return index < strings.length;
	    }
	};
    }

    @Override
    public int size() {
	return strings.length;
    }
}
