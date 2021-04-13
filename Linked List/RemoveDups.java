import java.util.*;

class RemoveDups
{

	static class Node
	{
		int data;
		Node next;

		Node(int data)
		{
			this.data = data;
			next = null;
		}

	}

	static void removeDups(Node head)
	{
		if(head == null)
			return;

		HashSet<Integer> unique = new HashSet<>();

		Node cur = head, prev = null;

		while(cur != null)
		{
			if(unique.contains(cur.data))
			{
				prev.next = cur.next;
			}
			else
			{
				unique.add(cur.data);
				prev = cur;
			}
							cur = cur.next;
		}

		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}


	public static void main(String args[])
	{
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next.next = new Node(3);

		removeDups(head);
	}
}