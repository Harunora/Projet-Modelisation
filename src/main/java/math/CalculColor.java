package math;

import java.util.ArrayList;

import graph.Coloration;
import graph.Face;
import graph.Matrice;
import graph.Sommet;
import javafx.scene.paint.Color;

public class CalculColor {
	Color couleur;
	Matrice vecteurlumiere;
	public CalculColor(Matrice positionlumiere, Color color) {
		ProduitScalaire p = new ProduitScalaire(positionlumiere);
		Normeprod n =  new Normeprod(p);
		this.vecteurlumiere = n.getNorme();
		couleur = color;
	}
	
	public Color getColor(Face f) {
		ArrayList<Sommet> listsommet = (ArrayList<Sommet>) f.getSommets();
		if(f.getNbSommet()== 3) {
			ProduitScalaire p1 = new ProduitScalaire(listsommet.get(0), listsommet.get(1));
			p1.ProdScal(new ProduitScalaire(listsommet.get(0), listsommet.get(2)).getMatrice());
			Normeprod norme = new Normeprod(p1);
			// la il reste a faire le calcule avec la couleur
			double coef = calcfactlumiere(norme);
			
			System.out.println(f.getColor().getRed());
			
				double r = f.getColor().getRed();
				double g = f.getColor().getGreen();
				double b = f.getColor().getBlue();
				if(coef > 0.0) {
					couleur = new Color((r * coef), (g * coef), (b* coef), 1.0);
				}else {
					couleur = new Color(0.0,0.0,0.0,1.0);
				}
				
			
			
			
			
		}
		
		return couleur;
	}

	private double calcfactlumiere(Normeprod norme) {
		double dx = norme.getNorme().getX(0) * vecteurlumiere.getX(0); 
		double dy =norme.getNorme().getY(0) * vecteurlumiere.getY(0) ;
		double dz =norme.getNorme().getZ(0) * vecteurlumiere.getZ(0);
		return dx+dy+dz;
		
	}
}
