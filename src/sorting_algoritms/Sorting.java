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

	//static Stopwatch timer;
	
	public static void main(String args[]){
		
		Sorting obj = new Sorting();
		
		int array[] = obj.readFile();
		int arrayForInsertionSort [] = obj.readFile(); 
		
		//Unsorted array - sort it by bubble sorting
		long startTime = System.nanoTime();
		obj.modified_Bubble_sort(array);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		obj.printArray(array,duration);
		
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
	}
	
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
	
	
	public void printArray(int[] array,long execution_time){
		System.out.print("Array = ");
		for(int i=0;i<array.length;i++){ System.out.println(array[i]+" ");}
		System.out.print(" Execution time = "+execution_time+ " ns");
		System.out.println();
	}
	
	public int[] readFile(){
		        // The name of the file to open.
		        //String fileName = "C:\\Users\\Shrinath\\Desktop\\temp.txt";
		        
				String fileName = "C:\\Users\\Shrinath\\Desktop\\tp\\hgkjflgkdjd.txt";
		 
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
