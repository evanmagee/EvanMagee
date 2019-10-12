import java.util.ArrayList;

public class DAG {

		private int V;
		private int E;
		private ArrayList<Integer>[] adj;
		private int[]indegree; // gives the indegree of a vertex
	
		public DAG(int V) {
			
		}
		
		public boolean isEmpty() {
			return false;
			
		}
		
		public int size() {
			return 0;
		}
		
		
		public int V() {
			return V;
			//returns number of vertices
		}
		
		public int E() {
			return E;
			//returns number of edges
		}
		
		public void addEdge(int v, int w) {
			if(validateVertex(v) ==1 && validateVertex(w)==1) {
				adj[v].add(w);
				E++;
				indegree[w]++;
			}
			else {
				System.out.println("Please enter valid vertices");
			}
		}
		
		public Iterable<Integer> adj(int v){
			return adj[v];
			//finds vertics that are adjacent
		}
		
		public DAG reverse() {
			return null;
			///returns DAG in reverse order
		}
		
		private int validateVertex(int v) { // this function makes sure that a given vertex is possible 
			 if (v < 0 || v >= V) {

		        	return -1;
			 }
		        else {

		        	return 1;
		        }
		}
		
		public int indegree(int v) {
			if(validateVertex(v)==-1) {
				return -1;
			}
			else {
				return indegree(v);
			}
		}
		
					
}

		
		
	
	

