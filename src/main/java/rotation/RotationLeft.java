package rotation;

import graph.Matrice;

/**
 * The Class RotationLeft.
 */
public class RotationLeft extends Mouvement {

	/**
	 * Instantiates a new rotation left.
	 *
	 * @param m the m
	 * @param r the r
	 */
	public RotationLeft(Matrice m, Mouvement r) {
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
		// bon
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(Math.cos(sensibility), 0.0, (-1.0) * Math.sin(sensibility), 0.0);
		newMatrice.add(0.0, 1.0, 0.0, 0.0);
		newMatrice.add(Math.sin(sensibility), 0.0, Math.cos(sensibility), 0.0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;
	}

}