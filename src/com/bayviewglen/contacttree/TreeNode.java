package com.bayviewglen.contacttree;



public class TreeNode implements Comparable<Contact> {
	private Comparable data;
	private TreeNode left;
	private TreeNode right;
	
	
	public TreeNode() {
		data = null;
		left = null;
		right = null;
	}
	
	
	
	public TreeNode(Comparable data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(Comparable data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public Comparable getData() {
		return data;
	}
	public void setData(Contact data) {
		this.data = data;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public int compareTo(Contact b) {  // Compare to method
		if (this.data instanceof Contact) {
			return (((Contact)this.data).getLast() + ((Contact)this.data).getFirst()).compareTo(((Contact)b).getLast()+((Contact)b).getFirst());
		} else {
			return 0;
		}
	}

}

