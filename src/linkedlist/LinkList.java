package linkedlist;


/**
 * @author Shrinath
 *
 *This class is about creating Linked List from given array. Sorting of Linked List by Bubble and Insertion.
 *Merging of sorted linked list in place and keep sorted while merging.
 *
 */
public class LinkList {
	public LinkListNode headNode;
	public LinkListNode prevNode;

	public static void main(String args[]){

		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();

		int[] array = {3,4,5,2,8,6,9,1};
		int[] array1 = {4,3,6,77,55,43,9,5};

		list1.createLinkList(array);
		list1.displayLinkList();
		//list1.sortLinkList_bubble();
		//list1.sortLinkList_Insertion();
		//list1.displayLinkList();
		
		
		list2.createLinkList(array1);
		list2.displayLinkList();
		//list2.sortLinkList_bubble();
		//list2.displayLinkList();
		
		list1.mergeSortedLinkList(list2);
		list1.displayLinkList();
		list1.sortLinkList_Insertion();
		//list1.sortLinkList_bubble();
		list1.displayLinkList();
	}

	//Creating LinkList from given array
	public  void createLinkList(int[] array){
		for(int i=0;i<array.length;i++){
			if(this.headNode==null){
				this.assignHead(array[i]);
			}
			else{
				this.addNode(array[i]);
			}
		}
	}

	//Assigning head node to LinkList
	public void assignHead(int value){
		if(this.headNode==null){
			this.headNode = new LinkListNode(value);
			this.prevNode = this.headNode;
		}
	}

	//Add node in the given 
	public void addNode(int value){
		if(this.headNode==null){
			this.assignHead(value);
		}
		else{
			LinkListNode newNode = new LinkListNode(value);
			this.prevNode.nextNode = newNode;
			this.prevNode = newNode;
		}
	}

	//Print the all LinkList
	public void displayLinkList(){
		LinkListNode printNode = this.headNode;
		while(printNode!=null){
			System.out.print(printNode.value + " -> ");
			printNode = printNode.nextNode;
		}
		System.out.print("null"+"\n");
	}

	//Bubble sorting of LinkList , time complexity O(n^2), space complexity O(1) int temp variable for swapping
	public void sortLinkList_bubble(){

		int temp;
		boolean flag = false;
		while(!flag){

			flag = true;
			LinkListNode first=this.headNode;
			LinkListNode second=this.headNode.nextNode;

			while(second!=null){

				if(first.value>second.value)
				{
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

	//Insertion sorting of Link List time complexity O(n^2), space complexity 0 -> in place sorting
	public void sortLinkList_Insertion(){
		if(this.headNode!=null){
			//sorted linkList
			LinkListNode prev_Node = this.headNode;
			LinkListNode next_Node = prev_Node.nextNode;

			//Unsorted LinkList
			LinkListNode new_list_head = this.headNode.nextNode;
			LinkListNode current_Node = new_list_head;

			prev_Node.nextNode = null;

			//loop will continue until all element of unsorted iterated
			while(new_list_head!=null){
				current_Node = new_list_head;
				new_list_head = new_list_head.nextNode;

				prev_Node = this.headNode;
				next_Node = prev_Node.nextNode;

				//finding appropriate position to insert current node in sorted LinkList
				while(prev_Node!=null){
					//current node is smallest element at that point
					if(current_Node.value<prev_Node.value){
						this.headNode = current_Node;
						current_Node.nextNode = prev_Node;
						break; //loop should not continue after inserting element
					}
					//current node is largest element at that point
					else if(prev_Node.value<current_Node.value && next_Node == null){
						prev_Node.nextNode = current_Node;
						current_Node.nextNode = null;
						break;//loop should not continue after inserting element
					}
					else if(prev_Node.value<=current_Node.value && current_Node.value<=next_Node.value){
						prev_Node.nextNode = current_Node;
						current_Node.nextNode = next_Node;
						break;//loop should not continue after inserting element
					}
					prev_Node = prev_Node.nextNode;
					next_Node = prev_Node.nextNode;
				}
			}
		}
		else{
			System.out.println("LinkedList is empty");
		}
	}

	public void mergeSortedLinkList( LinkList list2){
			
		LinkListNode ref_list1 = this.headNode;
		LinkListNode ref_list2 = list2.headNode;
		LinkListNode ref_merge_list=null;
		
		if(ref_list1==null && ref_list2!=null){
			this.headNode = ref_list2;
		}
		
		
		if(ref_list1!=null && ref_list2!=null){
			if(ref_list1.value<ref_list2.value){
				this.headNode= ref_list1;
				ref_merge_list = this.headNode;
				ref_list1 = ref_list1.nextNode;
				ref_merge_list.nextNode=null;
			}
			else{
				this.headNode= ref_list2;
				ref_merge_list = this.headNode;
				ref_list2 = ref_list2.nextNode;
				ref_merge_list.nextNode=null;
			}
		}
		
		while(ref_list1!=null && ref_list2!=null){
			if(ref_list1.value<ref_list2.value){
				ref_merge_list.nextNode = ref_list1;
				ref_merge_list = ref_merge_list.nextNode;
				ref_list1 = ref_list1.nextNode;
				ref_merge_list.nextNode=null;
			}
			else{
				ref_merge_list.nextNode = ref_list2;
				ref_merge_list = ref_merge_list.nextNode;
				ref_list2 = ref_list2.nextNode;
				ref_merge_list.nextNode=null;
			}
		}
		
		if(ref_list1!=null && ref_merge_list!=null){
			ref_merge_list.nextNode = ref_list1;
		}
		if(ref_list2!=null && ref_merge_list!=null){
			ref_merge_list.nextNode = ref_list2;
		}
	}
}
