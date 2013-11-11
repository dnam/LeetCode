package flattenBinaryTree;
import java.util.*;

public class Solution {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		// empty tree
		if (root == null)
			return;
		
		// stack for DFS
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		TreeNode linkedNode = null; // tracking the linkedList
		
		// traverse the tree in pre-order traversal
		while (!stack.isEmpty()) {
			TreeNode curNode = stack.pop();
			
			if (curNode.right != null)
				stack.push(curNode.right);
			if (curNode.left != null)
				stack.push(curNode.left);
			
			if (linkedNode == null)
				linkedNode = curNode;
			else {
				linkedNode.right = curNode;
				linkedNode = curNode;
			}
		}
	}
}