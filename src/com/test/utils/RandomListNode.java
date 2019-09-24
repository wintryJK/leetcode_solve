package com.test.utils;

public class RandomListNode {
	public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }
    
    public void BuildNode(RandomListNode next,RandomListNode random) {
    	this.next = next;
    	this.random = random;
    }
}
