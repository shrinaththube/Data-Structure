package objectOrientedProperties_Inheritance;

public class Square extends Shapes {
		
	private int sideOfSquare;
	
	public Square(int sideOfSquare){
		this.sideOfSquare = sideOfSquare;
	}
	
	@Override
	void area() {
		
		area = this.sideOfSquare * this.sideOfSquare;
	}

}
