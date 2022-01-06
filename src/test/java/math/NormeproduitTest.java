package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrix;
import graph.Vertex;

/**
 * The Class NormeproduitTest.
 */
class NormeproduitTest {

	/**
	 * Test norme.
	 */
	@Test
	void testNorme() {
		Vertex sommetA = new Vertex(1, 2, 3);
		Vertex sommetB = new Vertex(2,3,3);
		Vertex sommetC = new Vertex(2,2,5);
		ScalarProduct produitScal1 = new ScalarProduct(sommetA ,sommetB);
		ScalarProduct produitScal2 = new ScalarProduct(sommetA , sommetC);
		produitScal1.prodScal(produitScal2.getMatrice());
		ProdVectoUni produitVectoUni = new ProdVectoUni(produitScal1);
		Matrix res1 = new Matrix(1,1);
		res1.add(2.0/3.0, -(2.0/3.0), -(1.0/3.0), 1.0);
		assertEquals(res1.toString(), produitVectoUni.getNorme().toString());
	}
	
	/**
	 * Test norme complexe.
	 */
	@Test
	void testNormeComplexe() {
		Matrix matrice = new Matrix(1,1);
		matrice.add(1.0,1.0,1.0,1.0);
		ScalarProduct prodScal = new ScalarProduct(matrice);
		ProdVectoUni prodVetoUni = new ProdVectoUni(prodScal);
		Matrix res2 = new Matrix(1,1);
		res2.add(1.0/Math.sqrt(3.0), 1.0/Math.sqrt(3.0), 1.0/Math.sqrt(3.0), 1);
		assertEquals(res2.toString(), prodVetoUni.getNorme().toString());
		
	}

}
