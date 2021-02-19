package leecode;
import java.util.HashSet;
import java.util.Set;

public class lc73 {
	/**
	 * input:
  	 *	[1,1,1],
  	 *	[1,0,1],
  	 *  [1,1,1]
	 * 
	 * output:
	 *  [1,0,1],
	 *  [0,0,0],
	 *  [1,0,1]
	 */
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> column = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row.contains(i) || column.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
    }
	
	/**
	 *Methods2
	 * 
	 *Iterating through the original matrix, if we find that if some element cell[i][j] is 0,
	 *we set all non-zero elements in row i and column j to large negative virtual values (say -1000000). 
	 *Note that the correct dummy value depends on the constraints of the problem, 
	 *and any number outside the allowed range of values can be used as a dummy.
	 */
	
	/**
	 * 第三种方法
	 * 
	 * 先判断第一列和第一行有没有0，定义两个boolean来表示，但不做修改，之后从[1][1]开始搜索，有0就向[0][i]和[j][0]修改为0，
	 * 最后将第一行第一列有0的全部修改为0，通过两个boolean来判断是不是要将第一行第一列改为0
	 */

	public static void main(String[] args) {
		int [][] x = {{5, 1, 9, 11},
				      {2, 4, 0, 10},
				      {13, 3, 6, 7},
				      {15, 14, 0, 16}};
		setZeroes(x);
	}
}
