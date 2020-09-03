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

class UnionFindByRank extends Graph
{
	class Subset
	{
		int parent, rank;
	}

	static int find(Subset[] subsets, int i)
	{
		if(subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	static void union(Subset[] subsets, int x, int y)
	{
		int xroot = find(subsets, subsets[x].parent);
		int yroot = find(subsets, subsets[y].parent);
		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[yroot].rank < subsets[xroot].rank)
			subsets[yroot].parent = xroot;
		else
		{
			subsets[xroot].parent = yroot;
			subsets[yroot].rank++;
		}
	}

	boolean hasCycle(Graph g, int V)
	{
		Subset subsets[] = new Subset[V];
		for(int i = 0 ; i < V ; i++)
		{
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		for(int u = 0 ; u < V ; u++)
		{
			for(int v : g.adj.get(u))
			{
				int x = find(subsets, u);
				int y = find(subsets, v);
				if(x == y)
					return true;
				union(subsets, x, y);
			}
		}
		return false;
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 1, true);
		g.addEdge(4, 2, true);
		System.out.println(new UnionFindByRank().hasCycle(g, 5));
	}
}