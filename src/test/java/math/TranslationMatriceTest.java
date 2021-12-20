package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrice;

/**
 * The Class TranslationMatriceTest.
 */
class TranslationMatriceTest {

	/**
	 * Translate right test.
	 */
	@Test
	void translateRightTest() {
		Matrice matrice1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		Matrice mtrans = new Matrice(1,1);
		mtrans.add(0, 1.0, 0, 0);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(1.0, 2.0, 1.0, 1.0);
		res.add(2.0, 3.0, 2.0, 2.0);
		res.add(3.0, 4.0, 3.0, 3.0);
		res.add(4.0, 5.0, 4.0, 4.0);
		
		Translation translation = new Translation(matrice1);
		translation.translate(mtrans);
		matrice1 = translation.getMcourante();
		assertEquals(res.toString(), matrice1.toString());
	}
	
	/**
	 * Translate left test.
	 */
	@Test
	void translateLeftTest() {
		Matrice matrice1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		Matrice mtrans = new Matrice(1,1);
		mtrans.add(0, -1.0, 0, 0);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(1.0, 0.0, 1.0, 1.0);
		res.add(2.0, 1.0, 2.0, 2.0);
		res.add(3.0, 2.0, 3.0, 3.0);
		res.add(4.0, 3.0, 4.0, 4.0);
		
		
		Translation translation = new Translation(matrice1);
		translation.translate(mtrans);
		matrice1 = translation.getMcourante();
		assertEquals(res.toString(), matrice1.toString());
	}
	
	/**
	 * Translate down test.
	 */
	@Test
	void translateDownTest() {
		Matrice matrice1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		Matrice mtrans = new Matrice(1,1);
		mtrans.add(-1.0, 0, 0, 0);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(0.0, 1.0, 1.0, 1.0);
		res.add(1.0, 2.0, 2.0, 2.0);
		res.add(2.0, 3.0, 3.0, 3.0);
		res.add(3.0, 4.0, 4.0, 4.0);
		
		Translation translation = new Translation(matrice1);
		translation.translate(mtrans);
		matrice1 = translation.getMcourante();
		assertEquals(res.toString(), matrice1.toString());
	}
	
	/**
	 * Translate top test.
	 */
	@Test
	void translateTopTest() {
		Matrice matrice1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		Matrice mtrans = new Matrice(1,1);
		mtrans.add(1.0, 0, 0, 0);
		
		matrice1.add(1.0, 1.0, 1.0, 1.0);
		matrice1.add(2.0, 2.0, 2.0, 2.0);
		matrice1.add(3.0, 3.0, 3.0, 3.0);
		matrice1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(2.0, 1.0, 1.0, 1.0);
		res.add(3.0, 2.0, 2.0, 2.0);
		res.add(4.0, 3.0, 3.0, 3.0);
		res.add(5.0, 4.0, 4.0, 4.0);
		
		Translation translation = new Translation(matrice1);
		translation.translate(mtrans);
		matrice1 = translation.getMcourante();
		assertEquals(res.toString(), matrice1.toString());
	}

}
