import java.util.*;
import javafx.util.*;

class WeightedGraph
{
	int V;
	ArrayList<ArrayList<int[]>> adj;

	WeightedGraph(){}

	WeightedGraph(int v)
	{
		V = v;
		adj = new ArrayList<>(V);
		for(int i = 0 ; i < V ; i++)
		{
			adj.add(new ArrayList<>());
		}
	}

	void addEdge(int u, int v, boolean directed, int weight)
	{
		adj.get(u).add(new int[]{v, weight});
		if(!directed)
			adj.get(v).add(new int[]{u, weight});
	}
}

class Kruskal extends WeightedGraph implements Comparator<int[]>
{
	public int compare(int[] p1, int[] p2)
	{
		return p1[2] - p2[2];
	}

	static class Subset
	{
		int parent, rank;
	}

	static int find(Subset[] subsets, int i)
	{
		if(subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	static void union(Subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else
		{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	static ArrayList<int[]> kruskal(WeightedGraph g, int V)
	{
		ArrayList<int[]> shortestPath = new ArrayList<>(V);
		ArrayList<int[]> edges = new ArrayList<>();

		for(int u = 0 ; u < V ; u++)
		{
			for(int[] edge : g.adj.get(u))
			{
				edges.add(new int[]{u, edge[0], edge[1]});	
			}
		}
		Collections.sort(edges, new Kruskal());

		int idx = 0;
		Subset subsets[] = new Subset[V];
		for(int u = 0 ; u < V ; u++)
		{
			subsets[u] = new Subset();
			subsets[u].parent = u;
			subsets[u].rank = 0;
		}

		while(idx < edges.size() && shortestPath.size() <= V - 1)
		{
			int[] edge = edges.get(idx++);
			int x = find(subsets, edge[0]);
			int y = find(subsets, edge[1]);
			if(x != y)
			{
				shortestPath.add(edge);
				union(subsets, x, y);
			}
		}

		return shortestPath.size() == V - 1 ? shortestPath: null;
	}

	public static void main(String args[])
	{
		WeightedGraph g = new WeightedGraph(4);
		g.addEdge(0, 1, false, 10);
		g.addEdge(0, 2, false, 6);
		g.addEdge(0, 3, false, 5);
		g.addEdge(1, 3, false, 15);
		g.addEdge(2, 3, false, 4);

		ArrayList<int[]> shortestPath = kruskal(g, 4);
		for(int[] e : shortestPath)
		{
			for(int i : e)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}