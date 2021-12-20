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
	private double coord_x;
	
	/** The dy. */
	private double coord_y;
	
	/** The dz. */
	private double coord_z;
	
	/**
	 * Instantiates a new normeprod.
	 *
	 * @param produitScal the ps
	 */
	public ProdVectoUni(ProduitScalaire produitScal){
		produitScalaire = produitScal;		
		coord_x = produitScalaire.getMatrice().getX(0);
		coord_y = produitScalaire.getMatrice().getY(0);
		coord_z = produitScalaire.getMatrice().getZ(0);
		norme = Math.sqrt(coord_x*coord_x + coord_y*coord_y +coord_z*coord_z);
		matrice = new Matrice(1,1);
		matrice.add(coord_x/norme, coord_y/norme, coord_z/norme, 1);
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
