package rotation;

import graph.Matrice;

/**
 * The Class RotationRight.
 */
public class RotationRight extends Mouvement{

	/**
	 * Instantiates a new rotation right.
	 *
	 * @param matrice the m
	 * @param r the r
	 */
	public RotationRight(Matrice matrice, Mouvement mouvement) {
		super(matrice, mouvement);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Rotate.
	 *
	 * @param sensibility the sensibility
	 * @return the matrice
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