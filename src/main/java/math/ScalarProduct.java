package math;

import graph.Matrix;
import graph.Vertex;

/**
 * The Class ProduitScalaire.
 * 
 * @author Julien Lalloyer
 */
public class ScalarProduct {	
	
	/** the matrix */
	protected Matrix matrix;
	
	/**
	 * create the scalar product with the current matrix
	 *
	 * @param matrix the matrix
	 */
	public ScalarProduct(Matrix matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * create the scalar product with a new matrix
	 *
	 * @param vertex1 the first vertex to make the matrix
	 * @param vertex2 the second vertex to make the matrix
	 */
	public ScalarProduct(Vertex vertex1, Vertex vertex2) {
		matrix = new Matrix(1,1);
		matrix.add(vertex2.getX() - vertex1.getX(), vertex2.getY() - vertex1.getY(), vertex2.getZ() - vertex1.getZ(), 1);
	}
	
	/**
	 * Look if we can make a scalar product in the matrix
	 *
	 * @param matrix the current matrix
	 * @return true if we can make a scalar product
	 */
	public boolean verifProd(Matrix matrix) {
		
		return this.matrix.getLength() == matrix.getLength();
	}
	
	/**
	 * make the scalar product in the current matrix
	 *
	 * @param matrix the current matrix
	 */
	public void prodScal(Matrix matrix) {
		Matrix res;
		if(verifProd(matrix)){
			res = calcScal(matrix);
		}else {
			res = new Matrix(1,1);
		}
		this.matrix  = res;
	}
	
	/**
	 * Do the scalar calculation
	 *
	 * @param matrix the current matrix used in the calculation 
	 * @return the scalar product of the two matrix
	 */
	public Matrix calcScal(Matrix matrix) {
		Matrix res = new Matrix(1,1);
		double coordX = this.matrix.getY(0) * matrix.getZ(0) - this.matrix.getZ(0) * matrix.getY(0);
		double coordY = this.matrix.getZ(0) * matrix.getX(0) - this.matrix.getX(0) * matrix.getZ(0);
		double coordZ = this.matrix.getX(0) * matrix.getY(0) - this.matrix.getY(0) * matrix.getX(0);
		res.add(coordX, coordY, coordZ, 1);
		return res;
	}

	/**
	 * return the martix
	 *
	 * @return the matrix
	 */
	public Matrix getMatrice() {
		// TODO Auto-generated method stub
		return matrix;
	}
}
