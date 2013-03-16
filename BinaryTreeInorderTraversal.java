package Tree;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.*;

public class BinaryTreeInorderTraversal {
	public static ArrayList<Integer> travel = new ArrayList<Integer>();

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		travel = new ArrayList<Integer>();
		// inorderTraversalRecur(root);
		inorderTraversalIter(root);

		return travel;

	}

	public void inorderTraversalRecur(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversalRecur(root.left);
		travel.add(root.val);
		inorderTraversalRecur(root.right);

	}

	public void inorderTraversalIter(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode top;

		s.add(root);
		while (!s.isEmpty()) {
			top = s.peek();
			if (top != null) {
				s.push(top.left);
			} else {
				s.pop();// pop out null
				if (s.isEmpty()) {
					return;
				}
				TreeNode curr = s.peek();
				System.out.println(curr.val);
				travel.add(curr.val);
				s.pop();
				s.push(curr.right);

			}

		}

	}

	public static void main(String[] args) {
		BinaryTreeInorderTraversal o = new BinaryTreeInorderTraversal();
		TreeNode r = new TreeNode(1);
		r.left = new TreeNode(2);
		o.inorderTraversal(r);
		for (int i = 0; i < travel.size(); i++) {
			System.out.print(" " + travel.get(i));
		}
	}

}
