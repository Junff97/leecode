package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc387 {
	
	//使用哈希表存储频数
	public static int firstUniqChar(String s) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (freq.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	//使用哈希表存储索引
	public static int firstUniqChar2(String s) {
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (freq.containsKey(c)) {
				freq.put(c, -1);
			}else {
				freq.put(c, i);
			}
		}
		
		int minmal = s.length();
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			int pos = entry.getValue();
			if (pos != -1 || pos < minmal) {
				minmal = pos;
			}
		}
		if (minmal == s.length()) {
			return -1;
		}else {
			return minmal;
		}
	}
	
	//使用数组更快，因为使用哈希表需要计算hashcode，扩容hash碰撞问题导致影响效率。
	public static int firstUniqChar3(String s) {
		int[] arr = new int[26];
	    	int n = s.length();
	    	for (int i = 0; i < n; i++) {
	    		arr[s.charAt(i)-'a']++;
	    	}
	    	for (int i = 0; i < n; i++) {
	        	if (arr[s.charAt(i)-'a'] == 1) {
	            		return i;
	        	}
	    	}
	    	return -1;
	}
	
	
	//复杂度很高不推荐
	public int firstUniqChar4(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }
	
	
	public static int firstUniqChar5(String s) {
	        int[] letter = new int[26];
	        Arrays.fill(letter, -1);
	        int len = s.length();
	        //遍历字符串
	        for (int i = 0; i < len; i++) {
	            char ch = s.charAt(i);
	            if (letter[ch - 'a'] == -2) {
	                continue;
	            } else if(letter[ch - 'a'] != -1) {
	                letter[ch - 'a'] = -2;
	            } else {
			//这里记录的是出现一次的字母的index
	                letter[ch - 'a'] = i;
	            }
	        }
	
	        //取letter数组中最小的下标（负数除外）
	        int firstIdx = Integer.MAX_VALUE;
	        for (int i = 0; i < 26; i++) {
	            if (letter[i] < 0) {
	                continue;
	            }
	            firstIdx = Math.min(firstIdx, letter[i]);
	        }
	        //没有符合条件的下标则返回-1，表明该字符串中没有只出现一次的字母
	        return firstIdx < 0 || firstIdx == Integer.MAX_VALUE ? -1 : firstIdx;
	    }

	public static void main(String[] args) {
		String s = "ccardb";
		System.out.println(firstUniqChar5(s));
	}
}
