package graph;

import java.util.ArrayList;
import java.util.List;

public class Matrice {
	List<Double> x = new ArrayList<Double>();
	List<Double> y= new ArrayList<Double>();
	List<Double> z= new ArrayList<Double>();


	public Matrice() {
		System.out.println("initialisqtion de matrice");
		this.x = new ArrayList<Double>();
		this.y = new ArrayList<Double>();
		this.z = new ArrayList<Double>();
	}
	
	public void add(Face f) {
		System.out.println("Entrer dans add");
		for(int i = 0; i<f.getSommets().size(); i++) {
			System.out.println("Entrer dans for");
			x.add(f.sommets.get(i).getX());
			y.add(f.sommets.get(i).getY());
			z.add(f.sommets.get(i).getZ());
			System.out.println(x.get(i));
		}
	}

	public String toString() {
		System.out.println("test");
		String res = "";
		System.out.println(x.size());
		for(int i = 0; i<x.size(); i++) {
			System.out.println("entrer dans le for");
			System.out.println(x.get(i));
			res += "x : "+ x.get(i) + ", y : " + y.get(i) + ", z" + z.get(i)+ "\n"; 
		}
		return res;
	}
}
