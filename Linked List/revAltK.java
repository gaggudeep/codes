import java.util.*;

class revAltK
{
	static class Node
	{
		int val;
		Node next;
		Node(int v)
		{
			val = v;
			next = null;
		}
	}

	static Node revK(Node head, int k, boolean rev)
	{
		if(head == null)
			return head;
		int count = 1;
		Node prev = null, next = null, cur = head;
		while(cur != null && count <= k)
		{
			next = cur.next;
			if(rev == true)
				cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		if(rev == true)
		{
			head.next = revK(cur, k, !rev);
			return prev;
		}
		prev.next = revK(cur, k, !rev);
		return head;
	}

	public static void main(String args[])
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = revK(head, 3, true);
		while(head != null)
		{
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}