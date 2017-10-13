package com.bayviewglen.trees;

public class TreeDriver {

	public static void main(String[] args) {
		BST x = new BST ();
		IntTreeNode y = new IntTreeNode();
		
		x.add(7);
		x.add(4);
		x.add(6);
		x.add(6);
		x.add(2);
		x.add(5);
		x.add(3);
		x.delete(4);
		
		System.out.println(x.getRoot().getLeft().getRight().getData());
		
		

	}

}
