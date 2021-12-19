package math;

import graph.Matrice;

public class Translation {
	protected Matrice matriceCourante;
	private double mx ;
	private double mz; 
	private double my ;
	
	public Translation(Matrice m) {
		matriceCourante = m;
	}
	
	
	public  Matrice addToMatrice(double x, double y , double z) {
		Matrice matriceConverted = new Matrice(matriceCourante.getTaille(),matriceCourante.getTaille());
		for(int i = 0 ; i < matriceCourante.getTaille(); i++) {

			mx =  matriceCourante.getX(i) + x;

			my =  matriceCourante.getY(i) + y;
			
			mz =  matriceCourante.getZ(i) + z;
			
			matriceConverted .add(mx, my, mz, matriceCourante.getV(i));
			
			mx = 0.0;
			my = 0.0;
			mz = 0.0;
			
		}

		matriceCourante = matriceConverted;

		return matriceCourante;
	}
	
	public Matrice translate(Matrice m) {
		this.addToMatrice(m.getX(0), m.getY(0),m.getZ(0));
		return this.getMcourante();

	}

	public Matrice getMcourante() {
		return this.matriceCourante;
	}
}
