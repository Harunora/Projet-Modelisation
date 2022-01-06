package math;

import graph.Matrix;

/**
 * Translation.
 * 
 * @author matheo, julien
 */
public class Translation {
	
	/** the current matrix */
	protected Matrix currentMatrix;
	
	/**all the coordinates*/
	private double xCoordinate, zCoordinate, yCoordinate ;
	
	/**
	 * create a new translation
	 *
	 * @param matrix the matrix
	 */
	public Translation(Matrix matrix) {
		currentMatrix = matrix;
	}
	
	
	/**
	 * add the coordinate to the matrix
	 *
	 * @param coord_x the x that we add in the matrix 
	 * @param coord_y the y that we add in the matrix
	 * @param coord_z the z that we add in the matrix
	 * @return the matrix after the translation
	 */
	public  Matrix addToMatrice(double coordx, double coordy , double coordz) {
		Matrix matriceConverted = new Matrix(currentMatrix.getLength(),currentMatrix.getLength());
		for(int i = 0 ; i < currentMatrix.getLength(); i++) {
			xCoordinate =  currentMatrix.getX(i) + coordx;
			yCoordinate =  currentMatrix.getY(i) + coordy;
			zCoordinate =  currentMatrix.getZ(i) + coordz;
			matriceConverted .add(xCoordinate, yCoordinate, zCoordinate, currentMatrix.getV(i));
			xCoordinate = 0.0;
			yCoordinate = 0.0;
			zCoordinate = 0.0;
		}
		currentMatrix = matriceConverted;
		return currentMatrix;
	}
	
	/**
	 * Do the translation
	 *
	 * @param matrix the current matrix
	 * @return the matrix after the translation
	 */
	public Matrix translate(Matrix matrice) {
		this.addToMatrice(matrice.getX(0), matrice.getY(0),matrice.getZ(0));
		return this.getMcourante();

	}

	/**
	 * take the current matrix
	 *
	 * @return the current matrix
	 */
	public Matrix getMcourante() {
		return this.currentMatrix;
	}
}
