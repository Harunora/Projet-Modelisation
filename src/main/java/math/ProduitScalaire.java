package math;

import graph.Matrice;
import graph.Sommet;

/**
 * The Class ProduitScalaire.
 * 
 * @author Julien Lalloyer
 */
public class ProduitScalaire {	
	
	/** La matrice. */
	protected Matrice matrice;
	
	/**
	 * Instantie un nouveau produit scalaire.
	 *
	 * @param matrice la matrice
	 */
	public ProduitScalaire(Matrice matrice) {
		this.matrice = matrice;
	}
	
	/**
	 * Instantie un nouveau produit scalaire.
	 *
	 * @param sommet1 le premier sommet qui permetra a faire une matrice
	 * @param sommet2 le second sommet qui permetra a faire une matrice
	 */
	public ProduitScalaire(Sommet sommet1, Sommet sommet2) {
		matrice = new Matrice(1,1);
		matrice.add(sommet2.getX() - sommet1.getX(), sommet2.getY() - sommet1.getY(), sommet2.getZ() - sommet1.getZ(), 1);
	}
	
	/**
	 * Verifie la possibilité de faire un produit matricielle.
	 *
	 * @param matrice la matrice
	 * @return true, si c'est possible
	 */
	public boolean verifProd(Matrice matrice) {
		
		return this.matrice.getTaille() == matrice.getTaille();
	}
	
	/**
	 * Produit scalaire.
	 *
	 * @param matrice la matrice
	 */
	public void prodScal(Matrice matrice) {
		Matrice res;
		if(verifProd(matrice)){
			res = calcScal(matrice);
		}else {
			res = new Matrice(1,1);
		}
		this.matrice  = res;
	}
	
	/**
	 * Calcule scalaire.
	 *
	 * @param matrice la matrice utilisee pour le produit 
	 * @return le produit scalaire des deux matrices
	 */
	public Matrice calcScal(Matrice matrice) {
		Matrice res = new Matrice(1,1);
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
	public Matrice getMatrice() {
		// TODO Auto-generated method stub
		return matrice;
	}
}
