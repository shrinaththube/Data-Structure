package linkedlist;

import javax.swing.JSpinner.ListEditor;

/**
 * @author Shrinath
 *
 *         This class is about 
 *         - creating Linked List from given array.
 *         - Display Linked List 
 *         - Sorting of Linked List by Bubble and Insertion. 
 *         - Merging of sorted linked list in place and keep sorted while merging.
 *         - Reverse all linked list
 *         - Reverse Linked List from specific position
 *         - Reverse nodes in group in Linked List
 *         
 * 
 */
/**
 * @author Shrinath
 *
 */
public class LinkList {
	public LinkListNode headNode;
	public LinkListNode prevNode;

	public static void main(String args[]) {

		// Test case
		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();
		LinkList list3 = new LinkList();
		int[] array = { 3, 4, 5, 2, 8, 6, 9, 1 };
		int[] array1 = { 4, 3, 6, 77, 55, 43, 9, 5 };
		int[] array2 = { 1, 2, 3, 4, 5 };
		
		// Create linked list 1 - Sort it - Display it
		list1.createLinkList(array);
		System.out.print("List 1 before sorting : ");
		list1.displayLinkList();
		list1.sortLinkList_Insertion();
		System.out.print("List 1 after sorting : ");
		list1.displayLinkList();
		System.out.print("List 1 after reverse : ");
		list1.reverse(list1.headNode, 2, "head");
		list1.displayLinkList();
		
		// Create linked list 2 - Sort it - Display it
		list2.createLinkList(array1);
		System.out.print("List 2 before sorting : ");
		list2.displayLinkList();
		list2.sortLinkList_bubble();
		System.out.print("List 2 after sorting : ");
		list2.displayLinkList();

		// Merge list 2 into list 1
		list1.mergeSortedLinkList(list2);
		System.out.print("List 1 after merging List 2 : ");
		list1.displayLinkList();
		
		list3.createLinkList(array2);
		System.out.println("list 1 before group reverse: ");
		list3.displayLinkList();
		list3.reverseLLInGroup(list3.headNode, 2);
		list3.displayLinkList();
		
	}

