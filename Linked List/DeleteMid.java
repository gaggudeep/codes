import java.util.*;

class DeleteMid
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

	static void deleteMid(Node head, Node mid)
	{
		if(mid == null || mid.next == null)
			return;

		mid.data = mid.next.data;
		mid.next = mid.next.next;

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

		deleteMid(head, head.next.next.next.next);
	}
}