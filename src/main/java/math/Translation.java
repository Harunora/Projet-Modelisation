package math;

import graph.Matrice;

/**
 * La classe Translation.
 * 
 * @author Julien Lalloyer
 */
public class Translation {
	
	/** La matrice courante. */
	protected Matrice matriceCourante;
	
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
	public Translation(Matrice matrice) {
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
	 * Effectue la translation.
	 *
	 * @param matrice la matrice
	 * @return la matrice translaté
	 */
	public Matrice translate(Matrice matrice) {
		this.addToMatrice(matrice.getX(0), matrice.getY(0),matrice.getZ(0));
		return this.getMcourante();

	}

	/**
	 * Prendre la matrice courante.
	 *
	 * @return la matrice courante
	 */
	public Matrice getMcourante() {
		return this.matriceCourante;
	}
}
