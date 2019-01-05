package seven;

import six.MyStringBuffer;

public class Seven {

	public static void main(String[] args) {

		double before = System.currentTimeMillis();

		MyStringBuffer my = new MyStringBuffer();

		my.append("Vinsent ");
		my.append("is a handsome boy");
		for (int i = 0; i < 10000; i++) {
			my.insert(my.indexOf('a') + 1, " super");
		}
		String boy = my.toString();
		//System.out.println(boy);

		double after = System.currentTimeMillis();

		System.out.println("MyStringBuffer Spend Time: " + (after - before));

		
		
		
		double before1 = System.currentTimeMillis();

		StringBuffer my1 = new StringBuffer();

		my.append("Vinsent ");
		my.append("is a handsome boy");
		for (int i = 0; i < 10000; i++) {
			my.insert(my.indexOf('a') + 1, " super");
		}
		String boy1 = my.toString();
		//System.out.println(boy);

		double after1 = System.currentTimeMillis();

		System.out.println("StringBuffer Spend Time: " + (after1 - before1));

	}

}
//The MyStringBuffer wrote by myself is faster than StringBuffer?!
//MyStringBuffer Spend Time: 434.0
//StringBuffer Spend Time: 1412.0

