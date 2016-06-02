package stackQueue;

import java.util.Stack;

public class QueueUsingStack<T> {

	private Stack<T> iStack = new Stack<T>();
	private Stack<T> rStack = new Stack<T>();
	private int size;
	final int maxSize;
	
	public QueueUsingStack(int size){
		this.size = 0;
		maxSize =size;
	}
	
	public void insert(T element){
		if(this.size == maxSize)
		{
			System.out.println("Queue is full");
			return;
		}
		iStack.push(element);
		this.size++;
		
	}
	
	public T remove(){
		if(iStack.isEmpty() && rStack.isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}
		if(rStack.isEmpty()){
			while(!iStack.isEmpty()){
				rStack.push(iStack.pop());
			}
		}
		this.size--;
		return rStack.pop();
	}
	
}
