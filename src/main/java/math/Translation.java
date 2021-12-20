package math;

import graph.Matrice;

/**
 * The Class Translation.
 */
public class Translation {
	
	/** The matrice courante. */
	protected Matrice matriceCourante;
	
	/** The mx. */
	private double matricecoord_x ;
	
	/** The mz. */
	private double matricecoord_z; 
	
	/** The my. */
	private double matricecoord_y ;
	
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

			matricecoord_x =  matriceCourante.getX(i) + coord_x;

			matricecoord_y =  matriceCourante.getY(i) + coord_y;
			
			matricecoord_z =  matriceCourante.getZ(i) + coord_z;
			
			matriceConverted .add(matricecoord_x, matricecoord_y, matricecoord_z, matriceCourante.getV(i));
			
			matricecoord_x = 0.0;
			matricecoord_y = 0.0;
			matricecoord_z = 0.0;
			
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
