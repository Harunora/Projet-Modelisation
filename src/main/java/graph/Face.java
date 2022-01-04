package graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * The Class Face.
 */
public class Face implements Comparable<Face> {
	
	/** The color. */
	protected javafx.scene.paint.Color color;
	
	/** The nb sommet. */
	protected int nbvertices;
	
	/** The sommets. */
	protected List<Vertex> vertices;
	
	/** The Highest Z. */
	protected double highestZ;
	
	/**
	 * Instantiates a new face.
	 *
	 * @param n the n
	 * @param vertices the sommets
	 * @param color the color
	 */
	//Une face est une list de plusieurs Sommets
	public Face(int index, List<Vertex> vertices, javafx.scene.paint.Color color) {
		this.color = color;
		nbvertices = index;
		this.vertices = vertices;	
		this.highestZ=findHighestZ();	
		
	}
	
	/**
	 * Instantiates a new face.
	 *
	 * @param n the n
	 * @param c the c
	 */
	public Face(int index, Color color) {
		this(index,new ArrayList<Vertex>(), color);
	}
	
	/**
	 * Instantiates a new face.
	 *
	 * @param n the n
	 */
	public Face(int index ) {
		this(index, null);
	}
	
	

	/**
	 * Sets the color.
	 *
	 * @param color2 the new color
	 */
	public void setColor(javafx.scene.paint.Color color2) {
		this.color = color2;
	}
	
	/**
	 * Adds the sommet.
	 *
	 * @param sommet the sommet
	 */
	public void addVertex(Vertex sommet) {
		this.vertices.add(sommet);
	}

	/**
	 * Gets the nb sommet.
	 *
	 * @return the nb sommet
	 */
	public int getNbVertex() {
		return nbvertices;
	}

	/**
	 * Gets the sommets.
	 *
	 * @return the sommets
	 */
	public List<Vertex> getVertex() {
		return vertices;
	}
	
	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public javafx.scene.paint.Color getColor() {
		return this.color;
	}
	
	/**
	 * Gets the color red.
	 *
	 * @return the color
	 */
	public double getRed() {
		return this.color.getRed();
	}
	
	/**
	 * Gets the color red.
	 *
	 * @return the color
	 */
	public double getGreen() {
		return this.color.getGreen();
	}
	
	/**
	 * Gets the color red.
	 *
	 * @return the color
	 */
	public double getBlue() {
		return this.color.getBlue();
	}
	
	/**
	 * Checks for color.
	 *
	 * @return true, if successful
	 */
	public boolean hasColor() {
		return this.color == null;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Face [color=" + color + ", nbSommet=" + nbvertices + ", sommets=" + vertices.toString()+ "]";
	}

	/**
	 * Find highest Z.
	 *
	 * @return the double
	 */
	private double findHighestZ(){
		double retour=this.vertices.get(0).getZ();
		for(int i=1;i<this.getNbVertex();i++){
			if(this.vertices.get(i).getZ()>retour){
				retour=this.vertices.get(i).getZ();
			}
		}
		return retour;
	}

	/**
	 * Gets the heightest Z.
	 *
	 * @return the heightest Z
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
