package com.bayviewglen.contacttree;



public class BinarySearchTree {
	TreeNode root;
	
	public BinarySearchTree() {
		super();
		this.root = null;
	}
	
	public void add(TreeNode current, Comparable<Contact> contact) { // Adds to the binary search tree
		if (current == null) {
			TreeNode temp = new TreeNode(contact);
			current = temp;

		} else if (contact.compareTo((Contact) current.getData()) < 0) {
			if (current.getLeft() == null) {
				TreeNode temp = new TreeNode(contact);
				current.setLeft(temp);
			} else {
				add(current.getLeft(), contact);
			}
		} else {
			if (current.getRight() == null) {
				TreeNode temp = new TreeNode(contact);
				current.setRight(temp);
			} else {
				add(current.getRight(), contact);
			}			
		}
	}
	
	public void add(Comparable<Contact> contact) {  //Adds a contact
		if (root == null) {
			TreeNode temp = new TreeNode(contact);
			root = temp;
		}else {
			add(root, contact);
		}
		
		
	}
	
	public void inorderTraversal(TreeNode current) {  // In order traversal through binary search tree
		if (current.getLeft()!=null)
			inorderTraversal(current.getLeft());
		evaluate(current);
		if (current.getRight()!=null)
			inorderTraversal(current.getRight());
	}
	
	public void rightnodeleftTraversal(TreeNode current) {  // Traversel through binary search tree from largest to smallest
		if (current.getRight()!=null)
			inorderTraversal(current.getRight());
		evaluate(current);
		if (current.getLeft()!=null)
			inorderTraversal(current.getLeft());
	}
	
    public void preorderTraversal(TreeNode current) {  // Pre order traversal
        	evaluate(current);
      	if (current.getLeft()!=null)
			preorderTraversal(current.getLeft());
		if (current.getRight()!=null)
			preorderTraversal(current.getRight());
		
	}
    
    public void postorderTraversal(TreeNode current) {  // Post order traversal
    	if (current.getLeft()!=null)
			postorderTraversal(current.getLeft());
		if (current.getRight()!=null)
			postorderTraversal(current.getRight());
		evaluate(current);
		
	}
    
    private void evaluate(TreeNode current) {  // Print out binary search tree
    	    System.out.println(current.getData());
    	
    }
    
    



	public BinarySearchTree(TreeNode root) {  
		super();
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	} 
	
	public TreeNode findSmallestBinarySearchTree (TreeNode root) {  // Find smallest node  
		if (root.getLeft() == null) {
			return root;
		}else {
			return findSmallestBinarySearchTree (root.getLeft());
		}
		
	}
	
	public TreeNode findLargestBinarySearchTree (TreeNode root) {  // Find largest node
		if (root.getRight() == null) {
			return root;
		}else {
			return findLargestBinarySearchTree (root.getRight());
		}
		
	}
	
	public String search(String firstName, String lastName)  //Search through binary search tree for contact
    {
        Contact key = new Contact (firstName, lastName);
        if ((root.getData()).compareTo(key) == 0) {
			return ((Contact) root.getData()).getPhone();
		} else {
			return search(root, key);
		}
    }
	
	private String search(TreeNode current, Comparable <Contact> contact)  //Search through binary search tree for contact
    {
		if (contact.compareTo((Contact) current.getData()) == 0) {
			return ((Contact) (current).getData()).getPhone();
		} else if (contact.compareTo((Contact) current.getData()) < 0) {
			if (current.getLeft() == null) {
				return "Contact doesn't exist.";
			} else {
				return search(current.getLeft(), contact);
			}
		} else {
			if (current.getRight() == null) {
				return "Contact doesn't exist.";
			} else {
				return search(current.getRight(), contact);
			}
		}
    }
	
	public boolean deleteBinarySearchTree (TreeNode current, Comparable<Contact> key) {  // Delete a contact from binary search tree
		if (root == null)
			return false;
		if (key.compareTo((Contact) root.getData()) < 0 )
			return deleteBinarySearchTree(root.getLeft(), key);
		else if (key.compareTo((Contact) root.getData()) > 0)
			return deleteBinarySearchTree(root.getRight(), key);
		else {
		}
		if (root.getLeft() == null) {
				root = root.getRight();
			return true;
		} else if(root.getRight() == null) {
			root = root.getLeft();
		return true;
		}else {
			TreeNode deleteNode = root;
			TreeNode largest = findLargestBinarySearchTree(root);
			deleteNode.setData((Contact) largest.getData());
			return deleteBinarySearchTree(deleteNode.getLeft(), largest.getData());
		}
	}
	
	public void delete(String f, String l)   // Delete a contact from binary search tree
    {
		Contact key = new Contact(f, l);
        if (root == null)
            System.out.println("Tree Empty");
        else if(search(f, l).equals("Contact doesn't exist.")) {
        	System.out.println("Contact doesn't exist within this address book. \n");
        }
        
        else
        {
            root = delete(root, key);
            System.out.println(key.getFirst() + " " + key.getLast() + " deleted from the tree \n");
        }
    }
	
	private TreeNode delete(TreeNode root, Comparable<Contact> k)   // Delete a contact from binary search tree
    {
        TreeNode p, p2, n;
        if (root.getData().compareTo(k) == 0)
        {
            TreeNode lt, rt;
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
        if (k.compareTo((Contact)root.getData()) < 0)
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
