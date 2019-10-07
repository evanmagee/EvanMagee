import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LCATest {

	@Test
	public void testLCA() {
		
	}

	
	@Test
	public void testSize() {
		LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
		assertEquals(0, lca.size());
		
		lca.put(1, 1); 
		assertEquals(1, lca.size());
		
		lca.put(2, 2);     
		lca.put(3, 3);       
		lca.put(4, 4);      
		lca.put(5, 5);      
		lca.put(6, 6);       
		lca.put(7, 7);       
		lca.put(8, 8); 
		assertEquals(8, lca.size());
	}
	// Got this test from the same project I used from last year
	
	@Test
	public void testPut() {
LCA<Integer, Integer> lca = new LCA<Integer, Integer>();
		
		lca.put(5, null);
		lca.put(7, 7);
		lca.put(8, 8);     
		lca.put(3, 3);       
		lca.put(1, 1);      
		lca.put(2, 2);      
		lca.put(6, 6);       
		lca.put(4, 4);       
		lca.put(5, 5); 
		lca.put(5, 5); 
		
		assertEquals("(((()1(()2()))3((()4(()5()))6()))7(()8()))", lca.printKeysInOrder());
		
	}
	
	//Used the same project from last year to get this test
	//renamed parameters to make relevant for LCA
	@Test
	public void testDelete() {
		
	}
	
	
}
