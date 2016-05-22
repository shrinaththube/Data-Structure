package sorting_algoritms;

public class SortDriver {

	//static Stopwatch timer;
	
		public static void main(String args[]){
			
			Sorting obj = new Sorting();
			
			int array[] = obj.readFile();
			int arrayForInsertionSort [] = obj.readFile(); 
		//	int arrayForMergeSort [] = obj.readFile();
			int arrayForMergeSort [] = {9,4,2,1,5};
			int arrayForQuickSort [] = {9,4,2,1,5};
			int output[] = new int[arrayForMergeSort.length];
			
			
			//Unsorted array - sort it by bubble sorting
			long startTime = System.nanoTime();
			obj.modified_Bubble_sort(array);
			long endTime = System.nanoTime();
			long duration = endTime - startTime;
		/*	obj.printArray(array,duration);
			
			//Sorted array to check modified bubble condition and compare the time requirement.
			startTime = System.nanoTime();
			obj.modified_Bubble_sort(array);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			obj.printArray(array,duration);
					
			
			//Unsorted array - sort it by Insertion sorting
			startTime = System.nanoTime();
			obj.insertionSort(arrayForInsertionSort);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			obj.printArray(arrayForInsertionSort,duration);
			*/
			//Unsorted array - sort it by Merge sorting
			startTime = System.nanoTime();
			//obj.mergeSort(arrayForMergeSort,output,0,output.length-1);
			obj.mergeSort(arrayForMergeSort);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			obj.printArray(arrayForMergeSort,duration);
			
			//Unsorted array - sort it by Merge sorting
			startTime = System.nanoTime();
			obj.quickSort(arrayForQuickSort,0,arrayForQuickSort.length-1);
			endTime = System.nanoTime();
			duration = endTime - startTime;
			obj.printArray(arrayForMergeSort,duration);
		}
	
	
}