	// Creating LinkList from given array
	public void createLinkList(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (this.headNode == null) {
				this.assignHead(array[i]);
			} else {
				this.addNode(array[i]);
			}
		}
	}

	// Assigning head node to LinkList
	public void assignHead(int value) {
		if (this.headNode == null) {
			this.headNode = new LinkListNode(value);
			this.prevNode = this.headNode;
		}
	}

	// Add node in the given linked list
	public void addNode(int value) {
		if (this.headNode == null) {
			this.assignHead(value);
		} else {
			LinkListNode newNode = new LinkListNode(value);
			this.prevNode.nextNode = newNode;
			this.prevNode = newNode;
		}
	}

	// Print the Linked list
	public void displayLinkList() {
		LinkListNode printNode = this.headNode;
		while (printNode != null) {
			System.out.print(printNode.value + " -> ");
			printNode = printNode.nextNode;
		}
		System.out.print("null" + "\n");
	}

	// Bubble sorting of LinkList , time complexity O(n^2), space complexity
	// O(1) int temp variable for swapping
	public void sortLinkList_bubble() {

		int temp;
		boolean flag = false;
		while (!flag) {

			flag = true;
			LinkListNode first = this.headNode;
			LinkListNode second = this.headNode.nextNode;

			while (second != null) {

				if (first.value > second.value) {
					temp = second.value;
					second.value = first.value;
					first.value = temp;
					flag = false;
				}
				first = first.nextNode;
				second = second.nextNode;
			}
		}
	}

	// Insertion sorting of Link List time complexity O(n^2), space complexity 0
	// -> in place sorting
	public void sortLinkList_Insertion() {
		if (this.headNode != null) {
			// sorted linkList
			LinkListNode prev_Node = this.headNode;
			LinkListNode next_Node = prev_Node.nextNode;

			// Unsorted LinkList
			LinkListNode new_list_head = this.headNode.nextNode;
			LinkListNode current_Node = new_list_head;

			prev_Node.nextNode = null;

			// loop will continue until all element of unsorted iterated
			while (new_list_head != null) {
				current_Node = new_list_head;
				new_list_head = new_list_head.nextNode;

				prev_Node = this.headNode;
				next_Node = prev_Node.nextNode;

				// finding appropriate position to insert current node in sorted
				// LinkList
				while (prev_Node != null) {
					// current node is smallest element at that point
					if (current_Node.value < prev_Node.value) {
						this.headNode = current_Node;
						current_Node.nextNode = prev_Node;
						break; // loop should not continue after inserting
								// element
					}
					// current node is largest element at that point
					else if (prev_Node.value < current_Node.value && next_Node == null) {
						prev_Node.nextNode = current_Node;
						current_Node.nextNode = null;
						break;// loop should not continue after inserting
								// element
					} else if (prev_Node.value <= current_Node.value && current_Node.value <= next_Node.value) {
						prev_Node.nextNode = current_Node;
						current_Node.nextNode = next_Node;
						break;// loop should not continue after inserting
								// element
					}
					prev_Node = prev_Node.nextNode;
					next_Node = prev_Node.nextNode;
				}
			}
		} else {
			System.out.println("LinkedList is empty");
		}
	}

	// Merging of two sorted linked lists into one.
	public void mergeSortedLinkList(LinkList list2) {

		LinkListNode ref_list1 = this.headNode;
		LinkListNode ref_list2 = list2.headNode;
		LinkListNode ref_merge_list = null;

		if (ref_list1 == null && ref_list2 != null) {
			this.headNode = ref_list2;
		}

		if (ref_list1 != null && ref_list2 != null) {
			if (ref_list1.value < ref_list2.value) {
				this.headNode = ref_list1;
				ref_merge_list = this.headNode;
				ref_list1 = ref_list1.nextNode;
				ref_merge_list.nextNode = null;
			} else {
				this.headNode = ref_list2;
				ref_merge_list = this.headNode;
				ref_list2 = ref_list2.nextNode;
				ref_merge_list.nextNode = null;
			}
		}

		while (ref_list1 != null && ref_list2 != null) {
			if (ref_list1.value < ref_list2.value) {
				ref_merge_list.nextNode = ref_list1;
				ref_merge_list = ref_merge_list.nextNode;
				ref_list1 = ref_list1.nextNode;
				ref_merge_list.nextNode = null;
			} else {
				ref_merge_list.nextNode = ref_list2;
				ref_merge_list = ref_merge_list.nextNode;
				ref_list2 = ref_list2.nextNode;
				ref_merge_list.nextNode = null;
			}
		}

		if (ref_list1 != null && ref_merge_list != null) {
			ref_merge_list.nextNode = ref_list1;
		}
		if (ref_list2 != null && ref_merge_list != null) {
			ref_merge_list.nextNode = ref_list2;
		}
	}

	/***
	 * ********************** Reverse the singly linked list from specific position **********************
	 * 
	 * @param head
	 *            Head of the singly liked list that caller wants to reverse
	 * @param count
	 *            position from that caller wants to reverse linked list
	 * @param position
	 *            caller will specify is position from head or from tail or it
	 *            wants middle
	 */
	public void reverse(LinkListNode head, int count, String position) {

		if (head == null) {
			System.out.println("Linked List is empty can't reverse it");
			return;
		}

		int nodeCount = 1;
		int positionCountOfNode = 0;

		LinkListNode traverse = head;
		LinkListNode positionPointer = head;

		while (traverse.nextNode != null) {
			traverse = traverse.nextNode;
			nodeCount++;
		}

		if (position.toLowerCase().equals("head")) {
			positionCountOfNode = count - 1;
		} else if (position.toLowerCase().equals("tail")) {
			positionCountOfNode = nodeCount - count - 2;
		} else {
			positionCountOfNode = (nodeCount / 2); // consider default mid
													// position
		}

		System.out.println("Count = " + nodeCount + " midcount =" + positionCountOfNode);

		while (positionCountOfNode > 0) {
			positionPointer = positionPointer.nextNode;
			positionCountOfNode -= 1;
		}

		// count 0 is means caller wants to reverse all nodes starting form
		// head.
		// headNode is the instance variable of list object.
		if (count < 1 && !position.equals("mid")) {
			this.headNode = reverse(head);
		} else {
			positionPointer.nextNode = reverse(positionPointer.nextNode);
		}

	}

	// Method overloading

	/***
	 * ****************** This is Iterative solution
	 * **************************** This is method overloading. This will simply
	 * reveres all singly linked list.
	 * 
	 * @param head
	 *            caller will provide the head of linked list.
	 * @return It returns the reversed liked list's head which will last element
	 *         of previous linked list.
	 * 
	 */
	public LinkListNode reverse(LinkListNode head) {
		if (head == null) {
			System.out.println("Liked list is empty");
			return null;
		}

		LinkListNode prePointer = null;
		LinkListNode currPointer = head;
		LinkListNode nextPointer = currPointer.nextNode;

		while (currPointer.nextNode != null) {
			currPointer.nextNode = prePointer;
			prePointer = currPointer;
			currPointer = nextPointer;
			nextPointer = nextPointer.nextNode;
		}
		currPointer.nextNode = prePointer;
		return currPointer;
	}

	/***
	 * This is solution of LeetCode problem of "25. Reverse Nodes in k-Group"
	 * 
	 * Caller will provide head node  and number of node in group.
	 * 
	 * @param head head of linked list
	 * @param numberOfNodes how many nodes are in group that should be reverse
	 */
 public void reverseLLInGroup(LinkListNode head, int numberOfNodes) {

		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}

		LinkListNode prePointer = null;
		LinkListNode preHead = head;
		LinkListNode preTail = head;
		LinkListNode nextHead = head;
		boolean globalFlag = true;
		while (nextHead != null && nextHead.nextNode != null) {
			int count = 0;
			while (count < numberOfNodes - 1 && nextHead.nextNode != null) {
				nextHead = nextHead.nextNode;
				count++;
			}
			if (count + 1 != numberOfNodes) {
				break;
			}
			prePointer = nextHead;
			nextHead = nextHead.nextNode;
			prePointer.nextNode = null;
			preHead = reverse(preHead);
			if (globalFlag) {
				this.headNode = preHead;
				globalFlag = false;
			} else {
				preTail.nextNode = preHead;
			}
			while (preHead.nextNode != null) {
				preHead = preHead.nextNode;
			}
			preTail = preHead;
			preHead.nextNode = nextHead;
			preHead = nextHead;
		}
	}
}
