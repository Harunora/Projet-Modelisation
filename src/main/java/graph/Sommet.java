package graph;

public class Sommet {
	private double x,y,z;
	private Color color;
	
	//Un Sommet est un points avec 3 coordonnée x, y et z 
	public Sommet(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.color = null;
	}
	
	public Sommet(double x, double y, double z, Color color) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.color = color;
	}
	
	public Sommet(double[] tabXyz) {
		x = tabXyz[0];
		y = tabXyz[1];
		z = tabXyz[2];
		this.color = null;
	}

	public Sommet(double[] tabXyz, Color color) {
		x = tabXyz[0];
		y = tabXyz[1];
		z = tabXyz[2];
		this.color = color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
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
