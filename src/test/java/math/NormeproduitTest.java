package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrice;
import graph.Sommet;

/**
 * The Class NormeproduitTest.
 */
class NormeproduitTest {

	/**
	 * Test norme.
	 */
	@Test
	void testNorme() {
		Sommet a = new Sommet(1, 2, 3);
		Sommet b = new Sommet(2,3,3);
		Sommet c = new Sommet(2,2,5);
		ProduitScalaire p1 = new ProduitScalaire(a ,b);
		ProduitScalaire p2 = new ProduitScalaire(a , c);
		p1.ProdScal(p2.getMatrice());
		ProdVectoUni n = new ProdVectoUni(p1);
		Matrice res1 = new Matrice(1,1);
		res1.add(2.0/3.0, -(2.0/3.0), -(1.0/3.0), 1.0);
		assertEquals(res1.toString(), n.getNorme().toString());
	}
	
	/**
	 * Test norme complexe.
	 */
	@Test
	void testNormeComplexe() {
		Matrice l = new Matrice(1,1);
		l.add(1.0,1.0,1.0,1.0);
		ProduitScalaire p = new ProduitScalaire(l);
		ProdVectoUni n = new ProdVectoUni(p);
		Matrice res2 = new Matrice(1,1);
		res2.add(1.0/Math.sqrt(3.0), 1.0/Math.sqrt(3.0), 1.0/Math.sqrt(3.0), 1);
		assertEquals(res2.toString(), n.getNorme().toString());
		
	}

}
