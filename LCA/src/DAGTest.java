import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

	@Test
	
	public void testDAGConstructor() {
		DAG tester = new DAG(12);
		tester.addEdge(1, 2);	
		tester.addEdge(2, 3);	
		tester.addEdge(2, 4);
		tester.addEdge(4, 5);
		tester.addEdge(5, 6);
		tester.addEdge(5, 7);
		
		
		
		assertEquals("", 6, tester.E());
		assertEquals("",12,tester.V());
		assertEquals("",1,tester.outdegree(4));
		assertEquals("",1,tester.indegree(4));
		
	}
	@Test
	
	public void testAddEdge() {
		DAG tester = new DAG (6);
		tester.addEdge(2,3);
		assertEquals("Number of edges should be 1", 1, tester.E());
		
		tester.addEdge(3,4);
		assertEquals("Number of edges should be 2",2,tester.E());
		
		tester.addEdge(4,5);
		assertEquals("Number of edges should be 3",3,tester.E());
		
		tester.addEdge(-2,4);
		//this shouldnt add an edge
		assertEquals("Number of edges should be 3",3,tester.E());
	}
	
	@Test
	
	public void testHasCycle() {
		DAG tester = new DAG(6);
		tester.addEdge(1,2);
		tester.addEdge(2,3);
		tester.addEdge(3,1);
		tester.findCycle(1);
		assertTrue(tester.hasCycle());
		
		DAG testerWithNoCycle = new DAG(6);
		testerWithNoCycle.addEdge(1,2);
		testerWithNoCycle.addEdge(2,3);
		testerWithNoCycle.addEdge(3,4);
		testerWithNoCycle.findCycle(1);
		assertFalse(testerWithNoCycle.hasCycle());
	}
	
	@Test
	
	public void testLCA() {
		DAG lcaTest = new DAG(7);
		lcaTest.addEdge(0,1);
		lcaTest.addEdge(0,2);
		lcaTest.addEdge(1,3);
		lcaTest.addEdge(2,3);
		lcaTest.addEdge(3,4);
		lcaTest.addEdge(3,5);
		lcaTest.addEdge(4,6);
		lcaTest.addEdge(5,6);
		
		assertEquals("LCA for 4 and 5", 3, lcaTest.LCA(4,5));
		assertEquals("LCA for 1 and 2",0,lcaTest.LCA(1,2));
		assertEquals("LCA for 6 and 4",4,lcaTest.LCA(4,6));
		assertEquals("LCA for 4 and 1",1,lcaTest.LCA(4,1));
		
		
//		
	}
	
	@Test
	
	public void testIfNotADAG() {
		DAG nonDAG = new DAG(8);
		nonDAG.addEdge(0,1);
		nonDAG.addEdge(1,2);
		nonDAG.addEdge(2,3);
		nonDAG.addEdge(3,1);
		
		
		assertEquals("",-1,nonDAG.LCA(2,3));
		assertEquals("",-1,nonDAG.LCA(1,3));
		assertEquals("",-1,nonDAG.LCA(3,1));
		
//		

		
	}
	
	@Test
	
	public void testIfNoCommonAncestor() {
		DAG noCommonAncestor = new DAG(8);
		noCommonAncestor.addEdge(0,1);
		noCommonAncestor.addEdge(0,2);
		noCommonAncestor.addEdge(1,3);
		noCommonAncestor.addEdge(2,3);
		noCommonAncestor.addEdge(3,4);
		noCommonAncestor.addEdge(3,5);
		noCommonAncestor.addEdge(4,6);
		noCommonAncestor.addEdge(5,6);
		
		
		
		assertEquals("Find LCA for node that doesn't exist", -1, noCommonAncestor.LCA(7,2));
		assertEquals("Find LCA for node that doesn't exist",-1,noCommonAncestor.LCA(4,7));
		
		
//		
	}
	
	@Test
	
	public void testIfLCAEmpty() {
		DAG emptyDAG = new DAG(8);
		assertEquals("LCA should be -1",-1,emptyDAG.LCA(1,2));
	}
	
	
}
