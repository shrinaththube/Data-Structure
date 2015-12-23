package random_dataset_generator;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class RandomDataSet {

	public static void main(String args[]){

		//Take the name of data set from input
		System.out.print("Give name to data set = ");
		Scanner input = new Scanner(System.in);
		String fileName = "C:\\Users\\Shrinath\\Desktop\\tp\\"+ input.nextLine() + ".txt";
		
		System.out.println();
		
		System.out.print("Give the size of data set = ");
		while (!input.hasNextInt()) {
			   System.out.println("It should be integer");
			   input.nextLine();
			}
		int size = input.nextInt();
		System.out.println();
		System.out.print("Give range of data set with space between start and end for example- 1  10  = ");
		String[] range = input.nextLine().split(" ");
		while (range.length!=2) {
			   System.out.println("Somethig got wrong Try again");
			   range = input.nextLine().split(" ");
			}
		
		int start = Integer.parseInt(range[0]);
		int end = Integer.parseInt(range[1]);
		
		input.close();
		
		Random random = new Random();
		int rand_number;
		
		try {
			
			// Assume default encoding.
			FileWriter fileWriter = 
					new FileWriter(fileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter =
					new BufferedWriter(fileWriter);
			
			for(int i=0;i<size;i++){
				 rand_number = random.nextInt((end-start) + 1) + start;
				 System.out.println(rand_number);
				 //String tmp = rand_number.toString;
  				 bufferedWriter.write(String.valueOf(rand_number));
  				 bufferedWriter.newLine();
			}
			// Always close files.
			bufferedWriter.close();
		}
		catch(IOException ex) {
			System.out.println(
					"Error writing to file '"
							+ fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}
}
