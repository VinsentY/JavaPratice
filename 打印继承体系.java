package 继承体系;

class Basic {
    
}


interface face1 {
    
}

interface face2 {
    
}


class Derive extends Basic implements face1, face2{
    
}

interface addInterface {
    
}

class Add extends Derive implements addInterface{
    
}

class Mess extends Add{
    
}

public class Test {
    static void printClasses(Class<?> c) {
	if (c==null) {
	    return;
	}
	System.out.println(c.getName());
	for(Class<?> k : c.getInterfaces()) {
	    System.out.println("Interface: " + k.getName());
	    printClasses(k.getSuperclass());
	}
	printClasses(c.getSuperclass());
    }
    
    public static void main(String[] args) {
	printClasses(Mess.class);
    }
}
