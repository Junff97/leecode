package leecode;

import java.util.Arrays;
public class lc43 {
	public static String multiply(String num1, String num2) {
		if ((num1.length()==1&&num1.equals("0"))||(num2.length()==1&&num2.equals("0")))return "0";
		StringBuilder res = new StringBuilder();
		
		//作为储存结果的数组
		int[] ans = new int[num1.length() + num2.length()];
		//作为贮存进位的数组
		int[] carryBit = new int[num1.length() + num2.length()];
		
		Arrays.fill(ans, 0);
		Arrays.fill(carryBit, 0);
		
		/*
		 * 将两个数组转化成int类型数组方便计算。
		 */
		int[] num1List = new int[num1.length()];
		int[] num2List = new int[num2.length()];
		for (int i = 0; i < num1.toCharArray().length; i++) {
			num1List[i] = num1.toCharArray()[i] - '0';
		} 
		for (int i = 0; i < num2.toCharArray().length; i++) {
			num2List[i] = num2.toCharArray()[i] - '0';
		}

		for (int i = num1List.length; i > 0; i--) {
			for (int j = num2List.length; j > 0; j--) {
				int new_value = (ans[i + j -1] + num1List[i-1] * num2List[j-1] + carryBit[i + j -1])%10;
				int new_carrybit = (ans[i + j -1] + num1List[i-1] * num2List[j-1] + carryBit[i + j -1]);
				ans[i + j -1] = new_value;
				if (new_carrybit >= 10) {
					//如果计算到最后一位直接将进位加入结果数组，不储存在进位数组
					if(j != 1) {
						carryBit[i + j - 2] = new_carrybit/10;
					}else {
						ans[i + j - 2] = new_carrybit/10;
					}
				}
			}
			Arrays.fill(carryBit, 0);
		}
		int index = -1;
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] != 0) {
				index = i;
				break;
			}
		}
		for (int i = index; i < ans.length; i++) {
			res.append(ans[i]);
		}
		return res.toString();
    }
	
	
	//更好的方法将进位直接加入到前一位
	public static String multiply2(String num1, String num2) {
		if ((num1.length()==1&&num1.equals("0"))||(num2.length()==1&&num2.equals("0")))return "0";
		int[] ans = new int[num1.length() + num2.length()];
	
		
		for (int i = num1.length()-1; i >= 0; i--) {
			int i1 = num1.charAt(i) - '0';
			for (int j = num2.length()-1; j >= 0; j--) {
				int j1 = num2.charAt(j) - '0';
				int sum = (i1 * j1 + ans[i + j + 1]);
				ans[i + j + 1] = sum % 10;
				ans[i + j] += sum/10;
			}
		}
		StringBuilder result = new StringBuilder();
        	for (int i = 0; i < ans.length; i++) {
            		if (i == 0 && ans[i] == 0) continue;
           			result.append(ans[i]);
       			}
        		return result.toString();
		}
	}
}
