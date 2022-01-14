package graph;


/**
 * The Class Matrix.
 * 
 * @author matheo
 */
public class Matrix {
	
	
	private int idx = 0, length;
	
	
	private double[] xCoordinate , yCoordinate , zCoordinate , vector;


	/**
	 * Instantiates a new matrix.
	 *
	 * @param nbVertex the amount of vertex
	 * @param nbFaces the amount of faces
	 */
	public Matrix(int nbVertex, int nbFaces) {
		this.length = nbVertex;
		this.xCoordinate = new double[length];
		this.yCoordinate =new double[length];
		this.zCoordinate =new double[length];
		this.vector =new double[length];
	}
	
	/**
	 * Instantiates a new matrix.
	 *
	 * @param nbVertex the amount of vertices
	 * @param xCoordinate the xCoordinate 
	 * @param yCoordinate the yCoordinate
	 * @param zCoordinate the zCoordinate
	 * @param vector the vector 
	 */
	public Matrix(int nbVertex, double xCoordinate, double yCoordinate, double zCoordinate, double vector) {
		this.length = nbVertex;
		this.xCoordinate = new double[length];
		this.yCoordinate =new double[length];
		this.zCoordinate =new double[length];
		this.vector =new double[length];
		this.xCoordinate[idx] = xCoordinate;
		this.yCoordinate[idx] = yCoordinate;
		this.zCoordinate[idx] = zCoordinate;
		this.vector[idx] = vector;
		idx ++;
	}
	
	/**
	 * Adds the a new point to the matrix.
	 *
	 * @param xCordinate the xCoordinate
	 * @param yCordinate the yCoordinate
	 * @param zCordinate the zCoordinate
	 * @param vector the v
	 */
	public void add(double xCoordinate, double yCoordinate, double zCoordinate, double vector) {
		this.xCoordinate[idx] = xCoordinate;
		this.yCoordinate[idx] = yCoordinate;
		this.zCoordinate[idx] = zCoordinate;
		this.vector[idx] = vector;
		idx ++;
	}

	public void add(Vertex vertex) {
		this.add(vertex.getX(),vertex.getY(),vertex.getZ(), 1);
	}
	
	/**
	 * Gets the xCoordinate.
	 *
	 * @param index the idplace
	 * @return the x
	 */
	public double getX(int index) {
		return xCoordinate[index];
	}
	
	/**
	 * Gets the yCoordinate.
	 *
	 * @param index the idplace
	 * @return the y
	 */
	public double getY(int index) {
		return yCoordinate[index];
	}
	
	/**
	 * Gets the zCoordinate.
	 *
	 * @param index the index
	 * @return the z
	 */
	public double getZ(int index) {
		return zCoordinate[index];
	}
	
	/**
	 * Gets the vector.
	 *
	 * @param idplace the index
	 * @return the vector
	 */
	public double getV(int idplace) {
		return vector[idplace];
	}
	
	/**
	 * update the x coordinate .
	 *
	 * @param index the index
	 * @param addX the new X coordinate
	 */
	public void changeXCoordinate(int index,double addX) {
		this.xCoordinate[index]+=addX;
	}
	
	/**
	 * Modifie Y.
	 *
	 * @param index the idplace
	 * @param addY the add Y
	 */
	public void changeYCoordinate(int index,double addY) {
		this.yCoordinate[index]+=addY;
	}
	
	/**
	 * Modifie Z.
	 *
	 * @param index the idplace
	 * @param addZ the add Z
	 */
	public void changeZCoordinate(int index,double addZ) {
		this.zCoordinate[index]+=addZ;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String res = "";
		for(int i = 0; i<length; i++) {
			res += "x : "+ xCoordinate[i] + ", y : " + yCoordinate[i] + ", z : " + zCoordinate[i]+ ", v : "+ vector[i]+ "\n"; 
		}
		return res;
	}
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Gets the idx.
	 *
	 * @return the idx
	 */
	public int getIdx() {
		return idx;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double[] getX() {
		return xCoordinate;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double[] getY() {
		return yCoordinate;
	}

	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public double[] getZ() {
		return zCoordinate;
	}

	/**
	 * Gets the v.
	 *
	 * @return the v
	 */
	public double[] getV() {
		return vector;
	}
	
	
}
