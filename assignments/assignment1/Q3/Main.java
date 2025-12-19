package assignment1.Q3;

import java.util.*;

public class Main{
	// addition
	public static int[][] add ( int[][] mat1, int[][] mat2){
		int rows = mat1.length;
		int cols = mat1[0].length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
		result[i][j] = mat1[i][j] + mat2[i][j];
		return result;
	}

	// subtraction
	public static int[][] subtract ( int[][] mat1, int[][] mat2){
		int rows = mat1.length;
		int cols = mat1[0].length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
		result[i][j] = mat1[i][j] - mat2[i][j];
		return result;
	}

	// multiplication
	public static int[][] multiply ( int[][] mat1, int[][] mat2){
		int rows = mat1.length;
		int cols = mat2[0].length;
		int common = mat2.length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
		for (int k = 0; k < common; k++)
		result[i][j] += mat1[i][k] * mat2[k][j];
		return result;
	}

	// transpose
	public static int[][] transpose ( int[][] mat){
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] result = new int[cols][rows];
		for (int i = 0; i < rows; i++)
		for (int j = 0; j < cols; j++)
		result[j][i] = mat[i][j];
		return result;
	}

	// check square matrix
	public static boolean isSquare ( int[][] mat){
		return mat.length == mat[0].length;
	}

	// check diagonal matrix
	public static boolean isDiagonal ( int[][] mat){
		if (!isSquare(mat)) return false;
		int n = mat.length;
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		if (i != j && mat[i][j] != 0)
		return false;
		return true;
	}

	// check identity matrix
	public static boolean isIdentity ( int[][] mat){
		if (!isSquare(mat)) return false;
		int n = mat.length;
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		if (i == j && mat[i][j] != 1 || i != j && mat[i][j] != 0)
		return false;
		return true;
	}

	//main method
	public static void main(String[] args) {
		int[][] mat1 = {
		{1, 2, 3},
		{0, 1, 4},
		{5, 6, 0}
		};

		int[][] mat2 = {
		{7, 8, 9},
		{1, 0, 2},
		{3, 4, 5}
		};

		System.out.println("Addition:");
		int[][] addResult = add(mat1, mat2);
		for (int[] row : addResult) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println("Subtraction:");
		int[][] subResult = subtract(mat1, mat2);
		for (int[] row : subResult) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println("Multiplication:");
		int[][] mulResult = multiply(mat1, mat2);
		for (int[] row : mulResult) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println("Transpose of mat1:");
		int[][] transResult = transpose(mat1);
		for (int[] row : transResult) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println("Is mat1 square? " + isSquare(mat1));
		System.out.println("Is mat1 diagonal? " + isDiagonal(mat1));
		System.out.println("Is mat1 identity? " + isIdentity(mat1));
	}
}
