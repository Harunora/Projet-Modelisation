package graph;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UpdateGraph {
	private int nbFaces = 0;
	private List<Sommet> sommets = new ArrayList<Sommet>();
	private List<Face>faces = new ArrayList<Face>();
	private List<String> sommetsDeFaces;
	Matrice matrice;




	public Graph Update(Graph graph) {
		matrice = graph.getMatrice();
		nbFaces = graph.getNbFaces();
		sommetsDeFaces = graph.getSommetsDeFaces();
		for(int i = 0; i<matrice.taille; i++) {
			sommets.add(new Sommet(matrice.x[i],matrice.y[i],matrice.z[i]));
		}
		readFace();	



		return  new Graph(nbFaces, faces, matrice, sommetsDeFaces);
	}

	private void readFace() {
		for(int i = 0; i<nbFaces; i++) {
			StringTokenizer lineToken = new StringTokenizer(sommetsDeFaces.get(i));
			int nb = Integer.parseInt(lineToken.nextToken());
			int a = Integer.parseInt(lineToken.nextToken());
			int b = Integer.parseInt(lineToken.nextToken());
			int c = Integer.parseInt(lineToken.nextToken());
			int d = Integer.parseInt(lineToken.nextToken());
			if(lineToken.hasMoreElements()) {
				int r = Integer.parseInt(lineToken.nextToken());
				int g = Integer.parseInt(lineToken.nextToken());
				int bl = Integer.parseInt(lineToken.nextToken());
				for(int j = 0; j<nb; j++) {
					List<Sommet> tmp = new ArrayList<Sommet>();
					tmp.add(sommets.get(a));
					tmp.add(sommets.get(b));
					tmp.add(sommets.get(c));
					tmp.add(sommets.get(d));
					Face faceTmp = new Face(nb, tmp,new Color(r,g,bl));
					faces.add(faceTmp);
				}
			}else {
				for(int j = 0; j<nb; j++) {
					List<Sommet> tmp = new ArrayList<Sommet>();
					tmp.add(sommets.get(a));
					tmp.add(sommets.get(b));
					tmp.add(sommets.get(c));
					tmp.add(sommets.get(d));
					Face faceTmp = new Face(nb, tmp);
					faces.add(faceTmp);
				}
			}
		}
	}
}
