package math;

import graph.Matrix;
import graph.Vertex;

/**
 * The Class ProduitScalaire.
 * 
 * @author Julien Lalloyer
 */
public class ProduitScalaire {	
	
	/** La matrice. */
	protected Matrix matrice;
	
	/**
	 * Instantie un nouveau produit scalaire.
	 *
	 * @param matrice la matrice
	 */
	public ProduitScalaire(Matrix matrice) {
		this.matrice = matrice;
	}
	
	/**
	 * Instantie un nouveau produit scalaire.
	 *
	 * @param sommet1 le premier sommet qui permetra a faire une matrice
	 * @param sommet2 le second sommet qui permetra a faire une matrice
	 */
	public ProduitScalaire(Vertex sommet1, Vertex sommet2) {
		matrice = new Matrix(1,1);
		matrice.add(sommet2.getX() - sommet1.getX(), sommet2.getY() - sommet1.getY(), sommet2.getZ() - sommet1.getZ(), 1);
	}
	
	/**
	 * Verifie la possibilité de faire un produit matricielle.
	 *
	 * @param matrice la matrice
	 * @return true, si c'est possible
	 */
	public boolean verifProd(Matrix matrice) {
		
		return this.matrice.getTaille() == matrice.getTaille();
	}
	
	/**
	 * Produit scalaire.
	 *
	 * @param matrice la matrice
	 */
	public void prodScal(Matrix matrice) {
		Matrix res;
		if(verifProd(matrice)){
			res = calcScal(matrice);
		}else {
			res = new Matrix(1,1);
		}
		this.matrice  = res;
	}
	
	/**
	 * Calcule scalaire.
	 *
	 * @param matrice la matrice utilisee pour le produit 
	 * @return le produit scalaire des deux matrices
	 */
	public Matrix calcScal(Matrix matrice) {
		Matrix res = new Matrix(1,1);
		double coordX = this.matrice.getY(0) * matrice.getZ(0) - this.matrice.getZ(0) * matrice.getY(0);
		double coordY = this.matrice.getZ(0) * matrice.getX(0) - this.matrice.getX(0) * matrice.getZ(0);
		double coordZ = this.matrice.getX(0) * matrice.getY(0) - this.matrice.getY(0) * matrice.getX(0);
		res.add(coordX, coordY, coordZ, 1);
		return res;
	}

	/**
	 * Prendre la matrice de l'homothetie.
	 *
	 * @return la matrice
	 */
	public Matrix getMatrice() {
		// TODO Auto-generated method stub
		return matrice;
	}
}
