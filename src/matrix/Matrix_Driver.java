package matrix;

/***
 * Driver class to check all method of class Matrix2D_Rotate All methods which
 * are doing operations on square matrix do changes on original matrix and do
 * not return anything. But all methods which perform operations on mismatch
 * matrix return another matrix as it can not rotate original matrix due to
 * having different length and width.
 * 
 */
public class Matrix_Driver {
	
	public static void main(String[] args) {
		
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 0, 1, 2 }, { 3, 4, 5, 6 } };
		int[][] mixMatchMat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 0, 1, 2 }, { 3, 4, 5, 6 }, { 4, 5, 6, 7 } };

		Matrix2D_Rotate obj = new Matrix2D_Rotate();

		System.out.println("Original Square matrix");
		obj.display(mat);

		// Rotate square matrix
		System.out.println("Rotated left matrix");
		obj.rotateMinus90(mat);
		obj.display(mat);

		// Rotate right
		System.out.println("Rotated right matrix");
		obj.rotatePlus90(mat);
		obj.display(mat);

		// rotate 180
		System.out.println("Rotated 180");
		obj.rotate180(mat);
		obj.display(mat);

		System.out.println("Original Mismatch matrix");
		obj.display(mixMatchMat);

		// rotate right
		System.out.println("Rotated right matrix");
		obj.display(obj.rotateRightMismatchMat(mixMatchMat));

		// rotate left
		System.out.println("Rotated left matrix");
		obj.display(obj.rotateLeftMismatchMat(mixMatchMat));

		// rotate 180
		System.out.println("Rotated by 180 matrix");
		obj.display(obj.rotateMismatchMat180(mixMatchMat));

	}
}
