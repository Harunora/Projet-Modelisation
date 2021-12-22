package math;

import graph.Matrice;
import rotation.Mouvement;


/**
 * La classe Homothetie derivee de Mouvement.
 */
public class Homothetie extends Mouvement {
	
	/** La matrice courante. */
	private Matrice matriceCourante;
	
	/**
	 * Instantie une nouvelle homothetie.
	 *
	 * @param matrice la matrice
	 */
	public Homothetie(Matrice matrice) {
		super(matrice, null);
	}

	/**
	 * Prendre la matrice courante.
	 *
	 * @return la matrice courante
	 */
	public Matrice getMcourante() {
		return this.matriceCourante;
	}

	/**
	 * Mouvement.
	 *
	 * @param sensibility la sensibilitee
	 * @return la matrice apres l'homothetie
	 */
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
