package math;

import graph.Matrice;

/**
 * La classe produit vectoriel unitaire.
 * 
 * @author Julien Lalloyer
 */
public class ProdVectoUni {
	
	/** Le produit scalaire. */
	protected ProduitScalaire produitScalaire;
	
	/** La racine du produit scalaire. */
	protected double norme;
	
	/** La matrice. */
	protected Matrice matrice; 
	
	/** La coordonee X. */
	private double coordX;
	
	/** La coordonee Y. */
	private double coordY;
	
	/** La coordonee Z. */
	private double coordZ;
	
	/**
	 * Instantie un nouveau produit vectoriel unitaire.
	 *
	 * @param produitScal le produit scalaire de la matrice de base
	 */
	public ProdVectoUni(ProduitScalaire produitScal){
		produitScalaire = produitScal;		
		coordX = produitScalaire.getMatrice().getX(0);
		coordY = produitScalaire.getMatrice().getY(0);
		coordZ = produitScalaire.getMatrice().getZ(0);
		norme = Math.sqrt(coordX*coordX + coordY*coordY +coordZ*coordZ);
		matrice = new Matrice(1,1);
		matrice.add(coordX/norme, coordY/norme, coordZ/norme, 1);
	}
	
	/**
	 * Prendre le produit vectoriel unitaire.
	 *
	 * @return la matrice du produit vectoriel unitaire
	 */
	public Matrice getNorme() {
		return matrice;
	}
	
	
	/**
	 * Prendre le produit vectoriel unitaire coordone X.
	 *
	 * @return la coordonee X du produit vectoriel unitaire
	 */
	public double getNormeX() {
		return matrice.getX(0);
	}
	
	
	/**
	 * Prendre le produit vectoriel unitaire coordone Y.
	 *
	 * @return la coordonee Y du produit vectoriel unitaire
	 */
	public double getNormeY() {
		return matrice.getY(0);
	}
	
	
	/**
	 * Prendre le produit vectoriel unitaire coordone Y.
	 *
	 * @return la coordonee Y du produit vectoriel unitaire
	 */
	public double getNormeZ() {
		return matrice.getZ(0);
	}
	
	
	
}
