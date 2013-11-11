package maxPathBinTree;

import java.util.*;

public class AllPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return lst;
		
		// leaf node
		if (root.left == null && root.right == null) {
			if (root.val != sum)
				return lst;
			
			ArrayList<Integer> curLst = new ArrayList<Integer>();
			curLst.add(root.val);
			lst.add(curLst);
			return lst;
		}
		
		ArrayList<ArrayList<Integer>> leftLst = pathSum(root.left, sum - root.val);
		ArrayList<ArrayList<Integer>> rightLst = pathSum(root.right, sum - root.val);
		
		for (ArrayList<Integer> curLst: leftLst) {
			ArrayList<Integer> newLst = new ArrayList<Integer>();
			newLst.add(root.val);
			newLst.addAll(curLst);
			lst.add(newLst);
		}
		
		for (ArrayList<Integer> curLst: rightLst) {
			ArrayList<Integer> newLst = new ArrayList<Integer>();
			newLst.add(root.val);
			newLst.addAll(curLst);
			lst.add(newLst);
		}
		return lst;
	}
}
