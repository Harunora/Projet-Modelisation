package rotation;

import graph.Matrix;

/**
 * The Class Rotation.
 * 
 * @author Julien Lalloyer
 */
public abstract class Mouvement {
	
	/** the currentMatrix. */
	protected Matrix currentMatrix;
	
	/** the mouvement */
	protected Mouvement movement;
	
	/**
	 * create a new mouvement
	 *
	 * @param matrix the current matrix
	 * @param mouvement the mouvement that will be applied 
	 */
	public Mouvement(Matrix matrix, Mouvement mouvement) {
		currentMatrix = matrix;
		this.movement = mouvement;
	}
	
	/**
	 * Do the mouvement
	 *
	 * @param sensibility the sensibility of the mouvement
	 * @return the matrix after the mouvement
	 */
	public abstract Matrix mouvement(double sensibility);
	
	/**
	 * Matrix Product
	 *
	 * @param matrixConvertor that we use to multiply the current one
	 * @return the new matrix
	 */
	public  Matrix multipliMatrix(Matrix matrixConvertor) {
		Matrix convertMatrix = new Matrix(currentMatrix.getLength(), currentMatrix.getLength());
		double coordX = 0.0;
		double coordY = 0.0;
		double coordZ = 0.0;
		double coordV = 0.0;
		for(int i = 0 ; i < currentMatrix.getLength();i++ ) {
			for(int j = 0; j < matrixConvertor.getLength(); j++) {
				switch(j) {
					case 0:
						coordX += matrixConvertor.getX(j) * currentMatrix.getX(i);
						coordY += matrixConvertor.getY(j) * currentMatrix.getX(i);
						coordZ += matrixConvertor.getZ(j) * currentMatrix.getX(i);
						coordV += matrixConvertor.getV(j) * currentMatrix.getX(i);
						break;
					case 1:
						coordX += matrixConvertor.getX(j) * currentMatrix.getY(i);
						coordY += matrixConvertor.getY(j) * currentMatrix.getY(i);
						coordZ += matrixConvertor.getZ(j) * currentMatrix.getY(i);
						coordV += matrixConvertor.getV(j) * currentMatrix.getY(i);
						break;
					case 2:
						coordX += matrixConvertor.getX(j) * currentMatrix.getZ(i);
						coordY += matrixConvertor.getY(j) * currentMatrix.getZ(i);
						coordZ += matrixConvertor.getZ(j) * currentMatrix.getZ(i);
						coordV += matrixConvertor.getV(j) * currentMatrix.getZ(i);
						break;
					case 3:
						coordX += matrixConvertor.getX(j) * currentMatrix.getV(i);
						coordY += matrixConvertor.getY(j) * currentMatrix.getV(i);
						coordZ += matrixConvertor.getZ(j) * currentMatrix.getV(i);
						coordV += matrixConvertor.getV(j) * currentMatrix.getV(i);
						break;
				}
			}
			convertMatrix.add(coordX, coordY, coordZ, coordV);
			coordX = 0.0;
			coordY = 0.0;
			coordZ = 0.0;
			coordV = 0.0;
		}
		this.currentMatrix = convertMatrix;
		return convertMatrix;
	}

	/**
	 * Take the current matrix
	 *
	 * @return the current matrix
	 */
	public Matrix getCurrentMatrix() {
		return currentMatrix;
	}

	/**
	 * Sets a new current matrix
	 *
	 * @param matrix the new current matrix
	 */
	public void setNewMatrix(Matrix matrix) {
		this.currentMatrix = matrix;
	}
	
	
}
