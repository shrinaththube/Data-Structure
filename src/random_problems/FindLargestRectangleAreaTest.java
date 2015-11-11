package random_problems;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindLargestRectangleAreaTest {

	@Test
	public void test1() {
		FindLargestRectangleArea obj= new FindLargestRectangleArea();
		int [] array = {1,2,3,4,5};
		int area = obj.largestArea(array);
		assertEquals(9, area);
		System.out.println("LArgest area = "+ area);
	}
	
	@Test
	public void test2() {
		FindLargestRectangleArea obj= new FindLargestRectangleArea();
		int [] array = {1,2,3,4,5,6};
		int area = obj.largestArea(array);
		assertEquals(12, area);
		System.out.println("LArgest area = "+ area);
	}
	
	@Test
	public void test3() {
		FindLargestRectangleArea obj= new FindLargestRectangleArea();
		int [] array = {3,5,10,1,2,7};
		int area = obj.largestArea(array);
		System.out.println("LArgest area = "+ area);
		assertEquals(10, area);
		
	}
	

}
