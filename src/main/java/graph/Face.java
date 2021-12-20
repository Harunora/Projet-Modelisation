package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javafx.scene.paint.Color;

/**
 * The Class Face.
 */
public class Face implements Comparable<Face> {
	
	/** The color. */
	protected javafx.scene.paint.Color color;
	
	/** The nb sommet. */
	protected int nbSommet;
	
	/** The sommets. */
	protected List<Sommet> sommets;
	
	/** The Highest Z. */
	protected double HighestZ;
	
	/**
	 * Instantiates a new face.
	 *
	 * @param n the n
	 * @param sommets the sommets
	 * @param color the color
	 */
	//Une face est une list de plusieurs Sommets
	public Face(int n, List<Sommet> sommets, javafx.scene.paint.Color color) {
		this.color = color;
		nbSommet = n;
		this.sommets = sommets;	
		this.HighestZ=findHighestZ();	
		
	}
	
	/**
	 * Instantiates a new face.
	 *
	 * @param n the n
	 * @param c the c
	 */
	public Face(int n, Color c) {
		this(n,new ArrayList<Sommet>(), c);
	}
	
	/**
	 * Instantiates a new face.
	 *
	 * @param n the n
	 */
	public Face(int n ) {
		this(n, null);
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
	public void addSommet(Sommet sommet) {
		this.sommets.add(sommet);
	}

	/**
	 * Gets the nb sommet.
	 *
	 * @return the nb sommet
	 */
	public int getNbSommet() {
		return nbSommet;
	}

	/**
	 * Gets the sommets.
	 *
	 * @return the sommets
	 */
	public List<Sommet> getSommets() {
		return sommets;
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
		return "Face [color=" + color + ", nbSommet=" + nbSommet + ", sommets=" + sommets.toString()+ "]";
	}

	/**
	 * Find highest Z.
	 *
	 * @return the double
	 */
	private double findHighestZ(){
		double retour=this.sommets.get(0).getZ();
		for(int i=1;i<this.getNbSommet();i++){
			if(this.sommets.get(i).getZ()>retour){
				retour=this.sommets.get(i).getZ();
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
		return this.HighestZ;
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
