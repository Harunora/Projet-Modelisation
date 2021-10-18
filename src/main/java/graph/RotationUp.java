package graph;

public class RotationUp extends Rotation {

	public RotationUp(Matrice m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matrice rotate(double sensibility) {
		// a regarder
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(1.0, 0.0, 0.0, 0.0);
		newMatrice.add(0.0, Math.cos(sensibility), Math.sin(sensibility), 0);
		newMatrice.add(0.0, (-1.0) * Math.sin(sensibility), Math.cos(sensibility), 0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.matrice = multipliMatrice(matrice, newMatrice);

		return matrice;
	}

}
