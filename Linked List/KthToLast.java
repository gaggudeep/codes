import java.util.*;

class KthToLast
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

	static void kthToLast(Node head, int k)
	{
		Node n1 = head;
		int i = 0;

		while(i++ < k)
		{
			if(n1 == null)
				return;

			n1 = n1.next;
		}

		Node kth = head;

		while(n1 != null)
		{
			n1 = n1.next;
			kth = kth.next;
		}

		System.out.println(kth.data);
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

		kthToLast(head, 1);
	}
}