package rotation;

import graph.Matrice;

/**
 * La classe RotationUp.
 * 
 * @author Julien Lalloyer
 */
public class RotationUp extends Mouvement {

	/**
	 * Instantie une nouvelle rotation vers le haut.
	 *
	 * @param matrice la matrice de base
	 * @param mouvement le mouvement a apliquer
	 */
	public RotationUp(Matrice matrice, Mouvement mouvement) {
		super(matrice, mouvement);
	}

	/**
	 * Rotation vers le haut.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres rotation
	 */
	@Override
	public Matrice mouvement(double sensibility) {
		// a regarder
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(1.0, 0.0, 0.0, 0.0);
	    newMatrice.add(0.0, Math.cos(sensibility),(-1.0)*Math.sin(sensibility), 0);
		newMatrice.add(0.0, Math.sin(sensibility), Math.cos(sensibility), 0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice( newMatrice);

		return mcourante;
	}

}