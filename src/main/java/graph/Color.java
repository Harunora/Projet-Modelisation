package graph;

public class Color {
	private double r,g,b;
	
	public Color(double[] rgbTab) {
		this.r = rgbTab[0];
		this.g = rgbTab[1];
		this.b = rgbTab[2];
	}

	public Color(double i, double j, double k) {
		this.r = i;
		this.g = j;
		this.b = k;
	}

	public int getR() {
		return (int)r;
	}

	public int getG() {
		return (int)g;
	}

	public int getB() {
		return (int)b;
	}

	@Override
	public String toString() {
		return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
	
	
}
