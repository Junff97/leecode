
/*
 *input: nums = [1, 7, 3, 6, 5, 6]
 *output:3
 *explain:
 *central index of the array 3
 *Left side: 1 + 7 + 3 = 11
 *Right side: 5 + 6 = 11
 */
public class 寻找数组的中心索引 {
	public static int pivotIndex(int[] nums) {
        int startPoint = 0;
        int endPoint = nums.length - 1;
        int value = nums[startPoint] - nums[endPoint];

        while(endPoint - startPoint > 2){
            if(value >= 0){
                endPoint -- ;
                value -= nums[endPoint];
            }else{
                startPoint ++;
                value += nums[startPoint];
            }
        }
        return (value == 0)? startPoint + 1: -1;
	}
	public static void main(String[] args) {
		int [] x = {1,2, 7, 2, 1};
		System.out.println(pivotIndex(x));
	}
	
	
}
