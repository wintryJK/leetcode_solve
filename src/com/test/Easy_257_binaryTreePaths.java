package com.test;

import java.util.ArrayList;
import java.util.List;

import com.test.utils.TreeNode;

/*
 * 给定�?个二叉树，返回所有从根节点到叶子节点的路径�??
 */
public class Easy_257_binaryTreePaths {
	public static void main(String[] args) {
		
	}
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
    	if (root == null) {
			return paths;
		}
    	List<Integer> values = new ArrayList<Integer>();
    	backtracking(root,values,paths);
    	return paths;
    }
	private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
		if (node == null) {
			return;
		}
		values.add(node.val);
		if (isLeaf(node)) {
			paths.add(buildPath(values));
		}else {
			backtracking(node.left, values, paths);
			backtracking(node.right, values, paths);
		}
		values.remove(values.size() - 1);
	}
	private boolean isLeaf(TreeNode node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
	private String buildPath(List<Integer> values) {
		String path = String.valueOf(values.get(0));
		for(int i = 1; i < values.size(); i++) {
			path += "->" + values.get(i);
		}
		return path;
	}
}
