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

class Prim extends WeightedGraph implements Comparator<Pair<Integer, Integer>>
{
	static int minKey(int key[], boolean vSet[])
	{
		int min = Integer.MAX_VALUE, minIdx = -1;
		for(int v = 0 ; v < key.length ; v++)
		{
			if(vSet[v] == false && key[v] < min)
			{
				min = key[key.length - 1];
				minIdx = v;
			}
		}
		return minIdx;
	}

	static ArrayList<int[]> primMatrix(int[][] g, int V)
	{
		boolean[] vSet = new boolean[V];
		int[] key = new int[V], parent = new int[V];
		Arrays.fill(key, Integer.MAX_VALUE);
		key[0] = 0;
		parent[0] = -1;
		for(int i = 0 ; i < V - 1 ; i++)
		{
			int u = minKey(key, vSet);
			vSet[u] = true;
			for(int v = 0 ; v < V ; v++)
			{
				if(g[u][v] != 0 && vSet[v] == false && g[u][v] < key[v])
				{
					parent[v] = u;
					key[v] = g[u][v];
				}
			}
		}
		ArrayList<int[]> mst = new ArrayList<>(V - 1);
		for(int i = 1 ; i <= V - 1 ; i++)
		{
			mst.add(new int[]{parent[i], i, key[i]});
		}
		return mst;
	}

	public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2)
	{
		return p1.getValue() - p2.getValue();
	}

	static ArrayList<int[]> primAdj(WeightedGraph g, int V)
	{
		ArrayList<int[]> mst = new ArrayList<>(V - 1);
		boolean vSet[] = new boolean[V];
		int parent[] = new int[V];
		int key[] = new int[V];
		Arrays.fill(key, Integer.MAX_VALUE);
		TreeSet<Pair<Integer, Integer>> ts = new TreeSet<Pair<Integer, Integer>>(new Prim());
		ts.add(new Pair(0, 0));
		key[0] = 0;

		for(int u = 1 ; u < V ; u++)
		{
			ts.add(new Pair(u, Integer.MAX_VALUE));
		}
		while(!ts.isEmpty())
		{
			Pair<Integer, Integer> p = ts.pollFirst();
			int u = p.getKey();
			vSet[u] = true;
			for(int[] edge : g.adj.get(u))
			{
				if(!vSet[edge[0]] && edge[1] < key[edge[0]])
				{
					ts.remove(new Pair(edge[0], key[edge[0]]));
					key[edge[0]] = edge[1];
					parent[edge[0]] = u;
					ts.add(new Pair(edge[0], edge[1]));
				}
			}
		}
		for(int i = 1 ; i < V ; i++)
			mst.add(new int[]{parent[i], i, key[i]});
		return mst;
	}

	public static void main(String args[])
	{
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };
        
        ArrayList<int[]> mst = primMatrix(graph, 5);
        for(int[] e : mst)
		{
			for(int i : e)
				System.out.print(i + " ");
			System.out.println();
		}

		WeightedGraph g = new WeightedGraph(4);
		g.addEdge(0, 1, false, 10);
		g.addEdge(0, 2, false, 6);
		g.addEdge(0, 3, false, 5);
		g.addEdge(1, 3, false, 15);
		g.addEdge(2, 3, false, 4);

		mst = primAdj(g, 4);
		for(int[] e : mst)
		{
			for(int i : e)
				System.out.print(i + " ");
			System.out.println();
		}
		
	}
}