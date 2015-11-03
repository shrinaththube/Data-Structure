package linkedlist;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LinkListTest {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	public boolean compairLinkedList_Array(int array[],LinkList list){
		
		boolean flag = false;
		LinkListNode scan_LinkedList = list.headNode;
		for(int i=0;i<array.length;i++){
			if(scan_LinkedList.value!=array[i]){
				flag = true;
				break;
			}
			scan_LinkedList=scan_LinkedList.nextNode;
		}

		return flag;
		
	}

	@Test
	public void test1(){

		LinkList list = new LinkList();
        int array[]={20,3,15,6};
		list.createLinkList(array);
		list.sortLinkList_Insertion();
		Arrays.sort(array);
		
		boolean flag = compairLinkedList_Array(array, list);

		assertFalse(flag);
		System.out.print("test1 -> ");
		list.displayLinkList();
	}

	@Test
	public void test2(){

		LinkList list = new LinkList();
        int array[]={3,5,1,2,7,9,6};
		list.createLinkList(array);
		list.sortLinkList_Insertion();
		Arrays.sort(array);
		
		boolean flag = compairLinkedList_Array(array, list);

		assertFalse(flag);
		System.out.print("test2 -> ");
		list.displayLinkList();
	}

	@Test
	public void test3(){

		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();
        int array1[]={6,4,9,7,8,3,1,2};
        int array2[]={4};
		int array3[]={6,4,9,7,8,3,1,2,4};
        list1.createLinkList(array1);
		list1.sortLinkList_Insertion();
		
		list2.createLinkList(array2);
		list2.sortLinkList_Insertion();
		Arrays.sort(array2);
		Arrays.sort(array3);
		list1.mergeSortedLinkList(list2);
		boolean flag = compairLinkedList_Array(array3, list1);
		
		assertFalse(flag);
		System.out.print("test3 -> ");
		list1.displayLinkList();
	}
}
