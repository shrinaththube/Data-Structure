package bitwiseOperations;

public class BitProblem {
	
	public int countSetBit(int number){
		int count = 0;
		
		while(number>0){
			number = number & (number - 1);
			count++;
		}
		return count;
	}
}
