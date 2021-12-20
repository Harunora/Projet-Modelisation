package rotation;

import graph.Matrice;

/**
 * The Class Rotation.
 */
public abstract class Mouvement {
	
	/** The mcourante. */
	protected Matrice mcourante;
	
	/** The r. */
	protected Mouvement movement;
	
	/**
	 * Instantiates a new rotation.
	 *
	 * @param matrice the m
	 * @param mouvement the r
	 */
	public Mouvement(Matrice matrice, Mouvement mouvement) {
		mcourante = matrice;
		this.movement = mouvement;
	}
	
	/**
	 * Rotate.
	 *
	 * @param sensibility the sensibility
	 * @return the matrice
	 */
	public abstract Matrice mouvement(double sensibility);
	
	/**
	 * Multipli matrice.
	 *
	 * @param mconverter the mconverter
	 * @return the matrice
	 */
	public  Matrice multipliMatrice(Matrice mconverter) {
		Matrice mConverted = new Matrice(mcourante.getTaille(), mcourante.getTaille());
		double coordX = 0.0;
		double coordY = 0.0;
		double coordZ = 0.0;
		double coordV = 0.0;
		for(int i = 0 ; i < mcourante.getTaille();i++ ) {
			//jusqu'a 4 prend tout les x tout les y tout les z et tout les v 
			for(int j = 0; j < mconverter.getTaille(); j++) {
				switch(j) {
					case 0:
						coordX += mconverter.getX(j) * mcourante.getX(i);
						coordY += mconverter.getY(j) * mcourante.getX(i);
						coordZ += mconverter.getZ(j) * mcourante.getX(i);
						coordV += mconverter.getV(j) * mcourante.getX(i);
						break;
					case 1:
						coordX += mconverter.getX(j) * mcourante.getY(i);
						coordY += mconverter.getY(j) * mcourante.getY(i);
						coordZ += mconverter.getZ(j) * mcourante.getY(i);
						coordV += mconverter.getV(j) * mcourante.getY(i);
						break;
					case 2:
						coordX += mconverter.getX(j) * mcourante.getZ(i);
						coordY += mconverter.getY(j) * mcourante.getZ(i);
						coordZ += mconverter.getZ(j) * mcourante.getZ(i);
						coordV += mconverter.getV(j) * mcourante.getZ(i);
						break;
					case 3:
						coordX += mconverter.getX(j) * mcourante.getV(i);
						coordY += mconverter.getY(j) * mcourante.getV(i);
						coordZ += mconverter.getZ(j) * mcourante.getV(i);
						coordV += mconverter.getV(j) * mcourante.getV(i);
						break;
				}
			}
			mConverted.add(coordX, coordY, coordZ, coordV);
			coordX = 0.0;
			coordY = 0.0;
			coordZ = 0.0;
			coordV = 0.0;
		}
		this.mcourante = mConverted;
		return mConverted;
	}

	/**
	 * Gets the mcourante.
	 *
	 * @return the mcourante
	 */
	public Matrice getMcourante() {
		return mcourante;
	}

	/**
	 * Sets the mcourante.
	 *
	 * @param mcourante the new mcourante
	 */
	public void setMcourante(Matrice mcourante) {
		this.mcourante = mcourante;
	}
	
	
}
