import java.util.*;

class ReverseSum
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

	static class Sum
	{
		int carry = 0;
		Node head = null;
	}

	static int len1 = 4, len2 = 3;

	static Node revSum(Node head1, Node head2, Node prev)
	{
		if(len1 > len2)
		{
			head2 = padList(head2, len1 - len2);
		}
		else if(len1 > len2)
		{
			head1 = padList(head1, len2 - len1);
		}

		Sum sum = addList(head1, head2);

		if(sum.carry == 0)
			return sum.head;
		else
		{
			Node result = insertBefore(sum.head, sum.carry);
			return result;
		}
	}

	static Sum addList(Node h1, Node h2)
	{
		if(h1 == null && h2 == null)
		{
			Sum partial = new Sum();
			return partial;
		}

		Sum partial = addList(h1.next, h2.next);

		int val = partial.carry + h1.data + h2.data;

		Node fullResult = insertBefore(partial.head, val % 10);

		partial.head = fullResult;
		partial.carry = val / 10;

		return partial;
	}

	static Node insertBefore(Node l, int data)
	{
		Node n = new Node(data);
		if(l != null)
			n.next = l;

		return n;
	}

	static Node padList(Node l, int padding)
	{
		Node head = l;
		for(int i = 0 ; i < padding ; i++)
		{
			head = insertBefore(head, 0);
		}

		return head;
	}

	public static void main(String args[])
	{
		Node head1 = new Node(9);
		head1.next = new Node(9);
		head1.next.next = new Node(8);
		head1.next.next.next = new Node(9);

		Node head2 = new Node(9);
		head2.next = new Node(8);
		head2.next.next = new Node(9);

		Node h = revSum(head1, head2, null);

		while(h != null)
		{
			System.out.println(h.data);
			h = h.next;
		}
	}
}