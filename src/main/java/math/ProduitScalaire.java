package math;

import graph.Matrice;
import graph.Sommet;

/**
 * The Class ProduitScalaire.
 */
public class ProduitScalaire {	
	
	/** The matrice. */
	protected Matrice matrice;
	
	/**
	 * Instantiates a new produit scalaire.
	 *
	 * @param matrice the m
	 */
	public ProduitScalaire(Matrice matrice) {
		this.matrice = matrice;
	}
	
	/**
	 * Instantiates a new produit scalaire.
	 *
	 * @param sommet1 the p 1
	 * @param sommet2 the p 2
	 */
	public ProduitScalaire(Sommet sommet1, Sommet sommet2) {
		matrice = new Matrice(1,1);
		matrice.add(sommet2.getX() - sommet1.getX(), sommet2.getY() - sommet1.getY(), sommet2.getZ() - sommet1.getZ(), 1);
	}
	
	/**
	 * Verif prod.
	 *
	 * @param matrice the matrice
	 * @return true, if successful
	 */
	public boolean verifProd(Matrice matrice) {
		
		return this.matrice.getTaille() == matrice.getTaille();
	}
	
	/**
	 * Prod scal.
	 *
	 * @param matrice the m
	 */
	public void ProdScal(Matrice matrice) {
		Matrice res;
		if(verifProd(matrice)){
			res = CalcScal(matrice);
		}else {
			res = new Matrice(1,1);
		}
		this.matrice  = res;
	}
	
	/**
	 * Calc scal.
	 *
	 * @param matrice the m
	 * @return the matrice
	 */
	public Matrice CalcScal(Matrice matrice) {
		Matrice res = new Matrice(1,1);
		double coord_x = this.matrice.getY(0) * matrice.getZ(0) - this.matrice.getZ(0) * matrice.getY(0);
		double coord_y = this.matrice.getZ(0) * matrice.getX(0) - this.matrice.getX(0) * matrice.getZ(0);
		double coord_z = this.matrice.getX(0) * matrice.getY(0) - this.matrice.getY(0) * matrice.getX(0);
		res.add(coord_x, coord_y, coord_z, 1);
		return res;
	}

	/**
	 * Gets the matrice.
	 *
	 * @return the matrice
	 */
	public Matrice getMatrice() {
		// TODO Auto-generated method stub
		return matrice;
	}
}
