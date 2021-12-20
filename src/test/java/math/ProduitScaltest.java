package math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.Matrice;
import graph.Sommet;

/**
 * The Class ProduitScaltest.
 */
class ProduitScaltest {

	/**
	 * Produit simple matricetest.
	 */
	@Test
	void produitSimpleMatricetest() {
		Matrice matrice1 = new Matrice(1,1);
		matrice1.add(1,1,0,1);
		Matrice matrice2 = new Matrice(1,1);
		matrice2.add(1,0,2,1);
		ProduitScalaire prodScal1 = new ProduitScalaire(matrice1);
		ProduitScalaire prodScal2 = new ProduitScalaire(matrice2);
		prodScal1.prodScal(prodScal2.getMatrice());
		Matrice res3 = new Matrice(1,1);
		res3.add(2, -2, -1, 1);
		assertEquals(res3.toString(), prodScal1.getMatrice().toString());
	}
	
	/**
	 * Produit avec sommet.
	 */
	@Test
	void produitAvecSommet() {
		Sommet sommetA = new Sommet(1, 2, 3);
		Sommet sommetB = new Sommet(2,3,3);
		Sommet sommetC = new Sommet(2,2,5);
		ProduitScalaire prodScal1 = new ProduitScalaire(sommetA ,sommetB);
		ProduitScalaire prodScal2 = new ProduitScalaire(sommetA , sommetC);
		Matrice res1 = new Matrice(1,1) ;
		res1.add(1, 1, 0, 1);
		assertEquals(res1.toString() , prodScal1.getMatrice().toString());
		Matrice res2 = new Matrice(1,1);
		res2.add(1, 0, 2, 1);
		assertEquals(res2.toString(), prodScal2.getMatrice().toString());
		prodScal1.prodScal(prodScal2.getMatrice());
		Matrice res3 = new Matrice(1,1);
		res3.add(2, -2, -1, 1);
		assertEquals(res3.toString(), prodScal1.getMatrice().toString());
	}

}
