package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.test.utils.TreeNode;

/*
 * ���η�
 * 
 * ����һ������ n������������ 1 ... n Ϊ�ڵ�����ɵĶ�����������
 */
public class Mid_95_generateTrees {
	public static void main(String[] args) {
		int n = 3;
		List<TreeNode> result = generateTrees(n);
		System.out.println(result.size());
		for (TreeNode pNode : result) {
			pNode.PrintTree(pNode);
			System.out.println("-------------");
		}
	}
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        if (n == 0) {
			return result;
		}
        result = generateTreesCore(1, n);
        return result;
    }
    public static List<TreeNode> generateTreesCore(int start,int end){
    	List<TreeNode> result = new LinkedList<TreeNode>();
    	if (end < start) {
    		result.add(null);
			return result;
		}
    	for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTreesCore(start,i - 1);
			List<TreeNode> right = generateTreesCore(i + 1, end);
			
			for(TreeNode leftTree : left) {
				for(TreeNode rightTree : right) {
					TreeNode pCurr = new TreeNode(i);
					pCurr.left = leftTree;
					pCurr.right = rightTree;
					TreeNode pNode = pCurr;
					result.add(pNode);
				}
			}
			
		}
    	
    	return result;
    }
}
