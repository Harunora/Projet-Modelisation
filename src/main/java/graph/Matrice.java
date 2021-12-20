package graph;


/**
 * The Class Matrice.
 */
public class Matrice {
	
	/** The idx. */
	private int idx = 0;
	
	/** The taille. */
	private int taille;
	
	/** The x. */
	private double[] x ;
	
	/** The y. */
	private double[] y ;
	
	/** The z. */
	private double[] z ;
	
	/** The v. */
	private double[] v;


	/**
	 * Instantiates a new matrice.
	 *
	 * @param nbSommets the nb sommets
	 * @param nbFaces the nb faces
	 */
	public Matrice(int nbSommets, int nbFaces) {
		this.taille = nbSommets;
		this.x = new double[taille];
		this.y =new double[taille];
		this.z =new double[taille];
		this.v =new double[taille];
	}
	
	/**
	 * Instantiates a new matrice.
	 *
	 * @param nbSommets the nb sommets
	 * @param nbFaces the nb faces
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param v the v
	 */
	public Matrice(int nbSommets, int nbFaces, double x, double y, double z, double v) {
		this.taille = nbSommets;
		this.x = new double[taille];
		this.y =new double[taille];
		this.z =new double[taille];
		this.v =new double[taille];
		this.x[idx] = x;
		this.y[idx] = y;
		this.z[idx] = z;
		this.v[idx] = v;
		idx ++;
	}
	
	/**
	 * Adds the.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param v the v
	 */
	public void add(double x, double y, double z, double v) {
		this.x[idx] = x;
		this.y[idx] = y;
		this.z[idx] = z;
		this.v[idx] = v;
		idx ++;
	}
	
	/**
	 * Update.
	 */
	public void update() {
		for(int i = 0; i<taille; i++) {
			x[i] = x[i]*z[i];
			y[i] = y[i]*z[i];
		    z[i] = z[i]*z[i];
		}
	}
	
	/**
	 * Adds the.
	 *
	 * @param f the f
	 */
	public void add(Sommet f) {
		this.add(f.getX(),f.getY(),f.getZ(), 1);
	}
	
	/**
	 * Gets the x.
	 *
	 * @param idplace the idplace
	 * @return the x
	 */
	public double getX(int idplace) {
		return x[idplace];
	}
	
	/**
	 * Gets the y.
	 *
	 * @param idplace the idplace
	 * @return the y
	 */
	public double getY(int idplace) {
		return y[idplace];
	}
	
	/**
	 * Gets the z.
	 *
	 * @param idplace the idplace
	 * @return the z
	 */
	public double getZ(int idplace) {
		return z[idplace];
	}
	
	/**
	 * Gets the v.
	 *
	 * @param idplace the idplace
	 * @return the v
	 */
	public double getV(int idplace) {
		return v[idplace];
	}
	
	/**
	 * Modifie X.
	 *
	 * @param idplace the idplace
	 * @param addX the add X
	 */
	public void modifieX(int idplace,double addX) {
		this.x[idplace]+=addX;
	}
	
	/**
	 * Modifie Y.
	 *
	 * @param idplace the idplace
	 * @param addY the add Y
	 */
	public void modifieY(int idplace,double addY) {
		this.y[idplace]+=addY;
	}
	
	/**
	 * Modifie Z.
	 *
	 * @param idplace the idplace
	 * @param addZ the add Z
	 */
	public void modifieZ(int idplace,double addZ) {
		this.z[idplace]+=addZ;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String res = "";
		for(int i = 0; i<taille; i++) {
			res += "x : "+ x[i] + ", y : " + y[i] + ", z : " + z[i]+ ", v : "+ v[i]+ "\n"; 
		}
		return res;
	}
	
	/**
	 * Gets the taille.
	 *
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
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
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double[] getY() {
		return y;
	}

	/**
	 * Gets the z.
	 *
	 * @return the z
	 */
	public double[] getZ() {
		return z;
	}

	/**
	 * Gets the v.
	 *
	 * @return the v
	 */
	public double[] getV() {
		return v;
	}
	
	
}
