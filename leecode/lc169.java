package leecode;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

//https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
public class lc169 {
	
	class Solution1 {
		//Use the usual idea - Hashmap
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (!myMap.containsKey(nums[i])) {
					myMap.put(nums[i], 1);
				}else {
					int newNum = myMap.get(nums[i]) + 1;
					myMap.replace(nums[i], newNum);
				}
			}
		
			Map.Entry<Integer, Integer> temp = null;
			for (Map.Entry<Integer, Integer> i : myMap.entrySet()) {
				if (temp == null || i.getValue() > temp.getValue()) {
					temp = i;
				}
			}
			return temp.getKey();
		}
	
		//Another way of writing using Hashmap
		public int majorityElement1(int[] nums) {
			Map<Integer, Integer> myMap = new HashMap<>();
			for (int i : nums) {
				myMap.put(i, myMap.getOrDefault(i, 1));
				if (myMap.get(i) > nums.length / 2) {
					return i;
				}
			}
			return -1;
		}
	}
	
	
	//Map.merge
	class Solution2 {
	    public int majorityElement(int[] nums) {
	        int limit = nums.length >> 1;
	        HashMap<Integer, Integer> map = new HashMap<>(limit);
	        for (int num : nums)
	            map.merge(num, 1, (pre, one) -> pre + one);
	        for (Map.Entry<Integer, Integer> entry : map.entrySet())
	            if (entry.getValue() > limit)
	                return entry.getKey();
	        return -1;
	    }
	}
	
	//Heap sort
	class Solution3 {
		public int majorityElement(int[] nums) {
			if (nums.length == 0) {
				return -1;
			}
			Map<Integer, Integer> myMap = new HashMap<>();
			PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> myMap.get(o2) - myMap.get(o1));
			for (int i: nums) {
				myMap.put(i, myMap.getOrDefault(i, 0) + 1);
			}
			heap.addAll(myMap.keySet());
			return heap.poll();
		}
	}
	
	//Moore's voting method
	class Solution4 {
		public int majorityElement(int[] nums) {
	        if (nums == null) {
	            return 0;
	        }
	        int count = 0;
	        int pre = 0;
	        for (int num : nums) {
	            if (count == 0) {
	                count++;
	                pre = num;
	            } else if (count > 0) {
	                if (num == pre) {
	                    count++;
	                } else {
	                    count--;
	                }
	            }
	        }
	        return pre;
	    }
	}
	
	//Moore's voting method2 using stack
	class Solution5 {
	    public int majorityElement(int[] nums) {
	        Stack<Integer> stack = new Stack<>();
	        for(int i:nums){
	            if(stack.isEmpty()||stack.peek()==i)
	                stack.push(i);
	            else
	                stack.pop();
	        }
	        return stack.peek();
	    }
	}
}
