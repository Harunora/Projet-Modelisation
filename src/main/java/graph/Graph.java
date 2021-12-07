
package graph;

import java.util.List;

import javafx.scene.paint.Color;
import mvc.Subject;

public class Graph extends Subject{
	protected int nbFaces;
	protected List<Face> faces;
	protected Matrice matrice;
	protected Matrice matriceOriginal;
	protected List<String> sommetsDeFaces;
	protected Color color;
	protected String auteur = "";
	
	public Graph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces, String auteur) {
		this.matriceOriginal = matrice;
		this.matrice = matrice;
		this.nbFaces = nbFace;
		this.faces = faces;
		this.sommetsDeFaces = sommetDeFaces;
		this.auteur = auteur;
		this.color = Color.WHITE;
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
