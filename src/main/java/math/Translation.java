package math;

import graph.Matrix;

/**
 * La classe Translation.
 * 
 * @author Julien Lalloyer
 */
public class Translation {
	
	/** La matrice courante. */
	protected Matrix matriceCourante;
	
	/** La coordonee X de la matrice. */
	private double matricecoordX ;
	
	/** La coordonee Z de la matrice. */
	private double matricecoordZ; 
	
	/**  La coordonee Y de la matrice. */
	private double matricecoordY ;
	
	/**
	 * Instantie une nouvelle translation.
	 *
	 * @param matrice la matrice
	 */
	public Translation(Matrix matrice) {
		matriceCourante = matrice;
	}
	
	
	/**
	 * Ajoute x y et z a la matrice courante.
	 *
	 * @param coord_x le x qu'on ajoute a la matrice. 
	 * @param coord_y le y qu'on ajoute a la matrice.
	 * @param coord_z le z qu'on ajoute a la matrice.
	 * @return la matrice apres la translation
	 */
	public  Matrix addToMatrice(double coordx, double coordy , double coordz) {
		Matrix matriceConverted = new Matrix(matriceCourante.getTaille(),matriceCourante.getTaille());
		for(int i = 0 ; i < matriceCourante.getTaille(); i++) {
			matricecoordX =  matriceCourante.getX(i) + coordx;
			matricecoordY =  matriceCourante.getY(i) + coordy;
			matricecoordZ =  matriceCourante.getZ(i) + coordz;
			matriceConverted .add(matricecoordX, matricecoordY, matricecoordZ, matriceCourante.getV(i));
			matricecoordX = 0.0;
			matricecoordY = 0.0;
			matricecoordZ = 0.0;
		}
		matriceCourante = matriceConverted;
		return matriceCourante;
	}
	
	/**
	 * Effectue la translation.
	 *
	 * @param matrice la matrice
	 * @return la matrice translaté
	 */
	public Matrix translate(Matrix matrice) {
		this.addToMatrice(matrice.getX(0), matrice.getY(0),matrice.getZ(0));
		return this.getMcourante();

	}

	/**
	 * Prendre la matrice courante.
	 *
	 * @return la matrice courante
	 */
	public Matrix getMcourante() {
		return this.matriceCourante;
	}
}
