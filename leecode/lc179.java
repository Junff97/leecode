package leecode;


import java.util.Arrays;
import java.util.Comparator;

public class lc179 {
	public String largestNumber(int[] nums) {
		String[] asStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
		Arrays.sort(asStrs,new MyComparator());
		if (asStrs[0].equals("0")) {
            return "0";
        }
		String largestNumberStr = new String();
	    for (String numAsStr : asStrs) {
	    	largestNumberStr += numAsStr;
	    }
	    return largestNumberStr;
	}
	
	//×Ô¶¨ÒåÅÅÐò
	class MyComparator implements Comparator<String>{
		@Override
		public int compare(String s1, String s2) {
			return (s2+s1).compareTo(s1+s2);
		}
	}
	
	
	public static void main(String[] args) {
		lc179 x = new lc179();
		int[] a = {3,30,34,5,9};
		System.out.println(x.largestNumber(a));
	}
}

