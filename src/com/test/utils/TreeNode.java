package com.test.utils;

public class TreeNode {
	public int val = 0;
	public TreeNode left = null;
	public TreeNode right = null;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public void ConnectTreeNode(TreeNode left,TreeNode right) {
		this.left = left;
		this.right = right;
	}
	
	public static void PrintTreeNodes(TreeNode pNode) {
		if (pNode!=null) {
			System.out.println("value:"+pNode.val);
			if(pNode.left!=null) {
				System.out.println("left: "+pNode.left.val);
			}else {
				System.out.println("left null");
			}
			
			if (pNode.right!=null) {
				System.out.println("right: "+pNode.right.val);
			} else {
				System.out.println("right null");
			}
		}else {
			System.out.println("null");
		}
	}
	
	public void PrintTree(TreeNode pRoot) {
		PrintTreeNodes(pRoot);
		if(pRoot != null)
	    {
	        if(pRoot.left != null)
	            PrintTree(pRoot.left);

	        if(pRoot.right != null)
	            PrintTree(pRoot.right);
	    }
	}

}
