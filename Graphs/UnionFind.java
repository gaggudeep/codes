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

class UnionFind extends Graph
{
	static int find(int[] parent, int x)
	{
		if(x == -1)
			return x;
		return find(parent, parent[x]);
	}

	static void union(int[] parent, int x, int y)
	{
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	static boolean hasCycle(Graph g, int V)
	{
		int parent[] = new int[V];
		Arrays.fill(parent, -1);

		for(int u = 0 ; u < V ; u++)
		{
			for(int v : g.adj.get(u))
			{
				int x = find(parent, u);
				int y = find(parent, v);

				if(x == y)
					return true;
				union(parent, x, y);
			}
		}
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