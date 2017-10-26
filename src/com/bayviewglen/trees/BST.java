package com.bayviewglen.trees;

public class BST {
	IntTreeNode root;
	
	public BST() {
		super();
		this.root = null;
	}
	
	public void add(IntTreeNode current, int x) {
		if (current == null) {
			IntTreeNode temp = new IntTreeNode(x);
			current = temp;

		} else if (current.getData() > x) {
			if (current.getLeft() == null) {
				IntTreeNode temp = new IntTreeNode(x);
				current.setLeft(temp);
			} else {
				add(current.getLeft(), x);
			}
		} else {
			if (current.getRight() == null) {
				IntTreeNode temp = new IntTreeNode(x);
				current.setRight(temp);
			} else {
				add(current.getRight(), x);
			}			
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
	
	public void rightnodeleftTraversal(IntTreeNode current) {
		if (current.getRight()!=null)
			inorderTraversal(current.getRight());
		evaluate(current);
		if (current.getLeft()!=null)
			inorderTraversal(current.getLeft());
	}
	
    public void preorderTraversal(IntTreeNode current) {
        	evaluate(current);
      	if (current.getLeft()!=null)
			preorderTraversal(current.getLeft());
		if (current.getRight()!=null)
			preorderTraversal(current.getRight());
		
	}
    
    public void postorderTraversal(IntTreeNode current) {
    	if (current.getLeft()!=null)
			postorderTraversal(current.getLeft());
		if (current.getRight()!=null)
			postorderTraversal(current.getRight());
		evaluate(current);
		
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
	
	public IntTreeNode findSmallestBST (IntTreeNode root) {
		if (root.getLeft() == null) {
			return root;
		}else {
			return findSmallestBST (root.getLeft());
		}
		
	}
	
	public IntTreeNode findLargestBST (IntTreeNode root) {
		if (root.getRight() == null) {
			return root;
		}else {
			return findLargestBST (root.getRight());
		}
		
	}
	
	public boolean search(int val)
    {
        return search(root, val);
    }
	
	private boolean search(IntTreeNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
	
	public boolean deleteBST (IntTreeNode root, int key) {
		if (root == null)
			return false;
		if (key < root.getData())
			return deleteBST(root.getLeft(), key);
		else if (key > root.getData())
			return deleteBST(root.getRight(), key);
		else {
		}
		if (root.getLeft() == null) {
				root = root.getRight();
			return true;
		} else if(root.getRight() == null) {
			root = root.getLeft();
		return true;
		}else {
			IntTreeNode deleteNode = root;
			IntTreeNode largest = findLargestBST(root);
			deleteNode.setData(largest.getData());
			return deleteBST(deleteNode.getLeft(), largest.getData());
		}
	}
	
	public void delete(int k)
    {
        if (root == null)
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry "+ k +" is not present");
        else
        {
            root = delete(root, k);
            System.out.println(k+ " deleted from the tree");
        }
    }
	
	private IntTreeNode delete(IntTreeNode root, int k)
    {
        IntTreeNode p, p2, n;
        if (root.getData() == k)
        {
            IntTreeNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }
	
	
	

}
