package random_problems;

/**
 * @author Shrinath
 * --------Finding the Largest rectangle area---------
 * Input -- Array of heights of rectangles. Width of rectangle assuming fixed = 1
 * Return -- Area of largest rectangle formed by combining elements.
 */
public class FindLargestRectangleArea {

	public static void main(String args[]){
		//Test case
		FindLargestRectangleArea obj= new FindLargestRectangleArea();
		int [] array = {3,2,1,4,5};
		int area = obj.largestArea(array);
		System.out.println("LArgest area = "+ area);
	}

	//This method returns largest area of rectangle created by elements of array.
	public int largestArea(int[]array){

		int max_area=0;
		int window_size=0;
		int length_array= array.length;
		int area=0;

		// Loop will run up to window size less than array size
		while(window_size<=array.length){
			window_size+=1;
			//This loop move window by one element and calculate area of largest rectangle
			for(int j=0;j<=(length_array-window_size);j++){
				int min_element= array[j];
				//Finding the minimum element from window
				for(int k=j;k<(j+window_size);k++){
					if(min_element>array[k]){
						min_element = array[k];
					}
				}
				//Calculating area of largest rectangle from window 
				area = min_element*window_size;
				//Assigning max_area if window rectangle area is larger than max_area
				if(max_area<area){
					max_area=area;
				}
			}
		}
		return max_area;
	}

}
