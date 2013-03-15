/*
 * MorrisInorderTraverse is a kind of in-order traverse which doesn't use stack or recursion
 * Although the tree is modified through the traversal, it is reverted back to its original shape after the completion.  
 * No extra space is required for the traversal.
 * 
Time Complexity: Its o(n) but each node is visited at least 2 times.
Space Complexity: No extra space required .
Algorithm:
The key idea here is to point the rightmost node of the subtree to the parent node of that subtree, so that you can move back to the parent node of that subtree once all its nodes are printed.
 */

public class MorrisInorderTraverse {
	public void morrisInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.val + " ");
				current = current.right;// go to the right subtree
			} else {
				TreeNode prev = current.left;
				while (prev.right != null && prev.right != current) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = current;// let rightmost node of its left
											// subtree right points to current
											// node
					current = current.left;// go to its left subtree
				} else {
					System.out.print(current.val + " ");
					prev.right = null;// revert back to original tree
					current = current.right;
				}

			}
		}

	}

	public static void main(String[] args) {
		MorrisInorderTraverse o = new MorrisInorderTraverse();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		o.morrisInorder(root);
		System.out.println(root.left.left.right);
	}

}
