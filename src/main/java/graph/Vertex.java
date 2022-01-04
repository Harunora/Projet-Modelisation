package graph;

/**
 * The Class Sommet.
 */
public class Vertex {
	
	/** The z. */
	private double xCoordinate,yCoordinate,zCoordinate;
	
	/**
	 * Instantiates a new sommet.
	 *
	 * @param xCoordinate the x
	 * @param yCoordinate the y
	 * @param zCoordinate the z
	 */
	//Un Sommet est un points avec 3 coordonnée x, y et z 
	public Vertex(double xCoordinate, double yCoordinate, double zCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.zCoordinate = zCoordinate;
	}
	
	/**
	 * Instantiates a new sommet.
	 *
	 * @param tabXyz the tab xyz
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
