package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrice;
import graph.Translation;

class TranslationMatriceTest {

	@Test
	void TranslateRightTest() {
		Matrice m1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(1.0, 2.0, 1.0, 1.0);
		res.add(2.0, 3.0, 2.0, 2.0);
		res.add(3.0, 4.0, 3.0, 3.0);
		res.add(4.0, 5.0, 4.0, 4.0);
		
		Translation translation = new Translation(m1, 0, 1);
		Matrice sol = translation.translate();
		assertEquals(res.toString(), sol.toString());
	}
	
	@Test
	void TranslateLeftTest() {
		Matrice m1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(1.0, 0.0, 1.0, 1.0);
		res.add(2.0, 1.0, 2.0, 2.0);
		res.add(3.0, 2.0, 3.0, 3.0);
		res.add(4.0, 3.0, 4.0, 4.0);
		
		Translation translation = new Translation(m1, 0, -1);
		Matrice sol = translation.translate();
		assertEquals(res.toString(), sol.toString());
	}
	
	@Test
	void TranslateDownTest() {
		Matrice m1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(0.0, 1.0, 1.0, 1.0);
		res.add(1.0, 2.0, 2.0, 2.0);
		res.add(2.0, 3.0, 3.0, 3.0);
		res.add(3.0, 4.0, 4.0, 4.0);
		
		Translation translation = new Translation(m1, -1, 0);
		Matrice sol = translation.translate();
		assertEquals(res.toString(), sol.toString());
	}
	
	@Test
	void TranslateTopTest() {
		Matrice m1 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		
		res.add(2.0, 1.0, 1.0, 1.0);
		res.add(3.0, 2.0, 2.0, 2.0);
		res.add(4.0, 3.0, 3.0, 3.0);
		res.add(5.0, 4.0, 4.0, 4.0);
		
		Translation translation = new Translation(m1, 1, 0);
		Matrice sol = translation.translate();
		assertEquals(res.toString(), sol.toString());
	}

}
