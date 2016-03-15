package objectOrientedProperties_Inheritance;

public class ShapesDriver {
	
	public static void main(String [] args){
		Square squareChessBoard = new Square(5);
		Rectangle rectangleBricks = new Rectangle(7, 5);
		
		squareChessBoard.area();
		squareChessBoard.display();
		rectangleBricks.area();
		rectangleBricks.display();
		
	}

}
