package rotation;

import graph.Matrix;

/**
 * La classe RotationAroundLeft.
 * 
 * @author Julien Lalloyer
 */
public class RotationAroundLeft extends Mouvement {
	
	/**
	 * Instantie une nouvelle rotation dans le sens anti-horraire.
	 *
	 * @param matrice la matrice de base
	 * @param mouvement le mouvement a apliquer
	 */
	public RotationAroundLeft(Matrix matrice, Mouvement mouvement) {
		super(matrice, mouvement);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Rotation dans le sens anti-horraire.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres rotation
	 */
	@Override
	public Matrix mouvement(double sensibility) {
		// bon
		Matrix newMatrice = new Matrix(4, 4);
		newMatrice.add( Math.cos(sensibility),Math.sin(sensibility), 0.0, 0.0);
		newMatrice.add( (-1.0)*Math.sin(sensibility), Math.cos(sensibility), 0.0, 0.0);
		newMatrice.add(0.0, 0.0, 1.0, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;

	}
}
