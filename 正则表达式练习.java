package First;

//: holding/UniqueWords.java
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mindview.util.*;

public class CollectionSequence {

    static String regex = "\\p{javaUpperCase}.*\\."; // ��д��ĸ��ͷ����Ž�β
    static String regex10 = "//s+(the|you)\\s+";	//��the you���ָ�
    static String regex11 = "(?i)[aeiou]";	//��Ԫ����ĸ��Ϊ_

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
       String regex3 = "(s)?";//ƥ��һ�������
       String regex4 = "(s)*";//ƥ���������s
       String regex5 = "s+";//ƥ��1������s
       String regex6 = "s{4}";	//ǡ���ĸ�
       String regex7 = "s{1,3}";	//����1�������3��
       System.out.println("�ַ���: \"" + string + "\"");
      Pattern pattern = Pattern.compile(regex7);
      Matcher matcher = pattern.matcher(string);
      while(matcher.find()) {
	  System.out.println("Match \"" + matcher.group() + "\" at positions " + matcher.start() + "-" + (matcher.end() - 1));
      }
      
  }
}
