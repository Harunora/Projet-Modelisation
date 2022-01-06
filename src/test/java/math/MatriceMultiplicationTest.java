package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrix;
import rotation.Mouvement;
import rotation.RotationUp;

/**
 * The Class MatriceMultiplicationTest.
 */
class MatriceMultiplicationTest {

	/**
	 * Simpletest.
	 */
	@Test
	void simpletest() {
		Matrix matrice1 = new Matrix(4,4);
		Matrix matrice2 = new Matrix(4,4);
		Matrix res = new Matrix(4,4);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		
		matrice2.add(1.0, 0.0, 1.0, 0.0);
		matrice2.add(0.0, 1.0, 0.0, 0.0);
		matrice2.add(0.0, 0.0, 1.0, 0.0);
		matrice2.add(0.0, 1.0, 0.0, 1.0);
		
		res.add(1.0, 2.0, 2.0, 1.0);
		res.add(2.0, 4.0, 4.0, 2.0);
		res.add(3.0, 6.0, 6.0, 3.0);
		res.add(4.0, 8.0, 8.0, 4.0);
		
		Mouvement rotation1 = new RotationUp(matrice1 , null);
		Matrix sol = rotation1.multipliMatrix(matrice2);
		assertEquals(sol.toString() , res.toString());	
	}
	
	/**
	 * Difftailletest.
	 */
	@Test
	void diffTailleTest() {
		Matrix matrice1 = new Matrix(6,4);
		Matrix matrice2 = new Matrix(4,4);
		Matrix res = new Matrix(6,4);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		matrice1.add(5.0, 5.0, 5.0, 5.0);
		matrice1.add(6.0, 6.0, 6.0, 6.0);
		
		matrice2.add(1.0, 0.0, 1.0, 0.0);
		matrice2.add(0.0, 1.0, 0.0, 0.0);
		matrice2.add(0.0, 0.0, 1.0, 0.0);
		matrice2.add(0.0, 1.0, 0.0, 1.0);
		
		res.add(1.0, 2.0, 2.0, 1.0);
		res.add(2.0, 4.0, 4.0, 2.0);
		res.add(3.0, 6.0, 6.0, 3.0);
		res.add(4.0, 8.0, 8.0, 4.0);
		res.add(5.0, 10.0, 10.0, 5.0);
		res.add(6.0, 12.0, 12.0, 6.0);
		
		Mouvement rotation1 = new RotationUp(matrice1, null);
		Matrix sol = rotation1.multipliMatrix(matrice2);
		
		assertEquals(sol.toString() , res.toString());	
	}
	
	/**
	 * Complexetest.
	 */
	@Test
	void complexetest() {
		Matrix matrice1 = new Matrix(7,4);
		Matrix matrice2 = new Matrix(4,4);
		Matrix res = new Matrix(7,4);
		
		matrice1.add(12.0, 1.0, 20.0, 1.0);
		matrice1.add(3.0, 6.0, 12.0, 1.0);
		matrice1.add(4.0, 4.0, 13.0, 1.0);
		matrice1.add(5.0, 3.0, 46.0, 1.0);
		matrice1.add(10.0, 7.0, 53.0, 1.0);
		matrice1.add(7.0, 2.0, 2.0, 1.0);
		matrice1.add(2.0, 5.0, 1.0, 1.0);
		
		matrice2.add(1.0, 0.0, 0.0, 0.0);
		matrice2.add(0.0, 0.5, 2.0, 0.0);
		matrice2.add(0.0, 2.0, 0.5, 0.0);
		matrice2.add(0.0, 0.0, 0.0, 1.0);
		
		res.add(12.0, 40.5, 12.0, 1.0);
		res.add(3.0, 27.0, 18.0, 1.0);
		res.add(4.0, 28.0, 14.5, 1.0);
		res.add(5.0, 93.5, 29.0, 1.0);
		res.add(10.0, 109.5, 40.5, 1.0);
		res.add(7.0, 5.0, 5.0, 1.0);
		res.add(2.0, 4.5, 10.5, 1.0);
		
		Mouvement rotation1 = new RotationUp(matrice1, null);
		Matrix sol = rotation1.multipliMatrix(matrice2);
		assertEquals(sol.toString() , res.toString());	
	}
	
	/**
	 * Two mulitplytest.
	 */
	@Test
	void twoMulitplytest() {
		Matrix matrice1 = new Matrix(4,4);
		Matrix matrice2 = new Matrix(4,4);
		Matrix res = new Matrix(4,4);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		
		matrice2.add(1.0, 0.0, 1.0, 0.0);
		matrice2.add(0.0, 1.0, 0.0, 0.0);
		matrice2.add(0.0, 0.0, 1.0, 0.0);
		matrice2.add(0.0, 1.0, 0.0, 1.0);
		
		res.add(1.0, 2.0, 2.0, 1.0);
		res.add(2.0, 4.0, 4.0, 2.0);
		res.add(3.0, 6.0, 6.0, 3.0);
		res.add(4.0, 8.0, 8.0, 4.0);
		
		Mouvement rotation1 = new RotationUp(matrice1 , null);
		Matrix sol = rotation1.multipliMatrix(matrice2);
		assertEquals(sol.toString() , res.toString());	
		
		Matrix res2 = new Matrix(4,4);
		Matrix matrice3 = new Matrix(4,4);
		
		matrice3.add(1.0, 0.0, 0.0, 1.0);
		matrice3.add(0.0, 1.0, 1.0, 0.0);
		matrice3.add(0.0, 1.0, 1.0, 0.0);
		matrice3.add(1.0, 0.0, 0.0, 1.0);
		
		res2.add(2.0, 4.0, 4.0, 2.0);
		res2.add(4.0, 8.0, 8.0, 4.0);
		res2.add(6.0, 12.0, 12.0, 6.0);
		res2.add(8.0, 16.0, 16.0, 8.0);
	
		sol = rotation1.multipliMatrix(matrice3);
		assertEquals(sol.toString() , res2.toString());	
		
	}
	

}
