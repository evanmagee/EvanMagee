

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
    	return null;
    }
    
}