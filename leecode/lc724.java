
/*
 *input: nums = [1, 7, 3, 6, 5, 6]
 *output:3
 *explain:
 *central index of the array 3
 *Left side: 1 + 7 + 3 = 11
 *Right side: 5 + 6 = 11
 */
public class lc724 {
	public static int pivotIndex(int[] nums) {
		int left = 0;
        	int right = 0;
        	int sum = 0;
        
       	 	for (int i : nums) {
			sum += i;
		}

        	for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				left = 0;
			}else {
				left += nums[i-1];
			}
			right = sum - left - nums[i];
			if (left == right) {
				return i;
			}
        	}
		/**More easier way
        	* for (int i = 0; i < nums.length; i++) {
		* 	if (left * 2 + nums[i] == sum) {
		*		return i;
		* 	}
		*	left += nums[i];
		*}
		**/
        return -1;
	} 
}
	
