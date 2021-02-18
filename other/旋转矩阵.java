public class 旋转矩阵 {
	 public static void rotate(int[][] matrix) {
		 int n = matrix.length;
		 if (n < 2) {
			 return;
	     } 
		 
		 //先按照主对角线翻转
		 for (int i = 0; i < n - 1; i++) {
			 for (int j = i + 1; j < n; j++) {
				int tmp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = tmp;
	            
			 }
		 }
		 
		 //再进行对称翻转
		 for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2 ; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = tmp;
			}
		}
	 }
	 public static void main(String[] args) {
		int [][] x = {{5, 1, 9, 11},
					  {2, 4, 8, 10},
					  {13, 3, 6, 7},
					  {15, 14, 12, 16}};
		int [][] y = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		rotate(y);
	}
}
