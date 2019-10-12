import java.util.ArrayList;

public class DAG {

		private int V;
		private int E;
		private ArrayList<Integer>[] adj;
	
	
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


		}
		
	
	

