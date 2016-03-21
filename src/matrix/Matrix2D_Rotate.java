package matrix;

public class Matrix2D_Rotate {

	// Display matrix
	public void display(int mat[][]) {
		System.out.println();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// Rotate square matrix to left by 90
	public void rotateMinus90(int[][] mat) {
		int row = mat.length;
		int column = mat[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = i; j < column; j++) {
				if (i != j) {
					int temp = mat[i][j];
					mat[i][j] = mat[j][i];
					mat[j][i] = temp;
				}
			}
		}
		// rotate square matrix to left by changing row
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < column; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[row - i - 1][j];
				mat[row - i - 1][j] = temp;
			}
		}

	}

	// rotate square matrix to right by 90
	public void rotatePlus90(int mat[][]) {
		int row = mat.length;
		int column = mat[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = i; j < column; j++) {
				if (i != j) {
					int temp = mat[i][j];
					mat[i][j] = mat[j][i];
					mat[j][i] = temp;
				}
			}
		}
		// rotate right by changing column
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column / 2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][column - j - 1];
				mat[i][column - j - 1] = temp;
			}
		}
	}

	// rotate square or mismatch matrix by 180
	public void rotate180(int[][] mat) {
		int row = mat.length;
		int column = mat[0].length;

		// rotate right by changing column
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column / 2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][column - j - 1];
				mat[i][column - j - 1] = temp;
			}
		}
		// rotate left by changing row
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < column; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[row - i - 1][j];
				mat[row - i - 1][j] = temp;
			}
		}
	}

	// This will rotate left by touching element only once
	public void rotateLeft90(int[][] mat) {

		int n = mat.length;
		int tmp;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				tmp = mat[i][j];
				mat[i][j] = mat[j][n - i - 1];
				mat[j][n - i - 1] = mat[n - i - 1][n - j - 1];
				mat[n - i - 1][n - j - 1] = mat[n - j - 1][i];
				mat[n - j - 1][i] = tmp;
			}
		}

	}

	// This is for different m and n i.e. row and column. If matrix is not
	// square matrix.
	public int[][] rotateLeftMismatchMat(int[][] mat) {

		int row = mat.length;
		int column = mat[0].length;
		int retRow = column;
		int retCol = row;
		int[][] ret = new int[column][row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				ret[j][i] = mat[i][j];
			}
		}

		// rotate left by changing row
		for (int i = 0; i < retRow / 2; i++) {
			for (int j = 0; j < retCol; j++) {
				int temp = ret[i][j];
				ret[i][j] = ret[retRow - i - 1][j];
				ret[retRow - i - 1][j] = temp;
			}
		}

		return ret;
	}

	// THis is for different m and n . If matrix is not square matrix.
	public int[][] rotateRightMismatchMat(int[][] mat) {

		int row = mat.length;
		int column = mat[0].length;
		int retRow = column;
		int retCol = row;
		int[][] ret = new int[column][row];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				ret[j][i] = mat[i][j];
			}
		}

		// rotate right by changing column
		for (int i = 0; i < retRow; i++) {
			for (int j = 0; j < retCol / 2; j++) {
				int temp = ret[i][j];
				ret[i][j] = ret[i][retCol - j - 1];
				ret[i][retCol - j - 1] = temp;
			}
		}

		return ret;
	}

	// THis is for different m and n . If matrix is not square matrix.
	public int[][] rotateMismatchMat180(int[][] mat) {

		int row = mat.length;
		int column = mat[0].length;

		// rotate right by changing column
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column / 2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][column - j - 1];
				mat[i][column - j - 1] = temp;
			}
		}

		// rotate left by changing row
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < column; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[row - i - 1][j];
				mat[row - i - 1][j] = temp;
			}
		}
		return mat;
	}
}
