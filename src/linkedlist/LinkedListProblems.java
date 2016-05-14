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

	/***
	 * This method is method overriding. If user don't have any specific
	 * position then default condition is head node
	 * 
	 * @param head
	 *            head of linked list in which user wants to insert loop
	 */
	public void insertLoopInLL(LinkListNode head) {
		this.insertLoopInLL(head, 0);
	}
	
	/***
	 * This method finds there is a loop in Linked list or not
	 * 
	 * @param head
	 *            head of LL to check loop present or not
	 * @return if loop present in LL return null. If not present return some
	 *         nodes from loop where fastPointer == slowPointer
	 */
	public LinkListNode isLoop(LinkListNode head) {
		LinkListNode slowP = head;
		LinkListNode fastP = head;

		while (fastP.nextNode != null) {
			slowP = slowP.nextNode;
			fastP = fastP.nextNode.nextNode;

			if (slowP.equals(fastP)) {
				return slowP;
			}
		}

		return null;
	}

	public boolean isLoop(){
		if(this.isLoop(this.headNode) != null){
			System.out.println("Loop present in LL");
			return true;
		}
		System.out.println("Loop in not present in LL");
		return false;
	}
	
	
	/***
	 *  This method finds number of nodes in loop
	 * @param head head of Linked List
	 * @return count in int, number of nodes in loop
	 */
	public int loopNodeCount(LinkListNode head){

		if (head == null) {
			System.out.println("Linked List in not formd yet");
			return 0;
		}

		int count = 1;
		LinkListNode loopP = isLoop(head);
		LinkListNode countP = loopP.nextNode;
		
		while(!countP.equals(loopP)){
			countP = countP.nextNode;
			count++;
		}
		
		return count;
	}
	
	
	/***
	 * This method find the starting point of loop in LL 
	 * @param head  head of Linked list that contains loop
	 * @return starting node of the loop
	 */
	public LinkListNode findLoopPoint(LinkListNode head) {
		LinkListNode slowP;
		LinkListNode fastP;
		HashSet<LinkListNode> loopNodes = new HashSet<LinkListNode>();
		if (head == null) {
			System.out.println("Linked List in not formd yet");
			return null;
		}

		slowP = isLoop(head);
		fastP = slowP;
		if (slowP == null) {
			return slowP;
		}

		loopNodes.add(slowP);
		slowP = slowP.nextNode;

		while (!slowP.equals(fastP)) {
			loopNodes.add(slowP);
			slowP = slowP.nextNode;
		}

		slowP = head;
		while (!loopNodes.contains(slowP)) {
			slowP = slowP.nextNode;
		}

		return slowP;
	}
	
	
}
