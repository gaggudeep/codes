import java.util.*;

class Learn
{
	static class Graph 
	{
		int v;
		ArrayList<LinkedList<Integer>> adj;
		Graph(int v)
		{
			this.v = v;
			adj = new ArrayList<>(v);
			for(int i = 0 ; i < v ; i++)
				adj.add(new LinkedList<>());
		}

		void addEdge(int u, int v)
		{
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
	}

	static boolean isCyclic(Graph g, int v)
	{
		boolean vis[] = new boolean[v];

		for(int i = 0 ; i < v ; i++)
		{
			if(!vis[i])
			{
				if(isCyclicUtil(g, i, v, vis))
					return true;
			}
		}
		return false;
	}

	static boolean isCyclicUtil(Graph g, int u, int v, boolean vis[])
	{
		if(vis[u])
			return true;
		vis[u] = true;
		for(int i : g.adj.get(u))
		{
			if(isCyclicUtil(g, i, v, vis))
				return true;
		}
		return false;
	}

	public static void main(String args[])
	{
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
	 	graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
        System.out.println(isCyclic(graph, 4));
	}
}