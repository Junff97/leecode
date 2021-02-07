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
	
	public static void main(String[] args) {
		int[] res = {1,3,5,6};
		System.out.println(searchInsert(res, 3));
	}
}
