package graph;


import java.util.ArrayList;
import java.util.List;

public class UpdateGraph {
	private int nbFaces = 0;
	private List<Sommet> sommets;
	private List<Face>faces;
	private List<String> sommetsDeFaces;
	Matrice matrice;




	public Graph Update(Graph graph, Matrice matrice) {
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
			String[] s1 = sommetsDeFaces.get(i).split(" ");
			int nb = Integer.getInteger(s1[0]);
			int x = Integer.getInteger(s1[1]);
			int y = Integer.getInteger(s1[2]);
			int z = Integer.getInteger(s1[3]);
			if(s1.length>4) {
				int r = Integer.getInteger(s1[4]);
				int g = Integer.getInteger(s1[5]);
				int b = Integer.getInteger(s1[6]);
				for(int j = 0; j<nb; j++) {
					List<Sommet> tmp = new ArrayList<Sommet>();
					tmp.add(new Sommet(x,y,z));
					Face faceTmp = new Face(nb, tmp,new Color(r,g,b));
					faces.add(faceTmp);
				}
			}else {
				for(int j = 0; j<nb; j++) {
					List<Sommet> tmp = new ArrayList<Sommet>();
					tmp.add(new Sommet(x,y,z));
					Face faceTmp = new Face(nb, tmp);
					faces.add(faceTmp);
				}
			}
		}
	}
}
