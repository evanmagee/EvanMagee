

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;





public class LCA<Key extends Comparable<Key>, Value> 
{
  
	 private Node root;             // root of BST
	    private String stringOutput = "";
	    private String multiLineOutput = "";
	    private String prefix = "";
	    
    private class Node 
    {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left;
        private Node right;  	   // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) 
        {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
    
    public int size() 
    { 
    	return size(root); 
    }
    
    private int size(Node x) 
    {
        if (x == null) 
        	return 0;
        
        else 
        	return x.N;  
    }
    
    public void put(Key key, Value val) 
    {
        if (val == null) 
        { 
        	delete(key); 
        	return; 
        }
        root = put(root, key, val);
    }
    
    public void delete(Key key)
    { 
    	root = delete(root, key); 
    }
    
    private Node delete(Node x, Key key)
    {
    	if (x == null) 
    		return null;
    	
    	int compare = key.compareTo(x.key);
    	
    	if (compare < 0) x.left = delete(x.left, key);
    	
    	else if (compare > 0) x.right = delete(x.right, key);
    	
    	else
    	{
    		if (x.right == null) 
    			return x.left;
    		
    		if (x.left == null) 
    			return x.right;
    		
    		Node t = x;
    		x = max(t.left); 
    		x.left = deleteMax(t.left);
    		x.right = t.right;
    	}
    	
    	x.N = size(x.left) + size(x.right) + 1;
    	return x;
    }

    private Node put(Node x, Key keyToPlaceValIn, Value newValue) 
    {
        if (x == null) 
        	return new Node(keyToPlaceValIn, newValue, 1);
        
        int cmp = keyToPlaceValIn.compareTo(x.key);
        
        if (cmp < 0) 
        	x.left  = put(x.left,  keyToPlaceValIn, newValue);
        
        else if (cmp > 0) 
        	x.right = put(x.right, keyToPlaceValIn, newValue);
        
        else             
        	x.val   = newValue;
        
        x.N = 1 + size(x.left) + size(x.right);
        
        return x;
    }
    
    private Node deleteMax(Node x)
    {
    	if (x.right == null) 
    		return x.left;
    	
    	x.right = deleteMax(x.right);
    	
    	x.N = size(x.right) + size(x.left) + 1;
    	
    	return x;
    }
    
    private Node max(Node x)
    {
    	if (x.right == null) 
    		return x;
    	
    	return max(x.right);
    }
    
    public String printKeysInOrder()
    {
    	stringOutput = "";
    	
    	if (this.root == null) 
    		return "()";
    	
    	else
    		return "(" + printKeysInOrder(this.root) + ")";
    }
    
    private String printKeysInOrder(Node x)
    {
    	if (x == null) 
    		return "";
    	
    	stringOutput += "(";
    	printKeysInOrder(x.left);
    	stringOutput += ")";
    	
    	stringOutput += (x.key);
    	
    	stringOutput += "(";
    	printKeysInOrder(x.right);
    	stringOutput += ")";
    	
    	return stringOutput;
    }

    
    //I got this constructor from a project that I did last year.
    
    public Key lca(Node node, Key key1, Key key2) {
    	if (node == null)

            return null;

		if (node.key == key1) {

			return node.key;

		}

		if (node.key == key2) {

			return node.key;

		}

		int cmp = node.key.compareTo(key1);

		int cmp1 = node.key.compareTo(key2);

		

        if (cmp >= 0 && cmp1 >= 0)

            return lca(node.left, key1, key2);

  

        if (cmp <= 0 && cmp1 <= 0)

            return lca(node.right, key1, key2);

  

        return node.key;

    }
    // I used www.geeksforgeeks.org to help me with this code
    
    
}