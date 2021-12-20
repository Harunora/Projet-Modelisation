package math;

import graph.Matrice;

/**
 * The Class Translation.
 */
public class Translation {
	
	/** The matrice courante. */
	protected Matrice matriceCourante;
	
	/** The mx. */
	private double matricecoordX ;
	
	/** The mz. */
	private double matricecoordZ; 
	
	/** The my. */
	private double matricecoordY ;
	
	/**
	 * Instantiates a new translation.
	 *
	 * @param matrice the m
	 */
	public Translation(Matrice matrice) {
		matriceCourante = matrice;
	}
	
	
	/**
	 * Adds the to matrice.
	 *
	 * @param coord_x the x
	 * @param coord_y the y
	 * @param coord_z the z
	 * @return the matrice
	 */
	public  Matrice addToMatrice(double coord_x, double coord_y , double coord_z) {
		Matrice matriceConverted = new Matrice(matriceCourante.getTaille(),matriceCourante.getTaille());
		for(int i = 0 ; i < matriceCourante.getTaille(); i++) {

			matricecoordX =  matriceCourante.getX(i) + coord_x;

			matricecoordY =  matriceCourante.getY(i) + coord_y;
			
			matricecoordZ =  matriceCourante.getZ(i) + coord_z;
			
			matriceConverted .add(matricecoordX, matricecoordY, matricecoordZ, matriceCourante.getV(i));
			
			matricecoordX = 0.0;
			matricecoordY = 0.0;
			matricecoordZ = 0.0;
			
		}

		matriceCourante = matriceConverted;

		return matriceCourante;
	}
	
	/**
	 * Translate.
	 *
	 * @param matrice the m
	 * @return the matrice
	 */
	public Matrice translate(Matrice matrice) {
		this.addToMatrice(matrice.getX(0), matrice.getY(0),matrice.getZ(0));
		return this.getMcourante();

	}

	/**
	 * Gets the mcourante.
	 *
	 * @return the mcourante
	 */
	public Matrice getMcourante() {
		return this.matriceCourante;
	}
}
