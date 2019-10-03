

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class LCA<Key extends Comparable<Key>, Value> 
{
  
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