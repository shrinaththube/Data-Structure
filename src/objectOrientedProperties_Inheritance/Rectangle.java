package objectOrientedProperties_Inheritance;

public class Rectangle extends Shapes{

	private int lengthOfRectangle;
	private int widthOfRectangle;
	
	public Rectangle(int lengthOfRectangle, int widthOfRectangle){
		this.lengthOfRectangle = lengthOfRectangle;
		this.widthOfRectangle = widthOfRectangle;
	}
	
	@Override
	void area(){
		area = this.lengthOfRectangle * this.widthOfRectangle;
	}
}
