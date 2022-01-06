package rotation;

import graph.Matrix;

/**
 * the class RotationLeft.
 * 
 * @author Julien Lalloyer
 */
public class RotationLeft extends Mouvement {

	/**
	 * create a new rotation (left)
	 *
	  * @param matrix the current matrix
	 * @param mouvement the mouvement to applied
	 */
	public RotationLeft(Matrix matrice, Mouvement mouvement) {
		super(matrice, mouvement);
	}

	/**
	 * Do the rotation
	 *
	 * @param sensibility the sensibility of the rotation
	 * @return the matrix after the rotation
	 */
	@Override
	public Matrix mouvement(double sensibility) {
		Matrix newMatrix = new Matrix(4, 4);
		newMatrix.add(Math.cos(sensibility), 0.0, (-1.0) * Math.sin(sensibility), 0.0);
		newMatrix.add(0.0, 1.0, 0.0, 0.0);
		newMatrix.add(Math.sin(sensibility), 0.0, Math.cos(sensibility), 0.0);
		newMatrix.add(0.0, 0.0, 0.0, 1.0);
		this.currentMatrix = multipliMatrix(newMatrix);

		return currentMatrix;
	}

}