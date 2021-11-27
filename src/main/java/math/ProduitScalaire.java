package math;

import graph.Matrice;
import graph.Sommet;

public class ProduitScalaire {	
	protected Matrice matrice;
	
	public ProduitScalaire(Matrice m) {
		matrice = m;
	}
	
	public ProduitScalaire(Sommet p1, Sommet p2) {
		matrice = new Matrice(1,1);
		matrice.add(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ(), 1);
	}
	
	public boolean verifProd(Matrice m) {
		
		return matrice.getTaille() == m.getTaille();
	}
	public void ProdScal(Matrice m) {
		Matrice res = new Matrice(1,1);
		if(verifProd(m)){
			res = CalcScal(m);
		}else {
			res = new Matrice(1,1);
		}
		matrice  = res;
	}
	
	public Matrice CalcScal(Matrice m) {
		Matrice res = new Matrice(1,1);
		double dx = matrice.getY(0) * m.getZ(0) - matrice.getZ(0) * m.getY(0);
		double dy = matrice.getZ(0) * m.getX(0) - matrice.getX(0) * m.getZ(0);
		double dz = matrice.getX(0) * m.getY(0) - matrice.getY(0) * m.getX(0);
		res.add(dx, dy, dz, 1);
		return res;
	}

	public Matrice getMatrice() {
		// TODO Auto-generated method stub
		return matrice;
	}
}
