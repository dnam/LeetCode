package maxPathBinTree;

public class Solution {
	public class TreeNode {
	     int val;
	    TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
    public int maxPathSum(TreeNode root) {
    	return maxPath(root).sumMax;
    }
    
    public class TreePath {
    	int sumMax; // maximum path under this tree
    	int sumUntil; // maximum path that ends here
    	
    	public TreePath(int sumMax, int sumUntil) {
    		this.sumMax = sumMax;
    		this.sumUntil = sumUntil;
    	}
    }
    
    public TreePath maxPath(TreeNode root) {
    	if (root == null)
    		return null;
    	
    	if (isLeaft(root))
    		return new TreePath(root.val, root.val);
    	
    	TreePath leftPath = maxPath(root.left);
    	TreePath rightPath = maxPath(root.right);
    	
    	if (leftPath == null || rightPath == null) {
    		TreePath curPath = (leftPath == null)? rightPath: leftPath; // either must be not null
    		int sumUntil = Math.max(root.val, curPath.sumUntil + root.val);
    		int sumThrough = sumUntil;
    		int sumMax = Math.max(sumThrough, curPath.sumMax);
    		return new TreePath(sumMax, sumUntil);
    	}
    	
    	int sumUntil = Math.max(root.val, Math.max(leftPath.sumUntil + root.val, rightPath.sumUntil + root.val));
    	int sumThrough = Math.max(sumUntil, leftPath.sumUntil + root.val + rightPath.sumUntil);
    	int sumMax = Math.max(sumThrough, Math.max(leftPath.sumMax, rightPath.sumMax));
    	
    	return new TreePath(sumMax, sumUntil);
    }
    
    public boolean isLeaft(TreeNode node) {
    	if (node == null) return false;
    	
    	return (node.left == null && node.right == null);
    }
}