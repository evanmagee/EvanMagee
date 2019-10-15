import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DAGTest {

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
		assertTrue(tester.hasCycle());
	}
	
	@Test
	
	public void testDAGConstructor() {
		DAG tester = new DAG(10);
		tester.addEdge(1,2);
		tester.addEdge(2,3);
		tester.addEdge(2,4);
		tester.addEdge(4,5);
		tester.addEdge(5,6);
	
		
		assertEquals(" ", 1 , tester.indegree(3));
//		assertEquals("",2, tester.outdegree(2));
//		assertEquals("",2,tester.indegree(2));
//		assertEquals("",12,tester.V());
//		assertEquals("",6,tester.E());
		
	}
}
