
package graph;

import java.util.List;

import javafx.scene.paint.Color;
import mvc.Subject;

/**
 * The Class Graph.
 * @author matheo
 */
public class Graph extends Subject{
	
	/** The amount of faces. */
	protected int nbFaces;

	/** The list of faces */
	protected List<Face> faces;
	
	/** The matrix */
	protected Matrix matrix;
	
	/** The Original matrix for the reset. */
	protected Matrix originalMatrix;
	
	/** The ListOfFaces (String). */
	protected List<String> listOfFaces;
	
	/** The color of the model. */
	protected Color color;
	
	/** The author. */
	protected String author = "";
	
	/**
	 * Instantiates a new graph.
	 *
	 * @param nbFace the amount of faces
	 * @param faces the list of face
	 * @param matrix 
	 * @param listOfFaces the list of faces (String)
	 * @param author the author
	 */
	public Graph(int nbFace, List<Face> faces, Matrix matrix, List<String> listOfFaces, String author) {
		this.originalMatrix = matrix;
		this.matrix = matrix;
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
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		if(author.equals("")) {
			return "anonymous";
		}else {
			return this.author;			
		}
	}
	
	/**
	 * Gets the amount of vertices.
	 *
	 * @return the amount of vertices
	 */
	public int getNbVertex() {
		return this.faces.get(0).getNbVertex();
	}
	
	/**
	 * Adds a face.
	 *
	 * @param face a face
	 */
	public void addFace(Face face) {
		this.faces.add(face);
	}

	/**
	 * Gets the amount faces.
	 *
	 * @return the amount faces
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
		String res =  "Face [nbVertices=" + this.nbFaces + ", Vertices= ";
		for (int i = 0; i<this.nbFaces-1; i++) {
			res+= this.faces.get(i)+" , ";
		}
		res+= this.faces.get(this.nbFaces-1) + " ]";
		return res;
	}
	
	/**
	 * Gets the matrix.
	 *
	 * @return the matrix
	 */
	public Matrix getMatrix() {
		return this.matrix;
	}
	
	/**
	 * Gets the original matrix.
	 *
	 * @return the original matrix
	 */
	public Matrix getOriginalMatrix() {
		return this.originalMatrix;
	}
	
	/**
	 * Gets the face XCoordinate.
	 *
	 * @param column the column 
	 * @param line the line
	 * @return the face X
	 */
	public double getFaceX(int column , int line) {
		return this.faces.get(column).getVertex().get(line).getX();
	}
	
	/**
	 * Gets the face YCoordinate.
	 *
	 * @param column the column
	 * @param line the line
	 * @return the face Y
	 */
	public double getFaceY(int column , int line) {
		return this.faces.get(column).getVertex().get(line).getY();
	}
	
	/**
	 * Gets the face ZCoordinate.
	 *
	 * @param column the column
	 * @param line the line
	 * @return the face Z
	 */
	public double getFaceZ(int column , int line) {
		return this.faces.get(column).getVertex().get(line).getZ();
	}
	
	/**
	 * Gets a face from the list of faces (string).
	 *
	 * @param index the index
	 * @return a face from the list of faces
	 */
	public String getListOfFaces(int index) {
		return listOfFaces.get(index);
	}
	
	/**
	 * Gets the list of faces (String).
	 *
	 * @return the list of faces
	 */
	public List<String> getListOfFaces() {
		return listOfFaces;
	}
	

}
