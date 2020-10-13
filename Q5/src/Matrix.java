public class Matrix {
	private int row;
	private int column;
	private int[][] elements;

	public Matrix(int row, int column) {
		//TODO
		this.row = row;
		this.column = column;
		elements = new int[row][column];
	}
	
	public Matrix(int length){
		//TODO
		this.row = length;
		this.column = length;
		elements = new int[length][length];
	}
	
	public Matrix(int[][] elements){
		//TODO
		this.elements = elements;
		this.row = elements.length;
		this.column = elements[0].length;
	}
	
	public int getRow() {
		//TODO
		return row;
	}

	public int getColumn() {
		//TODO
		return column;
	}

	public int[][] getElements() {
		//TODO
		return elements;
	}

	public boolean add(Matrix newMatrix) {
		//TODO
		if (newMatrix.getRow() == row && newMatrix.getColumn() == column) {
			int[][] newElements = newMatrix.getElements();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					elements[i][j] += newElements[i][j];
				}
			}
			return true;
		}
		return false;
	}
	
	public void setElement(int i, int j, int value){
		//TODO
		elements[i][j] = value;
	}

	public boolean isSquareMatrix() {
		//TODO
		if (row == column) {
			return true;
		}
		return false;
	}

	public void toLowerTriangular() {
		//TODO
		if (this.isSquareMatrix()) {
			for (int i = 0; i < row; i++) {
				for (int j = i + 1; j < row; j++) {
					elements[i][j] = 0;
				}
			}
		}
	}

	public void toUpperTriangular() {
		//TODO
		if (this.isSquareMatrix()) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < i; j++) {
					elements[i][j] = 0;
				}
			}
		}
	}

//	public static void main(String[] args) {
//		int[][] mat = new int[5][5];
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				mat[i][j] = i * j;
//			}
//		}
//		Matrix matrix = new Matrix(mat);
//		for (int i = 0; i < matrix.getRow(); i++) {
//			for (int j = 0; j < matrix.getColumn(); j++) {
//				System.out.print(matrix.getElements()[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println(matrix.getRow());
//		System.out.println(matrix.getColumn());
//		System.out.println(matrix.isSquareMatrix());
//		matrix.toLowerTriangular();
//		for (int i = 0; i < matrix.getRow(); i++) {
//			for (int j = 0; j < matrix.getColumn(); j++) {
//				System.out.print(matrix.getElements()[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}
