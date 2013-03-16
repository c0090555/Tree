package Tree;

import java.util.*;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 Solve this problems with the help of two queues(LinkdList<TreeNode>)


 */
public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentLevel = new ArrayList<Integer>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();

		if (root == null) {
			return result;
		}
		current.add(root);
		while (current.size() != 0 || next.size() != 0) {
			currentLevel = new ArrayList<Integer>();
			while (current.size() != 0) {
				TreeNode n = current.remove();
				currentLevel.add(n.val);
				if (n.left != null) {
					next.add(n.left);
				}
				if (n.right != null) {
					next.add(n.right);
				}
			}
			result.add(currentLevel);
			current = next;// get the new current
			next = new LinkedList<TreeNode>();// clean up next
		}
		return result;

	}

}
