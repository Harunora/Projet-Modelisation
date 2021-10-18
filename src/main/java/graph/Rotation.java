package graph;

public abstract class Rotation {
	protected Matrice matrice;
	public Rotation(Matrice m) {
		matrice = m;
	}
	
	public abstract Matrice rotate();
	protected  Matrice multipliMatrice(Matrice mcourante , Matrice mconverter) {
		Matrice mConverted = new Matrice(mcourante.getTaille(), mcourante.getTaille());
		double dx = 0.0;
		double dy = 0.0;
		double dz = 0.0;
		double dv = 0.0;
		for(int i = 0 ; i < mcourante.getTaille();i++ ) {
			//jusqu'a 4 prend tout les x tout les y tout les z et tout les v 
			for(int j = 0; j < mconverter.getTaille(); j++) {
				switch(j) {
					case 0:
						dx += mconverter.getX(j) * mcourante.getX(i);
						dy += mconverter.getY(j) * mcourante.getX(i);
						dz += mconverter.getZ(j) * mcourante.getX(i);
						dv += mconverter.getV(j) * mcourante.getX(i);
						break;
					case 1:
						dx += mconverter.getX(j) * mcourante.getY(i);
						dy += mconverter.getY(j) * mcourante.getY(i);
						dz += mconverter.getZ(j) * mcourante.getY(i);
						dv += mconverter.getV(j) * mcourante.getY(i);
						break;
					case 2:
						dx += mconverter.getX(j) * mcourante.getZ(i);
						dy += mconverter.getY(j) * mcourante.getZ(i);
						dz += mconverter.getZ(j) * mcourante.getZ(i);
						dv += mconverter.getV(j) * mcourante.getZ(i);
						break;
					case 3:
						dx += mconverter.getX(j) * mcourante.getZ(i);
						dy += mconverter.getY(j) * mcourante.getZ(i);
						dz += mconverter.getZ(j) * mcourante.getZ(i);
						dv += mconverter.getV(j) * mcourante.getZ(i);
						break;
				}
			}
			mConverted.add(dx, dy, dz, dv);
			dx = 0.0;
			dy = 0.0;
			dz = 0.0;
			dv = 0.0;
		}
		return mConverted;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// a regarder
	public Matrice rotateUp(double sensibility) {
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(1.0 , 0.0 , 0.0, 0.0 );
		newMatrice.add(0.0, Math.cos(sensibility), Math.sin(sensibility), 0);
		newMatrice.add(0.0, (-1.0)*Math.sin(sensibility), Math.cos(sensibility), 0);
		newMatrice.add(0.0 , 0.0 , 0.0, 1.0 );
		this.matrice = multipliMatrice(matrice, newMatrice);
		
		
		return matrice ;
	}
	//bon
	public Matrice rotateDown(double sensibility) {
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(1.0 , 0.0 , 0.0, 0.0 );
		newMatrice.add(0.0, Math.cos(sensibility), Math.sin(sensibility), 0);
		newMatrice.add(0.0, (-1.0)*Math.sin(sensibility), Math.cos(sensibility), 0);
		newMatrice.add(0.0 , 0.0 , 0.0, 1.0 );
		this.matrice = multipliMatrice(matrice, newMatrice);
		
		return matrice ;
	}
	//bon
	public Matrice rotateLeft(double sensibility) {
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(Math.cos(sensibility) , 0.0 ,(-1.0)*Math.sin(sensibility), 0.0 );
		newMatrice.add(0.0,1.0, 0.0, 0.0);
		newMatrice.add(Math.sin(sensibility), 0.0, Math.cos(sensibility), 0.0);
		newMatrice.add(0.0 , 0.0 , 0.0, 1.0 );
		this.matrice = multipliMatrice(matrice, newMatrice);
	
		return matrice ;
	}
	//a regarder
	public Matrice rotateRight(double sensibility) {
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(1.0 , 0.0 , 0.0, 0.0 );
		newMatrice.add(0.0, Math.cos(sensibility), Math.sin(sensibility), 0);
		newMatrice.add(0.0, (-1.0)*Math.sin(sensibility), Math.cos(sensibility), 0);
		newMatrice.add(0.0 , 0.0 , 0.0, 1.0 );
		this.matrice = multipliMatrice(matrice, newMatrice);
	
		return this.matrice ;
	}
	
	
}
