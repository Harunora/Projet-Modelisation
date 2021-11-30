package math;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import graph.Face;
import graph.Matrice;
import graph.Sommet;
import graph.Color;

class ColorFacecalcTest {

	@Test
	void SimpletestFace() {
		Color c = new Color(64.0, 255.0, 64.0);
		Matrice lumiere = new Matrice(1,1);
		lumiere.add(1,1,1,1);
		CalculColor cC = new CalculColor(lumiere, c);
		Face f = new Face(3);
		f.addSommet(new Sommet(1, 2, 3));
		f.addSommet(new Sommet(2,2,5));
		f.addSommet(new Sommet(2,3,3));
		
		Color res = cC.getColor(f);
		Color sol1 = new Color(12.0, 49.0, 12.0);
		assertEquals(sol1.toString(), res.toString());
		
	}

}
