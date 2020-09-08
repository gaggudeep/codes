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

class ColorGraph extends Graph 
{

	static void colorGraph(Graph g, int V)
	{
		boolean available[] = new boolean[V];
		Arrays.fill(available, true);
		int result[] = new int[V];
		Arrays.fill(result, -1);
		result[0] = 0;
		for(int u = 1 ; u < V ; u++)
		{
			for(int v : g.adj.get(u))
			{
				if(result[v] != -1)
					available[result[v]] = false;
			}
			int c;
			for(c = 0 ; c < V ; c++)
			{
				if(available[c])
					break;
			}
			result[u] = c;
			Arrays.fill(available, true);
		}
		for(int i : result)
			System.out.print(i + " ");
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1, false);
		g.addEdge(1, 4, false);
		g.addEdge(2, 3, false);
		g.addEdge(3, 1, false);
		g.addEdge(4, 2, false);
		colorGraph(g, 5);
	}
}