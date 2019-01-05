package First;

//: holding/UniqueWords.java
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.Print.*;
import jdk.dynalink.beans.StaticClass;

class Hshape {
    boolean highlighted = false;
    public void highlight() { highlighted = true; }
    public void clearHighlight() { highlighted = false; }
    
    public void draw() { System.out.println(this + " draw()"); }
    public String toString() { 
	return getClass().getName() + (highlighted ? " highlighted " : " normal");
    }
    
    static List<Hshape> shapes = new ArrayList<Hshape>();
    public Hshape() { shapes.add(this); }
    
    static void highlight(Class<?> type) {
	for(Hshape shape : shapes) {
	    if(type.isInstance(shape)) {
		shape.highlight();
	    }
	}
    }
    
    static void clearHighlight(Class<?> type) {
	for(Hshape shape : shapes) {
	    if (type.isInstance(shape)) {
		shape.clearHighlight();
	    }
	}
    }
    
}

class HCircle extends Hshape {}
class HSquare extends Hshape {}
class HTriangle extends Hshape {}

public class HighlightTest {
    
    public static void main(String[] args) {
	List<Hshape> shapes = Arrays.asList(new HCircle(), new HSquare(),
		new HTriangle(), new HSquare(),
		new HTriangle(), new HCircle(),
		new HCircle(), new HSquare());
	Hshape.highlight(HCircle.class);
	for(Hshape shape : shapes) {
	    shape.draw();
	}
    }
    
}
