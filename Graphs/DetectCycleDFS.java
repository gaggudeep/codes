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

class DetectCycleDFS extends Graph
{

	static boolean hasCycle(Graph g, int V)
	{
		boolean recStack[] = new boolean[V], vis[] = new boolean[V];
		for(int u = 0 ; u < V ; u++)
		{
			if(hasCycleUtil(g, u, recStack, vis))
				return true;
		}
		return false;
	}

	static boolean hasCycleUtil(Graph g, int u, boolean[] recStack, boolean[] vis)
	{
		if(recStack[u])
			return true;
		if(vis[u])
			return false;
		vis[u] = true;
		recStack[u] = true;
		for(int i : g.adj.get(u))
		{
			if(hasCycleUtil(g, i, recStack, vis))
				return true;
		}
		recStack[u] = false;
		return false;
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1, false);
		g.addEdge(1, 4, false);
		g.addEdge(2, 3, false);
		g.addEdge(3, 1, false);
		g.addEdge(4, 2, false);
		System.out.println(hasCycle(g, 5));
	}
}