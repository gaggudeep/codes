import java.util.*;

class Sum
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

	static Node sumLL(Node h1, Node h2, int carry)
	{
		if(h1 == null && h2 == null && carry == 0)
			return null;

		Node n = new Node(-1);
		int value = carry;

		if(h1 != null)
			value += h1.data;
		if(h2 != null)
			value += h2.data;

		n.data = value % 10;

		if(h1 != null || h2 != null)
		{
			Node node = sumLL((h1 == null) ? null : h1.next,
							(h2 == null) ? null : h2.next,
							(value >= 10) ? 1 : 0);
			n.next = node;
		}

		return n;
	}

	public static void main(String args[])
	{

		Node head1 = new Node(9);
		head1.next = new Node(9);
		head1.next.next = new Node(9);

		Node head2 = new Node(9);
		head2.next = new Node(9);
		head2.next.next = new Node(9);

		Node newHead = sumLL(head1, head2, 0);

		while(newHead != null)
		{
			System.out.print(newHead.data);
			newHead = newHead.next;
		}
	}
}