package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	int nbFaces;
	List<Face> faces;
	Matrice matrice = new Matrice(faces);
	
	public Graph(int nbFace, List<Face> faces) {
		this.nbFaces = nbFace;
		this.faces = faces;
	}
	
	public Graph(int nbFace) {
		this(nbFace, new ArrayList<Face>());
	}
	
	public int getNbSommet() {
		return this.faces.get(0).getNbSommet();
	}
	
	public void addFace(Face f) {
		this.faces.add(f);
	}

	public int getNbFaces() {
		return nbFaces;
	}

	public List<Face> getFaces() {
		return faces;
	}
	
	public String toString() {
		String res =  "Face [nbSommet=" + this.nbFaces + ", sommets= ";
		for (int i = 0; i<this.nbFaces-1; i++) {
			res+= this.faces.get(i)+" , ";
		}
		res+= this.faces.get(this.nbFaces-1) + " ]";
		return res;
	}
}
