package graph;

public class Sommet {
	private double x,y,z;
	
	//Un Sommet est un points avec 3 coordonnée x, y et z 
	public Sommet(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Sommet(double[] tabXyz) {
		x = tabXyz[0];
		y = tabXyz[1];
		z = tabXyz[2];
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public String toString() {
		return "[ "+this.x+" , "+this.y + " , "+this.z+" ]";
	}
	
}
