package rotation;

import graph.Matrice;

/**
 * La classe RotationRight.
 * 
 * @author Julien Lalloyer
 */
public class RotationRight extends Mouvement{

	/**
	 * Instantie une nouvelle rotation a droite.
	 *
	 * @param matrice la matrice de base
	 * @param mouvement le mouvement a apliquer
	 */
	public RotationRight(Matrice matrice, Mouvement mouvement) {
		super(matrice, mouvement);
	}

	/**
	 * Rotation par la droite.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres rotation
	 */
	@Override
	public Matrice mouvement(double sensibility) {
		// a regarder
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(Math.cos(sensibility), 0.0, Math.sin(sensibility), 0.0);
		newMatrice.add(0.0, 1.0, 0.0, 0.0);
		newMatrice.add((-1.0) *Math.sin(sensibility), 0.0, Math.cos(sensibility), 0.0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;
	}
	

}