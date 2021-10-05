package graph;

public class Color {
	private int r,g,b;
	
	public Color(int[] rgbTab) {
		this.r = rgbTab[0];
		this.g = rgbTab[1];
		this.b = rgbTab[2];
	}

	public Color(int i, int j, int k) {
		this.r = i;
		this.g = j;
		this.b = k;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	@Override
	public String toString() {
		return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
	}
	
	
}
