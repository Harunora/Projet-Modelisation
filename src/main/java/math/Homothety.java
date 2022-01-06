package math;

import graph.Matrix;
import rotation.Mouvement;


/**
 * the classe Homothety for zoom the model
 * 
 * @author matheo
 */
public class Homothety extends Mouvement {
	
	/** the current matrix */
	private Matrix currentMatrix;
	
	/**
	 * create the homothety with the current matrix
	 *
	 * @param matrix the current matrix
	 */
	public Homothety(Matrix matrix) {
		super(matrix, null);
	}

	/**
	 * return the current matrix.
	 *
	 * @return the current matrix
	 */
	public Matrix getCurrentMatrix() {
		return this.currentMatrix;
	}

	/**
	 * Mouvement.
	 *
	 * @param sensibility the sensibility of the zoom
	 * @return the currentMatrix after the zoom
	 */
	@Override
	public Matrix mouvement(double sensibility) {
		Matrix newMatrice = new Matrix(4, 4);
		newMatrice.add( sensibility,0.0, 0.0, 0.0);
		newMatrice.add( 0.0, sensibility, 0.0, 0.0);
		newMatrice.add(0.0, 0.0, sensibility, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.currentMatrix = multipliMatrix(newMatrice);

		return currentMatrix;
	}
}
