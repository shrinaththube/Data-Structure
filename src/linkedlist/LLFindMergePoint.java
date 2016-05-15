package linkedlist;

public class LLFindMergePoint extends LinkList{


	/***
	 *  This method created merge LL for testing finding merge point method
	 * @param head1 head of first linked list 
	 * @param head2 head of second linked list
	 * @param position position of node from first LL where merge the second LL
	 */
	public void createMergePoint(LinkListNode head1, LinkListNode head2, int position){
		if(head1 == null || head2 == null){
			System.out.println("Linked list is not formed yet");
			return;
		}
		LinkListNode trav1 = head1;
		LinkListNode trav2 = head2;
		
		int i=1;
		while(i<position && trav1.nextNode != null ){
			trav1 = trav1.nextNode;
			i++;
		}
		
		while(trav2.nextNode != null){
			trav2 = trav2.nextNode;
		}
		
		trav2.nextNode = trav1;
	}
	
	
	/***
	 *  This find intersection point of LL
	 * @param head1 LL1 head
	 * @param head2 LL2 head
	 * @return returns intersection node if present or null if not
	 */
	public LinkListNode mergePointLL(LinkListNode head1,LinkListNode head2){
		if(head1 == null || head2 == null){
			System.out.println("Linked list is not formed yet");
			return null;
		}
		LinkListNode trav1 = head1;
		LinkListNode trav2 = head2;
		
		int count1 = 1;
		int count2 = 1;
		
		while(trav1.nextNode !=null){
			count1++;
			trav1 = trav1.nextNode;
		}
		
		while(trav2.nextNode !=null){
			count2++;
			trav2 = trav2.nextNode;
		}
		
		trav1 = head1;
		trav2 = head2;
		
		if(count1>count2){
			for(int i=0;i<count1-count2;i++)
				trav1 = trav1.nextNode;
		}
		else{
			for(int i=0;i<count2-count1;i++)
				trav2 = trav2.nextNode;
		}
		
		while(trav1.nextNode !=null){
			if(trav1.equals(trav2))
				return trav1;
			
			trav1 = trav1.nextNode;
			trav2 = trav2.nextNode;
		}
		
		return null;
	}
	
	
	/***
	 *  This method print the intersected part of two linked list if present
	 * @param head1 LL1 head
	 * @param head2 LL2 head 
	 */
	public void printCommonIntersectionOfLL(LinkListNode head1, LinkListNode head2){
		if(head1 == null || head2 == null){
			System.out.println("Linked list is not formed yet");
			return;
		}
		
		LinkListNode iHead = mergePointLL(head1,head2);
		System.out.print("Intersection of two Linked List - ");
		this.displayLinkList(iHead);
		
	}
	
	
}
