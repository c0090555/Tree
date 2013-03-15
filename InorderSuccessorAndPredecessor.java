class TreeNodeWithParent {
	public int val;
	public TreeNodeWithParent left = null;
	public TreeNodeWithParent right = null;
	public TreeNodeWithParent parent = null;

	public TreeNodeWithParent(int v) {
		val = v;
		parent = null;
		right = null;
		left = null;
	}
}

/*
 * To find the node n's in-order successor, check whether n has right child
 * first, if it has, then return the leftmost node of its right subtree,
 * otherwise go up until we find a parent node which makes n is in its left
 * side, then return this parent node
 * 
 * To find the node n's in-order predecessor, check whether n has left child
 * first, if it has, then return the rightmost node of its left subtree,
 * otherwise go up until we find a parent node which makes n is in its right
 * side, then return this parent node
 */

public class InorderSuccessorAndPredecessor {
	public TreeNodeWithParent inorderSuccessor(TreeNodeWithParent n) {
		if (n == null) {
			return null;
		}
		if (n.right != null) {// if n has right child, return the leftmost node
								// of its right subtree
			return leftMostChild(n.right);
		} else {
			// go up until find the parent node that makes n is on its left side
			TreeNodeWithParent e;
			e = n.parent;
			while (e != null) {
				if (e.left == n) {
					break;
				}
				n = e;
				e = n.parent;
			}
			return e;
		}

	}

	public TreeNodeWithParent leftMostChild(TreeNodeWithParent p) {
		if (p == null) {
			return null;
		}
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}

	public TreeNodeWithParent inorderPredecessor(TreeNodeWithParent n) {
		if (n == null) {
			return null;
		}
		if (n.left != null) {// if n has left child, return the rightmost child
								// of its left subtree
			return rightMostChild(n.left);
		} else {// go up until we find the parent node which makes n is in its
				// right side
			TreeNodeWithParent e = n.parent;
			while (e != null) {
				if (e.right == n) {
					break;
				}
				n = e;
				e = e.parent;
			}
			return e;
		}

	}

	public TreeNodeWithParent rightMostChild(TreeNodeWithParent p) {
		if (p == null) {
			return null;
		}
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}

	public static void main(String[] args) {
		InorderSuccessorAndPredecessor o = new InorderSuccessorAndPredecessor();
		TreeNodeWithParent one = new TreeNodeWithParent(1);
		TreeNodeWithParent two = new TreeNodeWithParent(2);
		TreeNodeWithParent three = new TreeNodeWithParent(3);
		TreeNodeWithParent four = new TreeNodeWithParent(4);
		TreeNodeWithParent five = new TreeNodeWithParent(5);
		one.left = two;
		two.parent = one;
		one.right = three;
		three.parent = one;
		two.left = four;
		four.parent = two;
		two.right = five;
		five.parent = two;
		System.out.println(o.inorderSuccessor(three));
		System.out.println(o.inorderPredecessor(four));

	}
}
