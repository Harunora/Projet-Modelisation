package graph;

public class RotationAroundLeft extends Rotation {
	public RotationAroundLeft(Matrice m, Rotation r) {
		super(m, r);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Matrice rotate(double sensibility) {
		// bon
		Matrice newMatrice = new Matrice(4, 4);
		newMatrice.add( Math.cos(sensibility),Math.sin(sensibility), 0.0, 0.0);
		newMatrice.add( (-1.0)*Math.sin(sensibility), Math.cos(sensibility), 0.0, 0.0);
		newMatrice.add(0.0, 0.0, 1.0, 0.0);		
		newMatrice.add(0.0, 0.0, 0.0, 1.0);
		this.mcourante = multipliMatrice(newMatrice);

		return mcourante;

	}
}
