import java.util.*;

class Subtree 
{
	static class Node
	{
		int val;
		Node left, right;
		Node(int v)
		{
			val = v;
			left = right = null;
		}
	}

	static boolean isSubtree(Node r1, Node r2)
	{
		if(r1 == null || r2 == null)
			return false;
		if(r1.val == r2.val)
		{
			ArrayList<Integer> r2Level = new ArrayList<>();
			levelOrder(r2, r2Level);
			if(hasSameOrder(r1, r2Level))
				return true;
			return false;
		}
		return isSubtree(r1.left, r2) || isSubtree(r1.right, r2);
	}

	static boolean hasSameOrder(Node r1, ArrayList<Integer> r2Level)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(r1);
		int i = 0;
		while(i < r2Level.size() && !q.isEmpty())
		{
			int size = q.size();
			for(int j =  0 ; i < r2Level.size() && j < size ; j++)
			{
				Node n = q.poll();
				if(n.val != r2Level.get(i++))
					return false;
				if(n.left != null)
					q.add(n.left);
				if(n.right != null)
					q.add(n.right);
			}
		}
		if(i == r2Level.size())
			return true;
		return false;
	}

	static void levelOrder(Node n, ArrayList<Integer> a)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(n);
		while(!q.isEmpty())
		{
			int size = q.size();
			for(int i = 0  ; i < size ; i++)
			{
				Node node = q.poll();
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				a.add(node.val);
			}
		}
	}


	public static void main(String args[])
	{
		Node r1 = new Node(16);
		r1.left = new Node(15);
		r1.right = new Node(17);	
		r1.right.left = new Node(18);	

		Node r2 = new Node(16);	
		r2.left = new Node(15);	
		r2.right = new Node(17);	

		System.out.println(isSubtree(r1, r2));
	}
}