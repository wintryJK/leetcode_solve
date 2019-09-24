package com.test.utils;

public class ListNode {
	public int val;
	public ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public void ConnectListNodes(ListNode pNext) {
		
		this.next = pNext;
		
	}
	
	public void PrintList() {
		System.out.println("PrintList start");
		ListNode pNode = this;
		while (pNode != null) {
			System.out.print(pNode.val+"\t");
			pNode = pNode.next;			
		}
		System.out.println("\n"+"PrintList end");
	}
	
	
}
