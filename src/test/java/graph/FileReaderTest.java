package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileReaderTest {
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
	
	@Test
	void testNbFaces() {
		//int nbFaces = 6;
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.getNbFaces(), obtenu.getNbFaces());
	}
	@Test
	void testNbSommets() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.getFaces().get(0).getNbSommet(), obtenu.getFaces().get(0).getNbSommet());
	}
	@Test
	void testFace1() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.getFaces().get(0).toString(), obtenu.getFaces().get(0).toString());
	}
	
	@Test
	void testFace2() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.getFaces().get(1).toString(), obtenu.getFaces().get(1).toString());
	}
	
	@Test
	void testSommet1() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.getFaces().get(1).getSommets().toString(), obtenu.getFaces().get(1).getSommets().toString());
	}
	
	@Test
	void testSommet2() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.getFaces().get(3).getSommets().toString(), obtenu.getFaces().get(3).getSommets().toString());
	}
	
	@Test
	void testGraph() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read();
		assertEquals(attendu.toString(), obtenu.toString());
	}

}
