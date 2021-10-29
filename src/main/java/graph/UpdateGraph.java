package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UpdateGraph extends Graph{
	public UpdateGraph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces) {
		super(nbFace, faces, matrice, sommetDeFaces);

	}
	/*
	private int nbFaces = 0;
	private List<Face>faces = new ArrayList<Face>();
	private List<String> sommetsDeFaces;
	Matrice matrice;
	 */
	private List<Sommet> sommets = new ArrayList<Sommet>();
	int nb,a,b,c,d,r,g,bl;


	public void update(Matrice ma) {
		matrice = ma;
		faces.clear();
		for(int i = 0; i<matrice.taille; i++) {
			sommets.add(new Sommet(matrice.getX(i),matrice.getY(i),matrice.getZ(i)));
		}
		readFace();	

	}

	private void readFace() {
		for(int i = 0; i<nbFaces; i++) {
			readNbFace(i);
		}
	}

	private void readNbFace(int i) {
		StringTokenizer lineToken = new StringTokenizer(sommetsDeFaces.get(i));
		nb = Integer.parseInt(lineToken.nextToken());
		a = Integer.parseInt(lineToken.nextToken());
		b = Integer.parseInt(lineToken.nextToken());
		c = Integer.parseInt(lineToken.nextToken());
		if(nb==4) {
			d = Integer.parseInt(lineToken.nextToken());			
		}
		if(lineToken.hasMoreElements()) {
			r = Integer.parseInt(lineToken.nextToken());
			g = Integer.parseInt(lineToken.nextToken());
			bl = Integer.parseInt(lineToken.nextToken());
			addFaceColor();

		}else {
			List<Sommet> tmp = new ArrayList<Sommet>();
			addListSommet(tmp);
			Face faceTmp = new Face(nb, tmp);
			faces.add(faceTmp);
		}
	}

	private void addFaceColor() {
		List<Sommet> tmp = new ArrayList<Sommet>();
		addListSommet(tmp);
		Face faceTmp = new Face(nb, tmp,new Color(r,g,bl));
		faces.add(faceTmp);
		
	}

	private void addListSommet(List<Sommet> tmp) {
		tmp.add(sommets.get(a));
		tmp.add(sommets.get(b));
		tmp.add(sommets.get(c));
		if(nb == 4) {
			tmp.add(sommets.get(d));			
		}
	}
}
