import java.util.*;

class Graph
{
	int V;
	ArrayList<LinkedList<Integer>> adj;

	Graph(){}

	Graph(int v)
	{
		V = v;
		adj = new ArrayList<>(V);
		for(int i = 0 ; i < V ; i++)
			adj.add(new LinkedList<>());
	}

	void addEdge(int u, int v, boolean directed)
	{
		adj.get(u).add(v);
		if(!directed)
			adj.get(v).add(u);
	}
}

class DFSTopo extends Graph
{
	static void topological(Graph g, int V)
	{
		Stack<Integer> st = new Stack<>();
		boolean vis[] = new boolean[V];
		for(int u = 0 ; u < V ; u++)
		{
			if(!vis[u])
			{
				topologicalUtil(g, V, u, st, vis);
			}
		}
		while(!st.empty())
		{
			System.out.print(st.pop() + " ");
		}
	}

	static void topologicalUtil(Graph g, int V, int u, Stack<Integer> st, boolean[] vis)
	{
		vis[u] = true;
		for(int v : g.adj.get(u))
		{
			if(!vis[v])
				topologicalUtil(g, V, v, st, vis);
		}
		st.push(u);
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 1, true);
		//g.addEdge(4, 2, true);
		topological(g, 5);
	}
}