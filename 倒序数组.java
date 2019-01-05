package Third;

//: holding/NonCollectionSequence.java
import typeinfo.pets.*;
import java.util.*;

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {

    public Iterator<Pet> iterator() {
	return new Iterator<Pet>() {
	    private int index = 0;

	    public boolean hasNext() {
		return index < pets.length;
	    }

	    public Pet next() {
		return pets[index++];
	    }

	    public void remove() { // Not implemented
		throw new UnsupportedOperationException();
	    }
	};
    }

    public Iterable<Pet> reverse() {
	return new Iterable<Pet>() {

	    @Override
	    public Iterator<Pet> iterator() {

		return new Iterator<Pet>() {
		    private int index = pets.length - 1;

		    @Override
		    public Pet next() {
			return pets[index--];
		    }

		    @Override
		    public boolean hasNext() {
			return index > -1;
		    }
		};
	    }
	};
    }

    public Iterable<Pet> randomized() {
	return new Iterable<Pet>() {
	    @Override
	    public Iterator<Pet> iterator() {
		List<Pet> list = new ArrayList<Pet>(Arrays.asList(pets));
		Collections.shuffle(list);
		return list.iterator();
	    }
	};
    }

    public static void main(String[] args) {
	NonCollectionSequence nc = new NonCollectionSequence();
	for (Pet pet : nc.reverse()) {
	    System.out.print(pet + " ");
	}
	System.out.println();
	for (Pet pet : nc.randomized()) {
	    System.out.print(pet + " ");
	}

	System.out.println();
	for (Pet pet : nc) {
	    System.out.print(pet + " ");
	}
    }
} /*
   * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
   */// :~
