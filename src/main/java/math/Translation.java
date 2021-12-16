package math;

import graph.Matrice;

public class Translation {
	protected Matrice matriceCourante;

	
	public Translation(Matrice m) {
		matriceCourante = m;
	}
	
	
	public  Matrice multipliMatrice(Matrice mconverter) {
		Matrice mConverted = new Matrice(matriceCourante.getTaille(), matriceCourante.getTaille());
		double dx = 0.0;
		double dy = 0.0;
		double dz = 0.0;
		double dv = 0.0;
		for(int i = 0 ; i < matriceCourante.getTaille();i++ ) {
			//jusqu'a 4 prend tout les x tout les y tout les z et tout les v 
			for(int j = 0; j < mconverter.getTaille(); j++) {
				switch(j) {
					case 0:
						dx += mconverter.getX(j) * matriceCourante.getX(i);
						dy += mconverter.getY(j) * matriceCourante.getX(i);
						dz += mconverter.getZ(j) * matriceCourante.getX(i);
						dv += mconverter.getV(j) * matriceCourante.getX(i);
						break;
					case 1:
						dx += mconverter.getX(j) * matriceCourante.getY(i);
						dy += mconverter.getY(j) * matriceCourante.getY(i);
						dz += mconverter.getZ(j) * matriceCourante.getY(i);
						dv += mconverter.getV(j) * matriceCourante.getY(i);
						break;
					case 2:
						dx += mconverter.getX(j) * matriceCourante.getZ(i);
						dy += mconverter.getY(j) * matriceCourante.getZ(i);
						dz += mconverter.getZ(j) * matriceCourante.getZ(i);
						dv += mconverter.getV(j) * matriceCourante.getZ(i);
						break;
					case 3:
						dx += mconverter.getX(j) * matriceCourante.getV(i);
						dy += mconverter.getY(j) * matriceCourante.getV(i);
						dz += mconverter.getZ(j) * matriceCourante.getV(i);
						dv += mconverter.getV(j) * matriceCourante.getV(i);
						break;
				}
			}
			mConverted.add(dx, dy, dz, dv);
			dx = 0.0;
			dy = 0.0;
			dz = 0.0;
			dv = 0.0;
		}
		this.matriceCourante = mConverted;
		this.matriceCourante.update();
		return mConverted;
	}
	
	public Matrice translate(double x, double y, double z) {
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add( 1.0,0.0, 0.0, x);
		newMatrice.add( 0.0, 1.0, 0.0, y);
		newMatrice.add(0.0, 0.0, 1.0, z);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.matriceCourante = multipliMatrice(newMatrice);

		return matriceCourante;

	}

	public Matrice getMcourante() {
		return this.matriceCourante;
	}
}
