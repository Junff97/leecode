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
	 * �����ַ���
	 * 
	 * ���жϵ�һ�к͵�һ����û��0����������boolean����ʾ���������޸ģ�֮���[1][1]��ʼ��������0����[0][i]��[j][0]�޸�Ϊ0��
	 * ��󽫵�һ�е�һ����0��ȫ���޸�Ϊ0��ͨ������boolean���ж��ǲ���Ҫ����һ�е�һ�и�Ϊ0
	 */

	public static void main(String[] args) {
		int [][] x = {{5, 1, 9, 11},
				      {2, 4, 0, 10},
				      {13, 3, 6, 7},
				      {15, 14, 0, 16}};
		setZeroes(x);
	}
}
