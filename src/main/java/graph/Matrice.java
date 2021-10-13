package graph;

import java.util.List;

public class Matrice {
	List<Double> x;
	List<Double> y;
	List<Double> z;
	
	
	public Matrice(List<Face> l) {
		for(int i = 0; i<l.size(); i++) {
			List<Sommet> s  = l.get(i).sommets;
			for(int j = 0; j<s.size(); i++) {
				x.add(s.get(j).getX());
				y.add(s.get(j).getX());
				z.add(s.get(j).getX());
			}
		}
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i<x.size(); i++) {
			res += "x : "+ x.get(i) + ", y : " + y.get(i) + ", z" + z.get(i)+ "\n"; 
		}
		return res;
	}
}
