package graph;

/**
 * The Class Sommet.
 * 
 * @author matheo
 */
public class Vertex {
	
	/** all the coordinate of the vertex */
	private double xCoordinate,yCoordinate,zCoordinate;
	
	/**
	 * Instantiates a new vertex.
	 *
	 * @param xCoordinate the x
	 * @param yCoordinate the y
	 * @param zCoordinate the z
	 */
	public Vertex(double xCoordinate, double yCoordinate, double zCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.zCoordinate = zCoordinate;
	}
	
	/**
	 * Instantiates a new vertex.
	 *
	 * @param tabXyz the tab of all the coordinates
	 */
	public Vertex(double[] tabXyz) {
		xCoordinate = tabXyz[0];
		yCoordinate = tabXyz[1];
		zCoordinate = tabXyz[2];
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return xCoordinate;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return yCoordinate;
	}

	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public double getZ() {
		return zCoordinate;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "[ "+this.xCoordinate+" , "+this.yCoordinate + " , "+this.zCoordinate+" ]";
	}
	
}
