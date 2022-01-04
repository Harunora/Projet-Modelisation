
package graph;

import java.util.List;

import javafx.scene.paint.Color;
import mvc.Subject;

/**
 * The Class Graph.
 */
public class Graph extends Subject{
	
	/** The nb faces. */
	protected int nbFaces;
	
	/**
	 * other graph for the views 
	 */	
	/** The faces. */
	protected List<Face> faces;
	
	/** The matrice. */
	protected Matrix matrix;
	
	/** The matrice original. */
	protected Matrix originalMatrix;
	
	/** The sommets de faces. */
	protected List<String> listOfFaces;
	
	/** The color. */
	protected Color color;
	
	/** The auteur. */
	protected String author = "";
	
	/**
	 * Instantiates a new graph.
	 *
	 * @param nbFace the nb face
	 * @param faces the faces
	 * @param matrice the matrice
	 * @param listOfFaces the sommet de faces
	 * @param author the auteur
	 */
	public Graph(int nbFace, List<Face> faces, Matrix matrice, List<String> listOfFaces, String author) {
		this.originalMatrix = matrice;
		this.matrix = matrice;
		this.nbFaces = nbFace;
		this.faces = faces;
		this.listOfFaces = listOfFaces;
		this.author = author;
		this.color = this.faces.get(0).getColor();
	}
	
	/**
	 * Gets the face.
	 *
	 * @param index the i
	 * @return the face
	 */
	public Face getFace(int index) {
		return this.faces.get(index);
	}
	
	public void setFaceColor(int index, Color color) {
		getFace(index).setColor(color);
	}
	
	/**
	 * Gets the auteur.
	 *
	 * @return the auteur
	 */
	public String getAuthor() {
		if(author.equals("")) {
			return "anonymous";
		}else {
			return this.author;			
		}
	}
	
	/**
	 * Gets the nb sommet.
	 *
	 * @return the nb sommet
	 */
	public int getNbVertex() {
		return this.faces.get(0).getNbVertex();
	}
	
	/**
	 * Adds the face.
	 *
	 * @param face the f
	 */
	public void addFace(Face face) {
		this.faces.add(face);
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
	public Matrix getMatrix() {
		return this.matrix;
	}
	
	/**
	 * Gets the matrice original.
	 *
	 * @return the matrice original
	 */
	public Matrix getOriginalMatrix() {
		return this.originalMatrix;
	}
	
	/**
	 * Gets the face X.
	 *
	 * @param column the i
	 * @param line the j
	 * @return the face X
	 */
	public double getFaceX(int column , int line) {
		return this.faces.get(column).getVertex().get(line).getX();
	}
	
	/**
	 * Gets the face Y.
	 *
	 * @param column the i
	 * @param line the j
	 * @return the face Y
	 */
	public double getFaceY(int column , int line) {
		return this.faces.get(column).getVertex().get(line).getY();
	}
	
	/**
	 * Gets the face Z.
	 *
	 * @param column the i
	 * @param line the j
	 * @return the face Z
	 */
	public double getFaceZ(int column , int line) {
		return this.faces.get(column).getVertex().get(line).getZ();
	}
	
	/**
	 * Gets the sommets de faces.
	 *
	 * @param index the index
	 * @return the sommets de faces
	 */
	public String getListOfFaces(int index) {
		return listOfFaces.get(index);
	}
	
	/**
	 * Gets the sommets de faces.
	 *
	 * @return the sommets de faces
	 */
	public List<String> getListOfFaces() {
		return listOfFaces;
	}
	

}
