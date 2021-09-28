package graph;

public class Sommet {
	private float x,y,z;
	
	//Un Sommet est un points avec 3 coordonnée x, y et z 
	public Sommet(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}
	
	public String toString() {
		return "[ "+this.x+" , "+this.y + " , "+this.z+" ]";
	}
	
}
