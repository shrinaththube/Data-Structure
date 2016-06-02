package stackQueue;

public class QueueDriver {
	
	public static void main(String[] args){
		QueueUsingStack que1 = new QueueUsingStack<Integer>(6);
		
		que1.insert(2);
		que1.insert(3);
		que1.insert(4);
		que1.insert(5);
		que1.insert(6);
	
		System.out.println(que1.remove());
		System.out.println(que1.remove());
		System.out.println(que1.remove());
		System.out.println(que1.remove());
		System.out.println(que1.remove());
		System.out.println(que1.remove());
		
	}

}
