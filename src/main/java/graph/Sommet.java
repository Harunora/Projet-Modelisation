package graph;

/**
 * The Class Sommet.
 */
public class Sommet {
	
	/** The z. */
	private double x,y,z;
	
	/**
	 * Instantiates a new sommet.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	//Un Sommet est un points avec 3 coordonnée x, y et z 
	public Sommet(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Instantiates a new sommet.
	 *
	 * @param tabXyz the tab xyz
	 */
	public Sommet(double[] tabXyz) {
		x = tabXyz[0];
		y = tabXyz[1];
		z = tabXyz[2];
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "[ "+this.x+" , "+this.y + " , "+this.z+" ]";
	}
	
}
