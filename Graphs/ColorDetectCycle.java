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

class ColorDetectCycle extends Graph
{
	static int WHITE = 0, GREY = 1, BLACK = 2;

	static boolean hasCycle(Graph g, int V)
	{
		int color[] = new int[V];
		Arrays.fill(color, 0);
		for(int u = 0 ; u < V ; u++)
		{
			if(color[u] == WHITE && hasCycleUtil(g, u, V, color))
				return true;
		}
		return false;
	}

	static boolean hasCycleUtil(Graph g, int u, int V, int[] color)
	{
		color[u] = GREY;
		for(int i : g.adj.get(u))
		{
			if(color[i] == GREY)
				return true;
			if(color[i] == WHITE && hasCycleUtil(g, i, V, color))
				return true;
		}
		color[u] = BLACK;
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