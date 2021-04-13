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

class AllCombTopo extends Graph
{
	static void allTopological(Graph g, int V)
	{
		int inDegree[] = new int[V];
		for(LinkedList<Integer> adj : g.adj)
		{
			for(int v : adj)
			{
				inDegree[v]++;
			}
		}
		ArrayList<Integer> st = new ArrayList<>();
		boolean vis[] = new boolean[V];
		allTopologicalUtil(g, V, inDegree, st, vis);
	}

	static void allTopologicalUtil(Graph g, int V, int[] inDegree, ArrayList<Integer> st, boolean[] vis)
	{
		boolean flag = false;
		for(int u = 0 ; u < V ; u++)
		{
			if(!vis[u] && inDegree[u] == 0)
			{
				vis[u] = true;
				st.add(u);
				for(int v : g.adj.get(u))
					inDegree[v]--;
				allTopologicalUtil(g, V, inDegree, st, vis);
				vis[u] = false;
				st.remove(st.size() - 1);
				for(int v : g.adj.get(u))
					inDegree[v]++;
				flag = true;
			}
		}
		if(!flag)
		{
			st.forEach(i -> System.out.print(i + " "));
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 1, true);
		//g.addEdge(4, 2, true);
		allTopological(g, 5);
	}
}