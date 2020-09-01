import java.util.*;

class Partition
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

	static void partition(Node h, int x)
	{
		if(h == null || h.next == null)
			return;

		Node cur = h, head = h, tail = h;

		while(cur != null)
		{
			Node next = cur.next;

			if(cur.data < x)
			{
				cur.next = head;
				head = cur;
			}
			else
			{
				tail.next = cur;
				tail = cur;
			}
			cur = next;
		}
		tail.next = null;

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

		partition(head, 2);
	}
}