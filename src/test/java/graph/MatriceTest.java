package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MatriceTest {
	String myPath = System.getProperty("user.dir")+File.separator+"data"+File.separator;
	File file = new File(myPath+"test.ply");
/*
	Graph implementation() {
		List<Face> f = new ArrayList<Face>();
		Sommet s0 = new Sommet(0,0,0);
		Sommet s1 = new Sommet(0,0,1);
		Sommet s2 = new Sommet(0,1,1);
		Sommet s3 = new Sommet(0,1,0);
		Sommet s4 = new Sommet(1,0,0);
		Sommet s5 = new Sommet(1,0,1);
		Sommet s6 = new Sommet(1,1,1);
		Sommet s7 = new Sommet(1,1,0);
		List<Sommet> listSommet1 = new ArrayList<Sommet>();
		listSommet1.add(s0);
		listSommet1.add(s1);
		listSommet1.add(s2);
		listSommet1.add(s3);
		List<Sommet> listSommet2 = new ArrayList<Sommet>();
		listSommet2.add(s7);
		listSommet2.add(s6);
		listSommet2.add(s5);
		listSommet2.add(s4);
		List<Sommet> listSommet3 = new ArrayList<Sommet>();
		listSommet3.add(s0);
		listSommet3.add(s4);
		listSommet3.add(s5);
		listSommet3.add(s1);
		List<Sommet> listSommet4 = new ArrayList<Sommet>();
		listSommet4.add(s1);
		listSommet4.add(s5);
		listSommet4.add(s6);
		listSommet4.add(s2);
		List<Sommet> listSommet5 = new ArrayList<Sommet>();
		listSommet5.add(s2);
		listSommet5.add(s6);
		listSommet5.add(s7);
		listSommet5.add(s3);
		List<Sommet> listSommet6 = new ArrayList<Sommet>();
		listSommet6.add(s3);
		listSommet6.add(s7);
		listSommet6.add(s4);
		listSommet6.add(s0);
		f.add(new Face(4,listSommet1));
		f.add(new Face(4,listSommet2));
		f.add(new Face(4,listSommet3));
		f.add(new Face(4,listSommet4));
		f.add(new Face(4,listSommet5));
		f.add(new Face(4,listSommet6));
		return new Graph(6,f);
	}
*/

	/*@Test
	void testX() {
		//int nbFaces = 6;
		FileReader r = new FileReader();
		Graph attendu = r.read(file);
		Graph obtenu = r.read(file);
		System.out.println(obtenu.matrice);
		System.out.println(obtenu.matrice.toString());
		assertEquals(attendu.matrice.x.get(0), obtenu.matrice.x.get(0));
	}
	*/
	/*
	@Test
	void testSizeSommets() {
		FileReader r = new FileReader();
		Graph obtenu = r.read(file);
		int attendu = 6;
		assertEquals(attendu, obtenu.getFaces().size());
	}
	
	@Test
	void testTmp() {
		FileReader r = new FileReader();
		Graph obtenu = r.read(file);
		Graph attendu = implementation();
		for(int i = 0; i<obtenu.getFaces().size(); i++) {
			System.out.println("attendu : "+attendu.getFaces().get(i));
			System.out.println("obtenu : "+obtenu.getFaces().get(i));
		}
	}
	*/
	@Test
	void testSommet2() {
		FileReader r = new FileReader();
		Graph attendu = r.read(file);
		Graph obtenu = r.read(file);
		assertEquals(attendu.getFaces().get(3).getSommets().toString(), obtenu.getFaces().get(3).getSommets().toString());
		System.out.println("attendu :" +attendu.getFaces().get(3).getSommets().toString());
		System.out.println("obtenu  :" +obtenu.getFaces().get(3).getSommets().toString());
		System.out.println("obtenu matrice :" +obtenu.matrice);
	}


}
