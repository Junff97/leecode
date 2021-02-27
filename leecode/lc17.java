package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class lc17 {
	
	/*
	 *第一种方法回溯思想，DFS
	*/
	@SuppressWarnings("serial") 
	public static Map<Character, String[]> map = new HashMap<Character, String[]>(){{
		put('2', new String[]{"a", "b", "c"});
        	put('3', new String[]{"d", "e", "f"});
        	put('4', new String[]{"g", "h", "i"});
        	put('5', new String[]{"j", "k", "l"});
        	put('6', new String[]{"m", "n", "o"});
        	put('7', new String[]{"p", "q", "r", "s"});
        	put('8', new String[]{"t", "u", "v"});
        	put('9', new String[]{"w", "x", "y", "z"});
	}};
	public static List<String> letterCombinations(String digits) {
		//创建一个返回最后结果的列表
		List<String> ans = new ArrayList<String>();
		
		//创建一个可以修改的StringBuilder，来储存每一次搜索的值
		StringBuilder res = new StringBuilder();
		
		if("".equals(digits)) return ans;
		search(digits, 0, res, ans);
		return ans;
	}
	
	public static void search(String digits, int index, StringBuilder res, List<String> ans) {
		//返回结果是遍历完digits最后字符的数组，返回
		if (index == digits.length()) {
			ans.add(res.toString());
			return;
		}
		char key = digits.charAt(index);
		int length = map.get(key).length;
		for (int i = 0; i < length; i++) {
			res.append(map.get(key)[i]);
			search(digits, index + 1, res, ans);
			System.out.println(res.toString());
			
			//每一次search并且成功记录到ans里之后要删除StringBilder前一位
			res.deleteCharAt(res.length()-1);
		}
	}
	
	/**
	 * 第二种方法 BFS
	 * 利用链表特性，比如123，传入先将'1'数组加入链表，得到c,b,a,再删除表头的a，遍历'2'数组得到'ad,ae,af',并加入链表，同理
	 */
	public static List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
	
	//利用链表的BFS
	public static List<String> letterCombinations3(String digits) {
		List<String> ans = new ArrayList<String>();
				
		LinkedList<String> queue = new LinkedList<String>();
		queue.add("");
		if("".equals(digits)) return ans;
		search2(digits, 0, queue, ans);
		return ans;		
	}
	
	public static void search2(String digits, int index, LinkedList<String> queue, List<String> ans) {
		if (index == digits.length()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {ans.add(queue.remove());}
			return;
		}
		char x = digits.charAt(index);
		String[] x_list = map.get(x);
		while (queue.peek().length() <= index || queue.isEmpty()) {
			String x2 = queue.remove();
			for (int j = 0; j < x_list.length; j++) {
				queue.add(x2 + x_list[j]);
			}
		}
		search2(digits, index + 1, queue, ans);
	}
	
	
	public static void main(String[] args) {
		String x = "293";
		System.out.println(letterCombinations2(x));
	}

}
