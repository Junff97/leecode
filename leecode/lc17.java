package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lc17 {
	
	//双括号初始化Hashmap来储存数字对引得字母
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

	public static void main(String[] args) {
		String x = "293";
		System.out.println(letterCombinations2(x));
	}

}
