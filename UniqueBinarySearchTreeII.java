package Tree;

/*
 *   Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 Solution: use recursion
 Note: 
 1.The output ArrayList<TreeNode> is an arraylist of root nodes which are roots of unique BSTs
 2. we need to add for leaf nodes
 */
import java.util.*;

public class UniqueBinarySearchTreeII {
	public ArrayList<TreeNode> generateTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (n <= 0) {
			res.add(null);
			return res;
		}
		if (n == 1) {
			TreeNode root = new TreeNode(1);
			res.add(root);
			return res;
		}
		res = generateTreesRecur(1, n);
		return res;

	}

	public ArrayList<TreeNode> generateTreesRecur(int low, int high) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (low > high) {
			result.add(null);
			return result;
		}
		for (int r = low; r <= high; r++) {
			ArrayList<TreeNode> leftTree = generateTreesRecur(low, r - 1);
			ArrayList<TreeNode> rightTree = generateTreesRecur(r + 1, high);
			for (int i = 0; i < leftTree.size(); i++) {
				for (int j = 0; j < rightTree.size(); j++) {
					TreeNode root = new TreeNode(r);
					root.left = leftTree.get(i);
					root.right = rightTree.get(j);
					result.add(root);
				}
			}

		}
		return result;

	}

}
