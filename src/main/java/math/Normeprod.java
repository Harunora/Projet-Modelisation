package math;

import graph.Matrice;

public class Normeprod {
	protected ProduitScalaire produitScalaire;
	protected int racineProdScalaire;
	protected Matrice matrice; 
	private double dx;
	private double dy;
	private double dz;
	
	public Normeprod(ProduitScalaire ps){
		produitScalaire = ps;		
		dx = produitScalaire.getMatrice().getX(0);
		dy = produitScalaire.getMatrice().getY(0);
		dz = produitScalaire.getMatrice().getZ(0);
		racineProdScalaire = (int) Math.sqrt(dx*dx + dy*dy +dz*dz);
		matrice = new Matrice(1,1);
		matrice.add(dx/racineProdScalaire, dy/racineProdScalaire, dz/racineProdScalaire, 1);
	}
	
	public Matrice getNorme() {
		return matrice;
	}
	
	
}
