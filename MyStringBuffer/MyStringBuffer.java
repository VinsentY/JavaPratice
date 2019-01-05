package six;

//实现一个自己的StringBuffer

public class MyStringBuffer implements IStringBuffer {

	private char[] arr = new char[0];

	private int length;

	private int capacity;

	public MyStringBuffer(String string) {
		if (string != null) {
			arr = string.toCharArray();
		}
		length = string.length();
		capacity = length * 2;

	}

	public MyStringBuffer() {

	}

	@Override
	public void insert(int pos, String str) {

		if (str.length() + arr.length > capacity) {

			capacity = (arr.length + str.length()) * 2;
			char[] newArr = new char[capacity];
			System.arraycopy(arr, 0, newArr, 0, length);
			arr = newArr;
		}

		char[] insert = str.toCharArray();

		// 先把已经存在的数据往后移

		System.arraycopy(arr, pos, arr, pos + insert.length, length - pos);
		// 把要插入的数据插入到指定位置
		System.arraycopy(insert, 0, arr, pos, insert.length);

		length = length + insert.length;

	}

	@Override
	public void append(String str) {
		insert(length, str);
	}
	
	@Override
	public void append(char c) {
		insert(length, String.valueOf(c));
	}

	@Override
	public void insert(int pos, char b) {
		insert(pos, String.valueOf(b));

	}

	@Override
	public void delete(int start) {
		delete(start, length);
	}

	@Override
	public void delete(int start, int end) {
		 //边界条件判断
        if(start<0)
            return;
         
        if(start>length)
            return;
         
        if(end<0)
            return;
         
        if(end>length)
            return;
         
        if(start>=end)
            return;
         
        System.arraycopy(arr, end, arr, start, length- end);
        length-=end-start;
	}

	@Override
	public void reverse() {
		  for (int i = 0; i < length/2; i++) {
	             
	            char temp = arr[i];
	            arr[i] = arr[length-i-1];
	            arr[length-i-1] = temp;
	        }
	}

	@Override
	public int length() {
		
		return length;
	}
	
	public String toString() {
		char[] realValue = new char[length];
		 
        System.arraycopy(arr, 0, realValue, 0, length);
         
        return new String(realValue);
	}
	
	@Override
	public int indexOf(char ch) {
		return indexOf(String.valueOf(ch));
	}
	
	@Override
	public int indexOf(String str) {
		
		boolean isFind = false;
		
		int index = 0;
		int max = length - str.length();
		
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < str.length(); j++) {
				if (str.charAt(j) != arr[i + j]) {
					break;
				} 
				
				if (j == str.length() -1 ) {
					isFind = true;
					index = i;
				}
			}
			if (isFind) {
				break;
			}
		}
		return index;
	}
		
}
