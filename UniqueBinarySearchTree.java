package Tree;

/*
 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 Solution: 1.recursion 2.dp
 Note: we have to pick a node as root
 */
public class UniqueBinarySearchTree {
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 0) {
			return 0;
		}
		if (n <= 1) {
			return 1;
		}
		return numTreesRecur(n);
		// return numTreesDP(n);.
	}

	// recursive solution
	public int numTreesRecur(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i <= n - 1; i++) {// i indicates the number of left
											// subtree nodes
			result += numTreesRecur(i) * numTreesRecur(n - 1 - i);
		}
		return result;
	}

	// dp solution
	public int numTreesDP(int n) {
		if (n < 0) {
			return 0;
		}
		if (n <= 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {// j indicates the number of left
												// subtree nodes
				dp[i] += dp[j] * dp[i - 1 - j];
			}
		}
		return dp[n];
	}
}
