package First;

//: holding/UniqueWords.java
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.*;

public class CollectionSequence {

    static String regex = "\\p{javaUpperCase}.*\\."; // 大写字母开头，句号结尾
    static String regex10 = "//s+(the|you)\\s+";	//在the you处分割
    static String regex11 = "(?i)[aeiou]";	//将元音字母变为_

   public static void main(String args[]) {
       String string = "Java now has regular expression.s";
       String string2 = "Then, when you have found the shrubbery, you must " +
	       		"cut down the mightiest tree in the forest..." + 
	       		"with... a herring!";
       System.out.println(string2.matches(regex));
       System.out.println(Arrays.toString(string2.split(regex10)));
      System.out.println(string2.replaceAll(regex11, "_"));
      
       String regex = "^Java.*";
       String regex1 = "\\breg.*";
       String regex2 = "n.w\\s+h(a|i)s";//now has
       String regex3 = "(s)?";//匹配一个或零个
       String regex4 = "(s)*";//匹配零个或多个s
       String regex5 = "s+";//匹配1个或多个s
       String regex6 = "s{4}";	//恰好四个
       String regex7 = "s{1,3}";	//至少1个，最多3个
       System.out.println("字符串: \"" + string + "\"");
      Pattern pattern = Pattern.compile(regex7);
      Matcher matcher = pattern.matcher(string);
      while(matcher.find()) {
	  System.out.println("Match \"" + matcher.group() + "\" at positions " + matcher.start() + "-" + (matcher.end() - 1));
      }
      
  }
}
