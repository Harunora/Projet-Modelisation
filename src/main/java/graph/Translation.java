package graph;

public class Translation {
	protected Matrice mcourante;
	protected int x = 0;
	protected int y = 0;
	
	public Translation(Matrice m, int x, int y) {
		mcourante = m;
		this.x = x;
		this.y = y;
	}
	
	public Matrice translate() {
	for(int i = 0; i<mcourante.taille; i++) {
		mcourante.x[i] += x*0.1;
		mcourante.y[i] += y*0.1;
	}
		return mcourante;
	}
	

	public Matrice getMcourante() {
		return this.mcourante;
	}
}
