package graph;


public class Matrice {
	int idx = 0;
	int taille;
	double[] x ;
	double[] y ;
	double[] z ;
	double[] v;


	public Matrice(int nbSommets, int nbFaces) {
		this.taille = nbSommets;
		this.x = new double[taille];
		this.y =new double[taille];
		this.z =new double[taille];
		this.v =new double[taille];
	}
	
	
	public void add(Sommet f) {
				System.out.println();
				x[idx] = f.getX();
				y[idx] = f.getY();
				z[idx] = f.getZ();
				v[idx] = 1;
			idx ++;
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i<taille; i++) {
			res += "x : "+ x[i] + ", y : " + y[i] + ", z : " + z[i]+ ", v : "+ v[i]+ "\n"; 
		}
		return res;
	}
}
