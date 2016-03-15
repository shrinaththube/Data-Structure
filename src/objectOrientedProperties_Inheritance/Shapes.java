package objectOrientedProperties_Inheritance;

public abstract class Shapes {
	protected int area;
	
	abstract void area();
	
	public void display(){
		System.out.print("Area ="+area);
	}
}
