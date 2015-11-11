package random_problems;

import java.util.Stack;

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

	
	
	
	/**
	 * Reference : geekforgeek  - http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	 * @param hist
	 * @return maxArea
	 */
	public int largestArea2(int hist[]){

        int n = hist.length;
        
        
		// Create an empty stack. The stack holds indexes of hist[] array
		// The bars stored in stack are always in increasing order of their
		// heights.
		Stack<Integer> s = new Stack<Integer>();;

		int max_area = 0; // Initalize max area
		int tp;  // To store top of stack
		int area_with_top; // To store area with top bar as the smallest bar

		// Run through all bars of given histogram
		int i = 0;
		while (i < n)
		{
			// If this bar is higher than the bar on top stack, push it to stack
			if (s.empty() || hist[s.peek()] <= hist[i]){

				//System.out.println("pushing on stack : "+i);
				s.push(i++);

			}
			// If this bar is lower than top of stack, then calculate area of rectangle 
			// with stack top as the smallest (or minimum height) bar. 'i' is 
			// 'right index' for the top and element before top in stack is 'left index'
			else
			{
				tp = s.peek();  // store the top index
				s.pop();  // pop the top

				// Calculate the area with hist[tp] stack as smallest bar
				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

				// update max area, if needed
				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (s.empty() == false)
		{
			tp = s.peek();
			//System.out.println("tp : "+tp);
			//System.out.println("calc : "+(s.empty() ? i : i - s.peek() - 1));
			s.pop();
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);              // Not understood  logical reasoning behind this formula

			//System.out.println("area with top : "+area_with_top);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;

	}

}
