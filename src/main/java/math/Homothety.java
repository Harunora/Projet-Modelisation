package math;

import graph.Matrix;
import rotation.Mouvement;


/**
 * La classe Homothetie derivee de Mouvement.
 */
public class Homothetie extends Mouvement {
	
	/** La matrice courante. */
	private Matrix matriceCourante;
	
	/**
	 * Instantie une nouvelle homothetie.
	 *
	 * @param matrice la matrice
	 */
	public Homothetie(Matrix matrice) {
		super(matrice, null);
	}

	/**
	 * Prendre la matrice courante.
	 *
	 * @return la matrice courante
	 */
	public Matrix getMcourante() {
		return this.matriceCourante;
	}

	/**
	 * Mouvement.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres l'homothetie
	 */
	@Override
	public Matrix mouvement(double sensibility) {
		Matrix newMatrice = new Matrix(4, 4);
		newMatrice.add( sensibility,0.0, 0.0, 0.0);
		newMatrice.add( 0.0, sensibility, 0.0, 0.0);
		newMatrice.add(0.0, 0.0, sensibility, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.matriceCourante = multipliMatrice(newMatrice);

		return matriceCourante;
	}
}
