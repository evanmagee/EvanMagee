import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {

		private int V;
		private int E;
		private ArrayList<Integer>[] adj;
		private int[]indegree; // gives the indegree of a vertex
		private int[] outdegree; // gives outdegree
		private boolean hasCycle; //Returns true if there is a cycle in the graph
		private boolean marked[];
		private boolean stack[];
		
		
		
		public DAG(int V) {
			if(V>=0) {
				this.V = V;
				this.E = 0;
				indegree = new int[V];
				marked = new boolean[V];
			    stack = new boolean[V];
				adj = (ArrayList<Integer>[]) new ArrayList[V];

			    for (int v = 0; v < V; v++) {

			        adj[v] = new ArrayList<Integer>();

			    }              
			}
			else {
				System.out.println("Number of vertices must be a positive number");
			}
				
				
				
		}
		
		
		public boolean hasCycle() {
			return hasCycle;
		}
		
		public void findCycle(int v) {
			
			marked[v] = true;

		        stack[v] = true;

		        for (int w : adj(v)) {

		            if(!marked[w]) {

		                findCycle(w);

		            } 
		            else if (stack[w]) {

		                hasCycle = true;

		                return;

		            }

		        }


		        stack[v] = false;

		    }

			
		public ArrayList<Integer> BFS(int x) { // got this code from algorithms & data structures from last year
			 
			
			boolean visited[] = new boolean[V];


		        LinkedList<Integer> queue = new LinkedList<Integer>();

		        ArrayList<Integer> order= new ArrayList<Integer>();

		 

		        visited[x]=true;

		        queue.add(x);
		        while (queue.size() != 0)

		        {
		            x = queue.poll();           
		            order.add(x);
		            Iterator<Integer> i = adj[x].listIterator();
		            while (i.hasNext())

		            {

		                int n = i.next();

		                if (!visited[n])

		                {

		                    visited[n] = true;

		                    queue.add(n);

		                }

		            }

		        }

		        

		        return order;

		        

		}
		
		public int LCA(int v, int w) {
			return 0;
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
		
		public DAG reverse() { // returns DAG in reverse order
			DAG reverse = new DAG(V);
			for (int v = 0; v < V; v++) {
	            for (int w : adj(v)) {

	                reverse.addEdge(w, v); 

	            }

	        }

	        return reverse;

			
			
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
		
		public int outdegree(int v) {
			if(validateVertex(v)==-1) {
				return -1;
			}
			else {
				return adj[v].size();
			}
		}
		
					
}

		
		
	
	

