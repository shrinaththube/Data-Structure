package bitwiseOperations;

public class BitProblem {
	
	/***
	 * ***** Find the number of set bits in an interger ******
	 * @param number find the number of one in this integer
	 * @return count of number of one
	 */
	public int countSetBit(int number){
		int count = 0;
		
		while(number>0){
			number = number & (number - 1);
			count++;
		}
		return count;
	}
}
