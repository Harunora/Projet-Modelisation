package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UpdateGraph extends Graph{


	private List<Sommet> sommets = new ArrayList<Sommet>();
	protected int nb,a,b,c,d,r,g,bl;



	public UpdateGraph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces, String auteur) {
		super(nbFace, faces, matrice, sommetDeFaces, auteur);

	}
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
		List<Sommet> tmp = new ArrayList<Sommet>();
		addListSommet(tmp);
		Face faceTmp = new Face(nb, tmp, color);
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
