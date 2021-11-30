
package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	protected int nbFaces;
	protected List<Face> faces;
	protected Matrice matrice;
	protected Matrice matriceOriginal;
	protected List<String> sommetsDeFaces;
	protected javafx.scene.paint.Color color;
	protected String auteur = "";
	
	public Graph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces, String auteur) {
		this.matriceOriginal = matrice;
		this.matrice = matrice;
		this.nbFaces = nbFace;
		this.faces = faces;
		this.sommetsDeFaces = sommetDeFaces;
		this.auteur = auteur;
	}
	
	public void setColor(javafx.scene.paint.Color colo) {
		this.color = colo;
		for(int i = 0; i< this.nbFaces; i++) {
			faces.get(i).setColor(this.color);
		}
	}
	
	public Face getFace(int i) {
		return this.faces.get(i);
	}
	
	public String getAuteur() {
		if(auteur.equals("")) {
			return "anonymous";
		}else {
			return this.auteur;			
		}
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
	
	public Matrice getMatrice() {
		return this.matrice;
	}
	
	public Matrice getMatriceOriginal() {
		return this.matriceOriginal;
	}
	
	public double getFaceX(int i , int j) {
		return this.faces.get(i).getSommets().get(j).getX();
	}
	
	public double getFaceY(int i , int j) {
		return this.faces.get(i).getSommets().get(j).getY();
	}
	
	public double getFaceZ(int i , int j) {
		return this.faces.get(i).getSommets().get(j).getZ();
	}
	public String getSommetsDeFaces(int i) {
		return sommetsDeFaces.get(i);
	}
	
	public List<String> getSommetsDeFaces() {
		return sommetsDeFaces;
	}
}
