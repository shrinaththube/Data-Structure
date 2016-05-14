package linkedlist;

public class DriveClassLinkedList {

	public static void main(String[] args){
		int [] arr1 = {3,2,4,1,5,6,8,9,7};
		LinkedListProblems list1 = new LinkedListProblems();
		
		//Create linked list
		list1.createLinkList(arr1);
		//checking if loop present or not if not then display Linked List
		if(!list1.isLoop()) 
			list1.displayLinkList();
		
		// Find the start point of loop... if loop is not present then print null
		System.out.print("Start point of loop - ");
		System.out.println(list1.findLoopPoint(list1.headNode));
		
		
		//inserting loop in Linked list
		list1.insertLoopInLL(list1.headNode,5);
		//checking loop is present or not
		list1.isLoop();
		//Print the start node of loop if present
		System.out.print("Start point of loop - ");
		System.out.println(list1.findLoopPoint(list1.headNode).value);
		
		//Print number of nodes in loop
		System.out.print("Node count loop - ");
		System.out.println(list1.loopNodeCount(list1.headNode));
		
		
	}
	
}
