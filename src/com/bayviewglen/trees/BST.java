package com.bayviewglen.trees;

public class BST {
	IntTreeNode root;
	
	public BST() {
		super();
		this.root = null;
	}
	
	public void add(IntTreeNode current, int x) {
		IntTreeNode temp = new IntTreeNode(x);
		
		if (root == null) {
			root = temp;
		}else if (current.getData() > x) {
			add(current.getLeft(), x);
		}else if (current.getData() >= x) {
			add(current.getRight(), x);
		}
	}
	
	public void add(int x) {
		if (root == null) {
			IntTreeNode temp = new IntTreeNode(x);
			root = temp;
		}else {
		add(root,x);
		}
		
		
	}
	
	public void inorderTraversal(IntTreeNode current) {
		if (current.getLeft()!=null)
			inorderTraversal(current.getLeft());
		evaluate(current);
		if (current.getRight()!=null)
			inorderTraversal(current.getRight());
	}
	
    public void preorderTraversal(IntTreeNode current) {
      	if (current.getLeft()!=null)
			inorderTraversal(current.getLeft());
		evaluate(current);
		if (current.getRight()!=null)
			inorderTraversal(current.getRight());
		
	}
    
    public void postorderTraversal(IntTreeNode current) {
    	if (current.getLeft()!=null)
			inorderTraversal(current.getLeft());
		evaluate(current);
		if (current.getRight()!=null)
			inorderTraversal(current.getRight());
		
	}
    
    private void evaluate(IntTreeNode current) {
    	    System.out.println(current.getData());
    	
    }



	public BST(IntTreeNode root) {
		super();
		this.root = root;
	}

	public IntTreeNode getRoot() {
		return root;
	}

	public void setRoot(IntTreeNode root) {
		this.root = root;
	} 
	
	

}
