
package graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import mvc.Subject;

/**
 * The Class Graph.
 */
public class Graph extends Subject{
	
	/** The nb faces. */
	protected int nbFaces;
	
	/** The faces. */
	protected List<Face> faces;
	
	/** The matrice. */
	protected Matrice matrice;
	
	/** The matrice original. */
	protected Matrice matriceOriginal;
	
	/** The sommets de faces. */
	protected List<String> sommetsDeFaces;
	
	/** The color. */
	protected Color color;
	
	/** The auteur. */
	protected String auteur = "";
	
	/**
	 * Instantiates a new graph.
	 *
	 * @param nbFace the nb face
	 * @param faces the faces
	 * @param matrice the matrice
	 * @param sommetDeFaces the sommet de faces
	 * @param auteur the auteur
	 */
	public Graph(int nbFace, List<Face> faces, Matrice matrice, List<String> sommetDeFaces, String auteur) {
		this.matriceOriginal = matrice;
		this.matrice = matrice;
		this.nbFaces = nbFace;
		this.faces = faces;
		this.sommetsDeFaces = sommetDeFaces;
		this.auteur = auteur;
		this.color = this.faces.get(0).getColor();
	}
	
	/**
	 * Gets the face.
	 *
	 * @param i the i
	 * @return the face
	 */
	public Face getFace(int i) {
		return this.faces.get(i);
	}
	
	/**
	 * Gets the auteur.
	 *
	 * @return the auteur
	 */
	public String getAuteur() {
		if(auteur.equals("")) {
			return "anonymous";
		}else {
			return this.auteur;			
		}
	}
	
	/**
	 * Gets the nb sommet.
	 *
	 * @return the nb sommet
	 */
	public int getNbSommet() {
		return this.faces.get(0).getNbSommet();
	}
	
	/**
	 * Adds the face.
	 *
	 * @param f the f
	 */
	public void addFace(Face f) {
		this.faces.add(f);
	}

	/**
	 * Gets the nb faces.
	 *
	 * @return the nb faces
	 */
	public int getNbFaces() {
		return nbFaces;
	}

	/**
	 * Gets the faces.
	 *
	 * @return the faces
	 */
	public List<Face> getFaces() {
		return faces;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String res =  "Face [nbSommet=" + this.nbFaces + ", sommets= ";
		for (int i = 0; i<this.nbFaces-1; i++) {
			res+= this.faces.get(i)+" , ";
		}
		res+= this.faces.get(this.nbFaces-1) + " ]";
		return res;
	}
	
	/**
	 * Gets the matrice.
	 *
	 * @return the matrice
	 */
	public Matrice getMatrice() {
		return this.matrice;
	}
	
	/**
	 * Gets the matrice original.
	 *
	 * @return the matrice original
	 */
	public Matrice getMatriceOriginal() {
		return this.matriceOriginal;
	}
	
	/**
	 * Gets the face X.
	 *
	 * @param i the i
	 * @param j the j
	 * @return the face X
	 */
	public double getFaceX(int i , int j) {
		return this.faces.get(i).getSommets().get(j).getX();
	}
	
	/**
	 * Gets the face Y.
	 *
	 * @param i the i
	 * @param j the j
	 * @return the face Y
	 */
	public double getFaceY(int i , int j) {
		return this.faces.get(i).getSommets().get(j).getY();
	}
	
	/**
	 * Gets the face Z.
	 *
	 * @param i the i
	 * @param j the j
	 * @return the face Z
	 */
	public double getFaceZ(int i , int j) {
		return this.faces.get(i).getSommets().get(j).getZ();
	}
	
	/**
	 * Gets the sommets de faces.
	 *
	 * @param i the i
	 * @return the sommets de faces
	 */
	public String getSommetsDeFaces(int i) {
		return sommetsDeFaces.get(i);
	}
	
	/**
	 * Gets the sommets de faces.
	 *
	 * @return the sommets de faces
	 */
	public List<String> getSommetsDeFaces() {
		return sommetsDeFaces;
	}
}
