package graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * The Class Face.
 * @author matheo
 */
public class Face implements Comparable<Face> {
	
	/** The color of the face */
	protected javafx.scene.paint.Color color;
	
	/** amount of vertice of the face. */
	protected int nbvertices;
	
	/** the list of all the vertices */
	protected List<Vertex> vertices;
	
	/** The Highest Z Coordinate. */
	protected double highestZ;
	
	/**
	 * Instantiates a new face.
	 *
	 * @param number the amount of vertices
	 * @param vertices the list of all vertices
	 * @param color the color of the face
	 */
	public Face(int number, List<Vertex> vertices, javafx.scene.paint.Color color) {
		this.color = color;
		nbvertices = number;
		this.vertices = vertices;	
		this.highestZ=findHighestZ();	
		
	}
	
	/**
	 * Instantiates a new face.
	 *
	 * @param number the amount of vertices
	 * @param color the color of the face
	 */
	public Face(int number, Color color) {
		this(number,new ArrayList<Vertex>(), color);
	}
	
	/**
	 * Instantiates a new face.
	 *
	 * @param number the amount of vertices
	 */
	public Face(int number ) {
		this(number, null);
	}
	
	

	/**
	 * Sets the color of the face
	 *
	 * @param color2 the new color
	 */
	public void setColor(javafx.scene.paint.Color color2) {
		this.color = color2;
	}
	
	/**
	 * Adds the vertex.
	 *
	 * @param veretx the new vertex to add
	 */
	public void addVertex(Vertex vertex) {
		this.vertices.add(vertex);
	}

	/**
	 * Gets the amount of vertices.
	 *
	 * @return the amount of vertices 
	 */
	public int getNbVertex() {
		return nbvertices;
	}

	/**
	 * Gets the list of all vertices.
	 *
	 * @return all the vertice in an ArrayList
	 */
	public List<Vertex> getVertex() {
		return vertices;
	}
	
	/**
	 * Gets the color of the face.
	 *
	 * @return the color
	 */
	public javafx.scene.paint.Color getColor() {
		return this.color;
	}
	
	/**
	 * Gets the color red.
	 *
	 * @return the red value of the color 
	 */
	public double getRed() {
		return this.color.getRed();
	}
	
	/**
	 * Gets the color green.
	 *
	 * @return the green value of the color
	 */
	public double getGreen() {
		return this.color.getGreen();
	}
	
	/**
	 * Gets the color blue.
	 *
	 * @return the blue value of the color
	 */
	public double getBlue() {
		return this.color.getBlue();
	}
	
	/**
	 * Checks if the face has a color.
	 *
	 * @return true, if the face is colored
	 */
	public boolean hasColor() {
		return this.color == null;
	}

	/**
	 * To string.
	 *
	 * @return the string of the color , the amount of vertices and the list of vertices
	 */
	@Override
	public String toString() {
		return "Face [color=" + color + ", nbVertices=" + nbvertices + ", ListOfVertices =" + vertices.toString()+ "]";
	}

	/**
	 * Find the highest Z Coordinate.
	 *
	 * @return the Highest Z Coordinate in double
	 */
	private double findHighestZ(){
		double result=this.vertices.get(0).getZ();
		for(int i=1;i<this.getNbVertex();i++){
			if(this.vertices.get(i).getZ()>result){
				result=this.vertices.get(i).getZ();
			}
		}
		return result;
	}

	/**
	 * Gets the heightest Z Coordinate.
	 *
	 * @return the heightest Z Coordinate
	 */
	public double getHeightestZ(){
		return this.highestZ;
	}

	
	/**
	 * Compare to.
	 *
	 * @param face the face
	 * @return the int
	 */
	@Override
	public int compareTo(Face face) {
		if(this.getHeightestZ()>face.getHeightestZ()){
			return 1;
		}else if(this.getHeightestZ()<face.getHeightestZ()){
			return -1;
		}else{
			return 0;
		}
	}
}
