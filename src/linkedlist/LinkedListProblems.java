package linkedlist;

import java.util.HashSet;

public class LinkedListProblems extends LinkList {

	/***
	 * This method insert loop in linked list. Last element will point at
	 * mentioned location.
	 * 
	 * @param head
	 *            head of Linked List in which wants to create loop
	 * @param position
	 *            at which last element of LL will point to make a loop
	 */
	public void insertLoopInLL(LinkListNode head, int position) {

		LinkListNode posPointer = head;
		LinkListNode tailPointer;

		if (head == null) {
			System.out.println("Linked List is not formed yet");
			return;
		}

		int i = 1;
		while (i < position && posPointer.nextNode != null) {
			posPointer = posPointer.nextNode;
			i++;
		}

		tailPointer = posPointer;

		while (tailPointer.nextNode != null) {
			tailPointer = tailPointer.nextNode;
		}

		tailPointer.nextNode = posPointer;
	}

	
}
