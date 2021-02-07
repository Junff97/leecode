package leecode;

public class lc124 {
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	    	this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	class Solution {
		int max = Integer.MIN_VALUE;
		public int maxPathSum(TreeNode root) {
			if (root == null) {
				return 0;
			}
			dfs(root);
			return max;
		}
		private int dfs(TreeNode root) {
			if (root == null) {
					return 0;
			}
			int left = Math.max(0, dfs(root.left));
			int right = Math.max(0, dfs(root.right));
			//Compare the max value of the current node with that of the previous node
			max = Math.max(max, root.val + left + right);
			//Determine a route with the maximum gain for the current root node and pass it to the previous root node
			return root.val + Math.max(left, right);
		}
	}
}
