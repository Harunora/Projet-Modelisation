package math;

import java.util.ArrayList;

import graph.Face;
import graph.Matrice;
import graph.Sommet;
import graph.Color;

public class CalculColor {
	Color couleur;
	Matrice vecteurlumiere;
	public CalculColor(Matrice positionlumiere, Color c) {
		ProduitScalaire p = new ProduitScalaire(positionlumiere);
		Normeprod n =  new Normeprod(p);
		this.vecteurlumiere = n.getNorme();
		couleur = c;
	}
	
	public Color getColor(Face f) {
		ArrayList<Sommet> listsommet = (ArrayList<Sommet>) f.getSommets();
		if(f.getNbSommet()== 3) {
			ProduitScalaire p1 = new ProduitScalaire(listsommet.get(0), listsommet.get(1));
			p1.ProdScal(new ProduitScalaire(listsommet.get(0), listsommet.get(2)).getMatrice());
			Normeprod norme = new Normeprod(p1);
			// la il reste a faire le calcule avec la couleur
			double coef = calcfactlumière(norme);
			
			double r = couleur.getR();
			double g = couleur.getG();
			double b = couleur.getB();
			
			couleur = new Color((int)(r * coef),(int) (g * coef),(int) (b* coef));
		}
		
		return couleur;
	}

	private double calcfactlumière(Normeprod norme) {
		double dx = norme.getNorme().getX(0) * vecteurlumiere.getX(0); 
		double dy =norme.getNorme().getY(0) * vecteurlumiere.getY(0) ;
		double dz =norme.getNorme().getZ(0) * vecteurlumiere.getZ(0);
		return dx+dy+dz;
		
	}
}
