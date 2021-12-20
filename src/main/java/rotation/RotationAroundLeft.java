package rotation;

import graph.Matrice;

/**
 * The Class RotationAroundLeft.
 */
public class RotationAroundLeft extends Mouvement {
	
	/**
	 * Instantiates a new rotation around left.
	 *
	 * @param m the m
	 * @param r the r
	 */
	public RotationAroundLeft(Matrice m, Mouvement r) {
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
		newMatrice.add( Math.cos(sensibility),Math.sin(sensibility), 0.0, 0.0);
		newMatrice.add( (-1.0)*Math.sin(sensibility), Math.cos(sensibility), 0.0, 0.0);
		newMatrice.add(0.0, 0.0, 1.0, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;

	}
}
