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

class DetectCycleBFSTopological extends Graph
{
	static boolean hasCycle(Graph g, int V)
	{
		int inDegree[] = new int[V];
		for(LinkedList<Integer> adj : g.adj)
		{
			for(int v : adj)
			{
				inDegree[v]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int u = 0 ; u < V ; u++)
		{
			if(inDegree[u] == 0)
				q.add(u);
		}
		int visited = 0;
		while(!q.isEmpty())
		{
			int u = q.remove();
			visited++;
			System.out.print(u + " ");
			for(int v : g.adj.get(u))
			{
				if(--inDegree[v] == 0)
				{
					q.add(v);
				}
			}
		}
		return V != visited;
	}

	public static void main(String args[])
	{
		Graph g = new Graph(5);
		g.addEdge(0, 1, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 1, true);
		//g.addEdge(4, 2, true);
		System.out.println(hasCycle(g, 5));
	}
}