package math;

import graph.Matrice;
import rotation.Mouvement;

/**
 * The Class Homothetie.
 */
public class Homothetie extends Mouvement {
	
	/** The matrice courante. */
	private Matrice matriceCourante;
	
	/**
	 * Instantiates a new homothetie.
	 *
	 * @param matrice the m
	 */
	public Homothetie(Matrice matrice) {
		super(matrice, null);
	}

	/**
	 * Gets the mcourante.
	 *
	 * @return the mcourante
	 */
	public Matrice getMcourante() {
		return this.matriceCourante;
	}

	@Override
	public Matrice mouvement(double sensibility) {
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add( sensibility,0.0, 0.0, 0.0);
		newMatrice.add( 0.0, sensibility, 0.0, 0.0);
		newMatrice.add(0.0, 0.0, sensibility, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.matriceCourante = multipliMatrice(newMatrice);

		return matriceCourante;
	}
}
