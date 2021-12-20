package math;

import graph.Matrice;

/**
 * The Class Normeprod.
 */
public class ProdVectoUni {
	
	/** The produit scalaire. */
	protected ProduitScalaire produitScalaire;
	
	/** The racine prod scalaire. */
	protected double norme;
	
	/** The matrice. */
	protected Matrice matrice; 
	
	/** The dx. */
	private double coordX;
	
	/** The dy. */
	private double coordY;
	
	/** The dz. */
	private double coordZ;
	
	/**
	 * Instantiates a new normeprod.
	 *
	 * @param produitScal the ps
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
	 * Gets the norme.
	 *
	 * @return the norme
	 */
	public Matrice getNorme() {
		return matrice;
	}
	
	
	/**
	 * Gets the norme X.
	 *
	 * @return the norme X
	 */
	public double getNormeX() {
		return matrice.getX(0);
	}
	
	
	/**
	 * Gets the norme Y.
	 *
	 * @return the norme Y
	 */
	public double getNormeY() {
		return matrice.getY(0);
	}
	
	
	/**
	 * Gets the norme Z.
	 *
	 * @return the norme Z
	 */
	public double getNormeZ() {
		return matrice.getZ(0);
	}
	
	
	
}
