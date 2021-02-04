package leecode;
import java.util.Stack;

public class lc20 {	
	//Methods of using the stack
	public static boolean isValid(String s) {
    		Stack<Character> heap = new Stack<>();
    		char[] c = s.toCharArray();
    		for (char ch : c) {
			
			//Press the retrieved symbols that need to appear afterwards into the stack.
			if (ch == '(') {heap.add(')');}
			else if (ch =='[') {heap.add(']');}
			else if (ch == '{') {heap.add('}');}
			
			//If the corresponding symbols retrieved are not in the order of pop out of the stack, an error is reported
			else if (heap.isEmpty() || ch != heap.pop()) {return false;}
		}
		return heap.isEmpty();
	}
	
	//Methods of string replacement
	public static boolean isValid2(String s) {
		int length = s.length() / 2;
		for (int i = 0; i < length; i++) {
			s = s.replace("()", "").replace("{}", "").replace("[]", "");
		}
		return s.length() == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("(]"));
		String s = "{()}()";
		System.out.println(isValid2(s));
	}
}
