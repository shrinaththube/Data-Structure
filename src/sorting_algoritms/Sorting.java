package sorting_algoritms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.rules.Stopwatch;

/**
 * @author Shrinath
 *
 */
public class Sorting {

		
	public void modified_Bubble_sort(int [] array){
		//Flag will check is their any swapping in first iteration of bubble sort
		boolean flag = true;
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1;j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if(flag){ break; }
		}
	}
	
	
	
	
	
	/***
	 * ******************************* Merge Sort ***************************************
	 * Recursive function divides array into left and right till get single element and in merge function merge it 
	 * by comparing element value in ascending order
	 * 
	 * @param array that caller wants to sort
	 */
	public void mergeSort(int array[]){
		int length = array.length;
		if(length<2)
			return;
		int mid = length/2;
		int[] left = new int[mid];
		int[] right = new int[length-mid];
		for(int i=0;i<mid;i++){
			left[i] = array[i];
		}
		for(int j=mid;j<length;j++)
		{
			right[j-mid] = array[j];
		}
		mergeSort(left);
		mergeSort(right);
		merge(array,left,right);
	}

	public void merge(int[] array,int[] left,int[] right)
	{
		int lLeft = left.length;
		int lRight = right.length;
		int i=0,j=0,k=0;
		while(i<lLeft && j<lRight)
		{
			if(left[i]<right[j])
			{
				array[k]=left[i];
				i++;
				k++;
			}
			else{
				array[k]=right[j];
				j++;
				k++;
			}
		}
		
		while(i<lLeft)
		{
			array[k]=left[i];
			i++;
			k++;
		}
		while(j<lRight)
		{
			array[k]=right[j];
			j++;
			k++;
		}
	}
	
	/***
	 * ************* Quick Sort ****************************************
	 * Divide the array in two part on pivotal postion
	 * @param array that want to sort
	 * @param low lower index of array
	 * @param high higher index of array
	 */
	public void quickSort(int array[],int low , int high)
	{
		int partIndex;
		if(low>high)
			return;
		partIndex = partition(array, low, high);
		quickSort(array,low, partIndex -1 );
		quickSort(array,partIndex+1, high);
		
	}
	
	public int partition(int[] array,int low,int high){
		int pivot = array[0];
		int i=low,j=high;
		while(i<j)
		{
			while(array[i]<pivot)
				i++;
			while(array[j]>pivot)
				j--;
			if(i<j)
			{
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[low] = array[j];
		array[j] = pivot;
		return j;
	}
	
	/***
	 * Insertion Sorting - insert element at appropriate position.
	 * @param array it is given by user
	 * @param i loop variable starts from 1 not from 0 up to length of array. It picks the element which we want to insert in left part of array. 
	 * @param element It keep the value of element that we want to sort
	 * @param position It maintains the index where element should be insert.
	 * @param j inner loop variable starts from i-1 and scan backward up to 0'th position.
	 * 
	 */
	public void insertionSort(int array[])
	{
		for(int i=1;i<array.length; i++){
			int element = array[i];
			int position = i;  
			
			for(int j=i-1;j>-1;j--){
				if(array[j]< element){
					break;
				}
				else{
					array[j+1] = array[j];
					position = j;
				}
			}
			
			array[position] = element;
		}
	}
	
	/***
	 * ****************** Display any array ******************************
	 * @param array that caller wants to display
	 * @param execution_time time that required to perform sorting operation
	 */
	public void printArray(int[] array,long execution_time){
		System.out.print("Array = ");
		for(int i=0;i<array.length;i++){ System.out.println(array[i]+" ");}
		System.out.print(" Execution time = "+execution_time+ " ns");
		System.out.println();
	}
	
	
	/***
	 * ****************** Reading file *********************************************
	 * This method read the given text file and makes an array to give input to sorting function
	 * @return returns the populated array.
	 */
	public int[] readFile(){
		        // The name of the file to open.
		        //String fileName = "C:\\Users\\Shrinath\\Desktop\\temp.txt";
		        
				String fileName = "C:\\Users\\Shrinath\\Desktop\\tp\\Sorting\\hgkjflgkdjd.txt";
		 
		        // This will reference one line at a time
		        String line = null;
		        
		       // ArrayList<Integer> array = new ArrayList<>();
		        int [] array = new int[10000];
		        int i =0;
		        try {
		            // FileReader reads text files in the default encoding.
		            FileReader fileReader = 
		                new FileReader(fileName);

		            // Always wrap FileReader in BufferedReader.
		            BufferedReader bufferedReader = 
		                new BufferedReader(fileReader);

		            while((line = bufferedReader.readLine()) != null) {
		                //System.out.println(line);
		            	array[i] = Integer.parseInt(line);
		            	i++;
		            }   
		            

		            // Always close files.
		            bufferedReader.close();         
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println(
		                "Unable to open file '" + 
		                fileName + "'");                
		        }
		        catch(IOException ex) {
		            System.out.println(
		                "Error reading file '" 
		                + fileName + "'");                  
		            // Or we could just do this: 
		            // ex.printStackTrace();
		        }
		        return array;
	}
	
}
