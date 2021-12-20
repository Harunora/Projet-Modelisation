package rotation;

import graph.Matrice;

/**
 * The Class RotationUp.
 */
public class RotationUp extends Mouvement {

	/**
	 * Instantiates a new rotation up.
	 *
	 * @param m the m
	 * @param r the r
	 */
	public RotationUp(Matrice m, Mouvement r) {
		super(m, r);
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
		newMatrice.add(1.0, 0.0, 0.0, 0.0);
	    newMatrice.add(0.0, Math.cos(sensibility),(-1.0)*Math.sin(sensibility), 0);
		newMatrice.add(0.0, Math.sin(sensibility), Math.cos(sensibility), 0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice( newMatrice);

		return mcourante;
	}

}