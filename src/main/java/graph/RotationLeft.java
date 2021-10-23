package graph;

public class RotationLeft extends Rotation {

	public RotationLeft(Matrice m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matrice rotate(double sensibility) {
		// bon
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add(Math.cos(sensibility), 0.0, (-1.0) * Math.sin(sensibility), 0.0);
		newMatrice.add(0.0, 1.0, 0.0, 0.0);
		newMatrice.add(Math.sin(sensibility), 0.0, Math.cos(sensibility), 0.0);
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;
	}

}
