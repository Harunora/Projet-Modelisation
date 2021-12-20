package rotation;

import graph.Matrice;

/**
 * The Class RotationAroundRight.
 */
public class RotationAroundRight extends Mouvement  {

	/**
	 * Instantiates a new rotation around right.
	 *
	 * @param m the m
	 * @param r the r
	 */
	public RotationAroundRight(Matrice m, Mouvement r) {
		super(m ,r);
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
		newMatrice.add( Math.cos(sensibility),(-1.0)*Math.sin(sensibility), 0.0, 0.0);
		newMatrice.add( Math.sin(sensibility), Math.cos(sensibility), 0.0, 0.0);
		newMatrice.add(0.0, 0.0, 1.0, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;

	}

}