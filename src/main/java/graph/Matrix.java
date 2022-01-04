package graph;


/**
 * The Class Matrice.
 */
public class Matrix {
	
	/** The idx. */
	private int idx = 0;
	
	/** The taille. */
	private int length;
	
	/** The x. */
	private double[] xCoordinate ;
	
	/** The y. */
	private double[] yCoordinate ;
	
	/** The z. */
	private double[] zCoordinate ;
	
	/** The v. */
	private double[] vector;


	/**
	 * Instantiates a new matrice.
	 *
	 * @param nbVertex the nb sommets
	 * @param nbFaces the nb faces
	 */
	public Matrix(int nbVertex, int nbFaces) {
		this.length = nbVertex;
		this.xCoordinate = new double[length];
		this.yCoordinate =new double[length];
		this.zCoordinate =new double[length];
		this.vector =new double[length];
	}
	
	/**
	 * Instantiates a new matrice.
	 *
	 * @param nbVertex the nb sommets
	 * @param nbFaces the nb faces
	 * @param xCoordinate the x
	 * @param yCoordinate the y
	 * @param zCoordinate the z
	 * @param vector the v
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
	 * Adds the.
	 *
	 * @param xCordinate the x
	 * @param yCordinate the y
	 * @param zCordinate the z
	 * @param vector the v
	 */
	public void add(double xCoordinate, double yCoordinate, double zCoordinate, double vector) {
		this.xCoordinate[idx] = xCoordinate;
		this.yCoordinate[idx] = yCoordinate;
		this.zCoordinate[idx] = zCoordinate;
		this.vector[idx] = vector;
		idx ++;
	}
	
	/**
	 * Update.
	 */
	public void update() {
		for(int i = 0; i<length; i++) {
			xCoordinate[i] = xCoordinate[i]*zCoordinate[i];
			yCoordinate[i] = yCoordinate[i]*zCoordinate[i];
		    zCoordinate[i] = zCoordinate[i]*zCoordinate[i];
		}
	}
	
	/**
	 * Adds the.
	 *
	 * @param sommet the f
	 */
	public void add(Vertex sommet) {
		this.add(sommet.getX(),sommet.getY(),sommet.getZ(), 1);
	}
	
	/**
	 * Gets the x.
	 *
	 * @param idplace the idplace
	 * @return the x
	 */
	public double getX(int idplace) {
		return xCoordinate[idplace];
	}
	
	/**
	 * Gets the y.
	 *
	 * @param idplace the idplace
	 * @return the y
	 */
	public double getY(int idplace) {
		return yCoordinate[idplace];
	}
	
	/**
	 * Gets the z.
	 *
	 * @param idplace the idplace
	 * @return the z
	 */
	public double getZ(int idplace) {
		return zCoordinate[idplace];
	}
	
	/**
	 * Gets the v.
	 *
	 * @param idplace the idplace
	 * @return the v
	 */
	public double getV(int idplace) {
		return vector[idplace];
	}
	
	/**
	 * Modifie X.
	 *
	 * @param idplace the idplace
	 * @param addX the add X
	 */
	public void modifieX(int idplace,double addX) {
		this.xCoordinate[idplace]+=addX;
	}
	
	/**
	 * Modifie Y.
	 *
	 * @param idplace the idplace
	 * @param addY the add Y
	 */
	public void modifieY(int idplace,double addY) {
		this.yCoordinate[idplace]+=addY;
	}
	
	/**
	 * Modifie Z.
	 *
	 * @param idplace the idplace
	 * @param addZ the add Z
	 */
	public void modifieZ(int idplace,double addZ) {
		this.zCoordinate[idplace]+=addZ;
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
	 * Gets the taille.
	 *
	 * @return the taille
	 */
	public int getTaille() {
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
