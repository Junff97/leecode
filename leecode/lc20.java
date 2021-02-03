package leecode;

import java.util.Stack;

public class lc20 {
	public static boolean isValid(String s) {
    	Stack<Character> heap = new Stack<>();
    	char[] c = s.toCharArray();
    	for (char ch : c) {
			if (ch == '(') {heap.add(')');}
			else if (ch =='[') {heap.add(']');}
			else if (ch == '{') {heap.add('}');}
			else if (heap.isEmpty() || ch != heap.pop()) {return false;}
		}
    	return heap.isEmpty();
	}
	
	public static void main(String[] args) {
		//System.out.println(isValid("(]"));
		String s = "{()}()";
		System.out.println(isValid2(s));
	}
	
	
	//第二种方法比较简单
	 public static boolean isValid2(String s) {
	        int length = s.length() / 2;
			for (int i = 0; i < length; i++) {
				s = s.replace("()", "").replace("{}", "").replace("[]", "");
			}

			return s.length() == 0;
	    }
}
