package graph;

import java.util.ArrayList;
import java.util.List;

public class Face {
	Color color;
	int nbSommet;
	List<Sommet> sommets;
	
	//Une face est une list de plusieurs Sommets
	public Face(int n, List<Sommet> sommets, Color color) {
		this.color = color;
		nbSommet = n;
		this.sommets = new ArrayList<Sommet>();
	}
	
	public Face(int n , List<Sommet> sommets) {
		this(n, sommets, new Color(0, 0, 0));
	}
	
	public Face(int n ) {
		this(n, new ArrayList<Sommet>(), new Color(0, 0, 0));
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

	public String toString() {
		String res =  "Face [nbSommet=" + nbSommet + ", sommets= ";
		for (int i = 0; i<this.nbSommet-1; i++) {
			res+= this.sommets.get(i)+" , ";
		}
		res+= this.sommets.get(nbSommet-1) + " ]";
		return res;
	}
	
	
	
}
