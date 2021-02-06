package leecode;
import java.util.Stack;

public class lc125 {
	public static boolean isPalindrome(String s) {
		if (s == "") {
			return true;
		}
		Stack<Character> heap = new Stack<Character>();
		StringBuilder strBuilder = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c>='0' && c<='9') {
				strBuilder.append(c);
			}else if ((c>='A' && c<='Z') || (c>='a' && c<='z')) {
				strBuilder.append(Character.toLowerCase(c));
			}
		}
		for (int i = 0; i < strBuilder.length(); i++) {
			if (i<strBuilder.length()/2) {
				heap.add(strBuilder.charAt(i));
			}else if (i>strBuilder.length()/2) {
				if (heap.peek() == strBuilder.charAt(i)) {
					heap.pop();
				}
			}
		}return heap.isEmpty();
	}
	
	//Official Answers
	public static boolean isPalindrome2(String s) {
		StringBuffer sgood = new StringBuffer();
	    int length = s.length();
	    for (int i = 0; i < length; i++) {
	    	char ch = s.charAt(i);
	    	
	    	//The method isLetterOrDigit is more convenient to determine whether it is a letter or a number
	        if (Character.isLetterOrDigit(ch)) {
	        	sgood.append(Character.toLowerCase(ch));
	        }
	    }
	    //Use the reverse method to determine
	    StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
	    return sgood.toString().equals(sgood_rev.toString());
	}
	
	//Use a double pointer to determine the original string
	public static boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome3("anna"));
	}

}
