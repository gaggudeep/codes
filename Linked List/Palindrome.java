import java.util.*;

class Palindrome
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

	static boolean isPalindrome(Node head)
	{
		Node slow = head, fast = head;
		Stack<Node> half = new Stack<>();

		while(fast != null && fast.next != null)
		{
			half.add(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null)
			slow = slow.next;

		while(!half.empty() && slow != null)
		{
			if(half.pop().data != slow.data)
				return false;
			slow = slow.next;
		}

		if(!half.empty() || slow != null)
			return false;

		return true;

	}

	public static void main(String args[])
	{
		Node head = new Node(6);
		Node head1 = new Node(9);
		head.next = head1;
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(3);
		head1.next.next.next.next = new Node(2);
		head1.next.next.next.next.next = new Node(9);

		System.out.println(isPalindrome(head));

	}
}