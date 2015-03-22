package com.test;

public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sumR(root, 0);
	}
	public int sumR(TreeNode root, int x) {
		if (root.right == null && root.left == null)
			return 10 * x + root.val;
		int val = 0;
		if (root.left != null)
			val += sumR(root.left, 10 * x + root.val);
		if (root.right != null)
			val += sumR(root.right, 10 * x + root.val);
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
