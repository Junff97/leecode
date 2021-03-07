package leecode;

public class lc35 {
	public static int searchInsert(int[] nums, int target) {
		int i = 0;
		if (target < nums[i]) {
			return 0;
		}
		while (i <= nums.length - 1) {
			if (target > nums[i] && i !=nums.length-1) {
				i++;
			}else if (target <= nums[i]) {
				return i;
			}else if (target > nums[i] && i ==nums.length-1) {
				return i+1;
			}
		}return -1;
    }
	
<<<<<<< HEAD
	//¶ş·Ö·¨(left <= right)
=======
	//äºŒåˆ†æ³•
>>>>>>> 2ee8ce2ace295fdff8b931a77ae9cf7aa0e28881
	public static int searchInsert2(int[] nums, int target) {
		int n = nums.length;
		int left = 0, right = n - 1;
		while(left <= right) {
			int mid = (right-left)/2 + left;
			if (nums[mid] > target) {
				right = mid - 1; 
			}else if (nums[mid] < target) {
				left = mid + 1;
			}else{
				return mid;
			}
		}
		return left;
	}
	
	//¶ş·Ö·¨(left < right)
	public static int searchInsert3(int[] nums, int target) {
		int n = nums.length;
		int left = 0, right = n;
		while(left < right) {
			int mid = (right-left)/2 + left;
			if (nums[mid] > target) {
				right = mid;
			}else if(nums[mid] < target) {
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return right;
	}
	
	
	public static void main(String[] args) {
		int[] res = {1,3,5,6};
		System.out.println(searchInsert2(res, 4));
	}
}
