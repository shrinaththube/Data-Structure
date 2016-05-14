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
		}
		
		while(trav2.nextNode != null){
			trav2 = trav2.nextNode;
		}
		
		trav2.nextNode = trav1;
	}
	
	
	
	
	
}
