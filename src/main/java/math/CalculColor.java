package math;


import java.util.ArrayList;

import graph.Face;
import graph.Matrice;
import graph.Sommet;
import javafx.scene.paint.Color;

/**
 * The Class CalculColor.
 */
public class CalculColor {
	
	/** The couleur. */
	Color couleur;
	
	/** The vecteurlumiere. */
	Matrice vecteurlumiere;
	
	/**
	 * Instantiates a new calcul color.
	 *
	 * @param positionlumiere the positionlumiere
	 * @param color the color
	 */
	public CalculColor(Matrice positionlumiere, Color color) {
		ProduitScalaire produitScalaire = new ProduitScalaire(positionlumiere);
		ProdVectoUni produitVectoUni =  new ProdVectoUni(produitScalaire);
		this.vecteurlumiere = produitVectoUni.getNorme();
		couleur = color;
	}
	
	/**
	 * Gets the color.
	 *
	 * @param face the f
	 * @return the color
	 */
	public Color getColor(Face face) {
		ArrayList<Sommet> listsommet = (ArrayList<Sommet>) face.getSommets();
		if(face.getNbSommet()== 3) {
			ProduitScalaire produitScalaire = new ProduitScalaire(listsommet.get(0), listsommet.get(1));
			produitScalaire.prodScal(new ProduitScalaire(listsommet.get(0), listsommet.get(2)).getMatrice());
			ProdVectoUni prodVectoUni = new ProdVectoUni(produitScalaire);
			// la il reste a faire le calcule avec la couleur
			double coef = calcfactlumiere(prodVectoUni);	
			double rouge = face.getRed();
			double vert = face.getGreen();
			double bleu = face.getBlue();
			if(coef > 0.0) {
				couleur = new Color((rouge * coef), (vert * coef), (bleu* coef), 1.0);
			}else {
					couleur = new Color(0.0,0.0,0.0,1.0);
			}
		}
		return couleur;
	}

	/**
	 * Calcfactlumiere.
	 *
	 * @param produitVectoUni the norme
	 * @return the double
	 */
	private double calcfactlumiere(ProdVectoUni produitVectoUni) {
		double coord_x = produitVectoUni.getNormeX() * vecteurlumiere.getX(0); 
		double coord_y =produitVectoUni.getNormeY() * vecteurlumiere.getY(0) ;
		double coord_z =produitVectoUni.getNormeZ() * vecteurlumiere.getZ(0);
		return coord_x+coord_y+coord_z;
		
	}
}
