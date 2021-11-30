package graph;

import java.util.ArrayList;
import java.util.List;

public class Face {
	protected javafx.scene.paint.Color color;
	protected int nbSommet;
	protected List<Sommet> sommets;
	
	//Une face est une list de plusieurs Sommets
	public Face(int n, List<Sommet> sommets, javafx.scene.paint.Color color) {
		this.color = color;
		nbSommet = n;
		this.sommets = sommets;
	}
	
	public Face(int n ) {
		this(n, new ArrayList<Sommet>(), null);
	}
	
	public void setColor(javafx.scene.paint.Color color2) {
		this.color = color2;
	}
	
	public void addSommet(Sommet sommet) {
		this.sommets.add(sommet);
	}

	public int getNbSommet() {
		return nbSommet;
	}

	public List<Sommet> getSommets() {
		return sommets;
	}
	
	public javafx.scene.paint.Color getColor() {
		return this.color;
	}
	
	public boolean hasColor() {
		return this.color == null;
	}

	@Override
	public String toString() {
		return "Face [color=" + color + ", nbSommet=" + nbSommet + ", sommets=" + sommets.toString()+ "]";
	}

	
	
	
	
}
