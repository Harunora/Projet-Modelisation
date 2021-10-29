package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrice;
import graph.Rotation;
import graph.RotationUp;

class MatriceMultiplicationTest {

	@Test
	void Simpletest() {
		Matrice m1 = new Matrice(4,4);
		Matrice m2 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		
		m2.add(1.0, 0.0, 1.0, 0.0);
		m2.add(0.0, 1.0, 0.0, 0.0);
		m2.add(0.0, 0.0, 1.0, 0.0);
		m2.add(0.0, 1.0, 0.0, 1.0);
		
		res.add(1.0, 2.0, 2.0, 1.0);
		res.add(2.0, 4.0, 4.0, 2.0);
		res.add(3.0, 6.0, 6.0, 3.0);
		res.add(4.0, 8.0, 8.0, 4.0);
		
		Rotation r1 = new RotationUp(m1 , null);
		Matrice sol = r1.multipliMatrice(m2);
		assertEquals(sol.toString() , res.toString());	
	}
	
	@Test
	void Difftailletest() {
		Matrice m1 = new Matrice(6,4);
		Matrice m2 = new Matrice(4,4);
		Matrice res = new Matrice(6,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		m1.add(5.0, 5.0, 5.0, 5.0);
		m1.add(6.0, 6.0, 6.0, 6.0);
		
		m2.add(1.0, 0.0, 1.0, 0.0);
		m2.add(0.0, 1.0, 0.0, 0.0);
		m2.add(0.0, 0.0, 1.0, 0.0);
		m2.add(0.0, 1.0, 0.0, 1.0);
		
		res.add(1.0, 2.0, 2.0, 1.0);
		res.add(2.0, 4.0, 4.0, 2.0);
		res.add(3.0, 6.0, 6.0, 3.0);
		res.add(4.0, 8.0, 8.0, 4.0);
		res.add(5.0, 10.0, 10.0, 5.0);
		res.add(6.0, 12.0, 12.0, 6.0);
		
		Rotation r1 = new RotationUp(m1, null);
		Matrice sol = r1.multipliMatrice(m2);
		
		assertEquals(sol.toString() , res.toString());	
	}
	
	@Test
	void Complexetest() {
		Matrice m1 = new Matrice(7,4);
		Matrice m2 = new Matrice(4,4);
		Matrice res = new Matrice(7,4);
		
		m1.add(12.0, 1.0, 20.0, 1.0);
		m1.add(3.0, 6.0, 12.0, 1.0);
		m1.add(4.0, 4.0, 13.0, 1.0);
		m1.add(5.0, 3.0, 46.0, 1.0);
		m1.add(10.0, 7.0, 53.0, 1.0);
		m1.add(7.0, 2.0, 2.0, 1.0);
		m1.add(2.0, 5.0, 1.0, 1.0);
		
		m2.add(1.0, 0.0, 0.0, 0.0);
		m2.add(0.0, 0.5, 2.0, 0.0);
		m2.add(0.0, 2.0, 0.5, 0.0);
		m2.add(0.0, 0.0, 0.0, 1.0);
		
		res.add(12.0, 40.5, 12.0, 1.0);
		res.add(3.0, 27.0, 18.0, 1.0);
		res.add(4.0, 28.0, 14.5, 1.0);
		res.add(5.0, 93.5, 29.0, 1.0);
		res.add(10.0, 109.5, 40.5, 1.0);
		res.add(7.0, 5.0, 5.0, 1.0);
		res.add(2.0, 4.5, 10.5, 1.0);
		
		Rotation r1 = new RotationUp(m1, null);
		Matrice sol = r1.multipliMatrice(m2);
		assertEquals(sol.toString() , res.toString());	
	}
	
	@Test
	void TwoMulitplytest() {
		Matrice m1 = new Matrice(4,4);
		Matrice m2 = new Matrice(4,4);
		Matrice res = new Matrice(4,4);
		
		m1.add(1.0, 1.0, 1.0, 1.0);
		m1.add(2.0, 2.0, 2.0, 2.0);
		m1.add(3.0, 3.0, 3.0, 3.0);
		m1.add(4.0, 4.0, 4.0, 4.0);
		
		m2.add(1.0, 0.0, 1.0, 0.0);
		m2.add(0.0, 1.0, 0.0, 0.0);
		m2.add(0.0, 0.0, 1.0, 0.0);
		m2.add(0.0, 1.0, 0.0, 1.0);
		
		res.add(1.0, 2.0, 2.0, 1.0);
		res.add(2.0, 4.0, 4.0, 2.0);
		res.add(3.0, 6.0, 6.0, 3.0);
		res.add(4.0, 8.0, 8.0, 4.0);
		
		Rotation r1 = new RotationUp(m1 , null);
		Matrice sol = r1.multipliMatrice(m2);
		assertEquals(sol.toString() , res.toString());	
		
		Matrice res2 = new Matrice(4,4);
		Matrice m3 = new Matrice(4,4);
		
		m3.add(1.0, 0.0, 0.0, 1.0);
		m3.add(0.0, 1.0, 1.0, 0.0);
		m3.add(0.0, 1.0, 1.0, 0.0);
		m3.add(1.0, 0.0, 0.0, 1.0);
		
		res2.add(2.0, 4.0, 4.0, 2.0);
		res2.add(4.0, 8.0, 8.0, 4.0);
		res2.add(6.0, 12.0, 12.0, 6.0);
		res2.add(8.0, 16.0, 16.0, 8.0);
	
		sol = r1.multipliMatrice(m3);
		assertEquals(sol.toString() , res2.toString());	
		
	}
	

}
