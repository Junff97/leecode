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
	
	//¶þ·Ö·¨
	public static int searchInsert2(int[] nums, int target) {
		int n = nums.length;
		int left = 0, right = n - 1, ans = n;
		while(left <= right) {
			int mid = (right-left)/2 + left;
			if (nums[mid] >= target) {
				right = mid - 1;
				ans = mid; 
			}else {
				left = mid + 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] res = {1,3,5,9,12};
		System.out.println(searchInsert2(res, 6));
	}
}
