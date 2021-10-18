package graph;


public class Matrice {
	protected int idx = 0;
	protected int taille;
	protected double[] x ;
	protected double[] y ;
	protected double[] z ;
	protected double[] v;


	public Matrice(int nbSommets, int nbFaces) {
		this.taille = nbSommets;
		this.x = new double[taille];
		this.y =new double[taille];
		this.z =new double[taille];
		this.v =new double[taille];
	}
	
	public void add(double x, double y, double z, double v) {
		this.x[idx] = x;
		this.y[idx] = y;
		this.z[idx] = z;
		this.v[idx] = v;
		idx ++;
	}
	public void add(Sommet f) {
		this.add(f.getX(),f.getY(),f.getZ(), 1);
	}
	
	public double getX(int idplace) {
		return x[idplace];
	}
	public double getY(int idplace) {
		return y[idplace];
	}
	public double getZ(int idplace) {
		return z[idplace];
	}
	public double getV(int idplace) {
		return v[idplace];
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i<taille; i++) {
			res += "x : "+ x[i] + ", y : " + y[i] + ", z : " + z[i]+ ", v : "+ v[i]+ "\n"; 
		}
		return res;
	}
	
	public int getTaille() {
		return taille;
	}
}
