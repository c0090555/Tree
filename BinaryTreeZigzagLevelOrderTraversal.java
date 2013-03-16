package Tree;

/*
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 Solution: modified version of level order traversal (two queues solution)
 */
import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currentLevel = new ArrayList<Integer>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		boolean left = true;
		if (root == null) {
			return result;
		}
		current.add(root);
		while (!current.isEmpty() || !next.isEmpty()) {
			currentLevel = new ArrayList<Integer>();
			while (!current.isEmpty()) {
				TreeNode n = current.remove();
				if (left) {
					currentLevel.add(n.val);
				} else {
					currentLevel.add(0, n.val);

				}
				if (n.left != null) {
					next.add(n.left);
				}
				if (n.right != null) {
					next.add(n.right);
				}
			}
			left = !left;
			result.add(currentLevel);
			current = next;
			next = new LinkedList<TreeNode>();

		}
		return result;

	}

	public static void main(String[] args) {
		boolean l = true;
		if (!l) {
			System.out.println("a");
		} else {
			System.out.println("b");
		}
	}

}