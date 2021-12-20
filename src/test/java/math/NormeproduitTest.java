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
		Sommet sommetA = new Sommet(1, 2, 3);
		Sommet sommetB = new Sommet(2,3,3);
		Sommet sommetC = new Sommet(2,2,5);
		ProduitScalaire produitScal1 = new ProduitScalaire(sommetA ,sommetB);
		ProduitScalaire produitScal2 = new ProduitScalaire(sommetA , sommetC);
		produitScal1.prodScal(produitScal2.getMatrice());
		ProdVectoUni produitVectoUni = new ProdVectoUni(produitScal1);
		Matrice res1 = new Matrice(1,1);
		res1.add(2.0/3.0, -(2.0/3.0), -(1.0/3.0), 1.0);
		assertEquals(res1.toString(), produitVectoUni.getNorme().toString());
	}
	
	/**
	 * Test norme complexe.
	 */
	@Test
	void testNormeComplexe() {
		Matrice matrice = new Matrice(1,1);
		matrice.add(1.0,1.0,1.0,1.0);
		ProduitScalaire prodScal = new ProduitScalaire(matrice);
		ProdVectoUni prodVetoUni = new ProdVectoUni(prodScal);
		Matrice res2 = new Matrice(1,1);
		res2.add(1.0/Math.sqrt(3.0), 1.0/Math.sqrt(3.0), 1.0/Math.sqrt(3.0), 1);
		assertEquals(res2.toString(), prodVetoUni.getNorme().toString());
		
	}

}
