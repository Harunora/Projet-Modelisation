package rotation;

import graph.Matrice;

/**
 * La classe RotationAroundRight.
 * 
 * @author Julien Lalloyer
 */
public class RotationAroundRight extends Mouvement  {

	/**
	 * Instantie une nouvelle rotation dans le sens horraire.
	 *
	 * @param matrice la matrice de base
	 * @param mouvement le mouvement a apliquer
	 */
	public RotationAroundRight(Matrice matrice, Mouvement mouvement) {
		super(matrice ,mouvement);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Rotation dans le sens horraire.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres rotation
	 */
	@Override
	public Matrice mouvement(double sensibility) {
		// bon
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add( Math.cos(sensibility),(-1.0)*Math.sin(sensibility), 0.0, 0.0);
		newMatrice.add( Math.sin(sensibility), Math.cos(sensibility), 0.0, 0.0);
		newMatrice.add(0.0, 0.0, 1.0, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;

	}

}