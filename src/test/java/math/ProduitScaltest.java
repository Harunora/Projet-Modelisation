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
	void ProduitSimpleMatricetest() {
		Matrice m1 = new Matrice(1,1);
		m1.add(1,1,0,1);
		Matrice m2 = new Matrice(1,1);
		m2.add(1,0,2,1);
		ProduitScalaire p1 = new ProduitScalaire(m1);
		ProduitScalaire p2 = new ProduitScalaire(m2);
		p1.ProdScal(p2.getMatrice());
		Matrice res3 = new Matrice(1,1);
		res3.add(2, -2, -1, 1);
		assertEquals(res3.toString(), p1.getMatrice().toString());
	}
	
	/**
	 * Produit avec sommet.
	 */
	@Test
	void ProduitAvecSommet() {
		Sommet a = new Sommet(1, 2, 3);
		Sommet b = new Sommet(2,3,3);
		Sommet c = new Sommet(2,2,5);
		ProduitScalaire p1 = new ProduitScalaire(a ,b);
		ProduitScalaire p2 = new ProduitScalaire(a , c);
		Matrice res1 = new Matrice(1,1) ;
		res1.add(1, 1, 0, 1);
		assertEquals(res1.toString() , p1.getMatrice().toString());
		Matrice res2 = new Matrice(1,1);
		res2.add(1, 0, 2, 1);
		assertEquals(res2.toString(), p2.getMatrice().toString());
		p1.ProdScal(p2.getMatrice());
		Matrice res3 = new Matrice(1,1);
		res3.add(2, -2, -1, 1);
		assertEquals(res3.toString(), p1.getMatrice().toString());
	}

}
