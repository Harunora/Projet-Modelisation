package rotation;

import graph.Matrix;

/**
 * La classe RotationLeft.
 * 
 * @author Julien Lalloyer
 */
public class RotationLeft extends Mouvement {

	/**
	 * Instantie une nouvelle rotation a gauche.
	 *
	 * @param matrice la matrice de base
	 * @param mouvement le mouvement a apliquer
	 */
	public RotationLeft(Matrix matrice, Mouvement mouvement) {
		super(matrice, mouvement);
	}

	/**
	 * Rotation par la gauche.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres rotation
	 */
	@Override
	public Matrix mouvement(double sensibility) {
		// bon
		Matrix newMatrice = new Matrix(4, 4);
		newMatrice.add(Math.cos(sensibility), 0.0, (-1.0) * Math.sin(sensibility), 0.0);
		newMatrice.add(0.0, 1.0, 0.0, 0.0);
		newMatrice.add(Math.sin(sensibility), 0.0, Math.cos(sensibility), 0.0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;
	}

}