package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrix;
import graph.Vertex;

/**
 * The Class ProduitScaltest.
 */
class ProduitScaltest {

	/**
	 * Produit simple matricetest.
	 */
	@Test
	void produitSimpleMatricetest() {
		Matrix matrice1 = new Matrix(1,1);
		matrice1.add(1,1,0,1);
		Matrix matrice2 = new Matrix(1,1);
		matrice2.add(1,0,2,1);
		ScalarProduct prodScal1 = new ScalarProduct(matrice1);
		ScalarProduct prodScal2 = new ScalarProduct(matrice2);
		prodScal1.prodScal(prodScal2.getMatrice());
		Matrix res3 = new Matrix(1,1);
		res3.add(2, -2, -1, 1);
		assertEquals(res3.toString(), prodScal1.getMatrice().toString());
	}
	
	/**
	 * Produit avec sommet.
	 */
	@Test
	void produitAvecSommet() {
		Vertex sommetA = new Vertex(1, 2, 3);
		Vertex sommetB = new Vertex(2,3,3);
		Vertex sommetC = new Vertex(2,2,5);
		ScalarProduct prodScal1 = new ScalarProduct(sommetA ,sommetB);
		ScalarProduct prodScal2 = new ScalarProduct(sommetA , sommetC);
		Matrix res1 = new Matrix(1,1) ;
		res1.add(1, 1, 0, 1);
		assertEquals(res1.toString() , prodScal1.getMatrice().toString());
		Matrix res2 = new Matrix(1,1);
		res2.add(1, 0, 2, 1);
		assertEquals(res2.toString(), prodScal2.getMatrice().toString());
		prodScal1.prodScal(prodScal2.getMatrice());
		Matrix res3 = new Matrix(1,1);
		res3.add(2, -2, -1, 1);
		assertEquals(res3.toString(), prodScal1.getMatrice().toString());
	}

}
