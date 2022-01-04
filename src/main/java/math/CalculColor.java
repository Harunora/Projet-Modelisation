package math;

import java.util.ArrayList;

import graph.Face;
import graph.Matrix;
import graph.Vertex;
import javafx.scene.paint.Color;

/**
 * La classe CalculColor qui calcule la couleur d'une face en fonction de la position de la lumière.
 * 
 * @author Julien Lalloyer
 */
public class CalculColor {
	
	/** La couleur. */
	Color couleur;
	
	/** Le vecteur lumiere. */
	Matrix vecteurlumiere;
	
	/**
	 * Constructeur de calculColor.
	 *
	 * @param positionlumiere position de la lumiere 
	 * @param color la couleur
	 */
	public CalculColor(Matrix positionlumiere, Color color) {
		ProduitScalaire produitScalaire = new ProduitScalaire(positionlumiere);
		ProdVectoUni produitVectoUni =  new ProdVectoUni(produitScalaire);
		this.vecteurlumiere = produitVectoUni.getNorme();
		couleur = color;
	}
	
	/**
	 * Getter pour prendre la couleur de la face et retourne une couleur en fonction de la lumiere.
	 *
	 * @param face la face choisis
	 * @return la couleur en fonction de la lumiere
	 */
	public Color getColor(Face face) {
		ArrayList<Vertex> listsommet = (ArrayList<Vertex>) face.getVertex();
		if(face.getNbVertex()== 3) {
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
	 * Permet de calculer le coefficient a appliquer a la couleur de base.
	 *
	 * @param le produit vetoriel unitaire des faces
	 * @return le coefficient a appliquer a la couleur
	 */
	private double calcfactlumiere(ProdVectoUni produitVectoUni) {
		double coord_x = produitVectoUni.getNormeX() * vecteurlumiere.getX(0); 
		double coord_y =produitVectoUni.getNormeY() * vecteurlumiere.getY(0) ;
		double coord_z =produitVectoUni.getNormeZ() * vecteurlumiere.getZ(0);
		return coord_x+coord_y+coord_z;
		
	}
}
