package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileReaderTest {
	String myPath = System.getProperty("user.dir")+File.separator+"exemples"+File.separator;
	File file = new File(myPath+"test.ply");
	File file2 = new File(myPath+"apple.ply");
	FileReader r = new FileReader();
	FileReader r2 = new FileReader();
	Graph attendu = implementation();
	Graph obtenu = r.read(file);
	Graph obtenu2 = r2.read(file2);
	
	Graph implementation() {
		List<Face> f = new ArrayList<Face>();
		Matrice matrice;
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
		matrice = new Matrice(7, 6);
		return new Graph(6,f, matrice, null);
	}
	
	@Test
	void testNbFaces() {
		assertEquals(attendu.getNbFaces(), obtenu.getNbFaces());
	}
	@Test
	void testNbSommets() {
		assertEquals(attendu.getFaces().get(0).getNbSommet(), obtenu.getFaces().get(0).getNbSommet());
	}
	@Test
	void testFace1() {
		assertEquals(attendu.getFaces().get(0).toString(), obtenu.getFaces().get(0).toString());
	}
	
	@Test
	void testFace2() {
		assertEquals(attendu.getFaces().get(1).toString(), obtenu.getFaces().get(1).toString());
	}
	
	@Test
	void testSommet1() {
		assertEquals(attendu.getFaces().get(1).getSommets().toString(), obtenu.getFaces().get(1).getSommets().toString());
	}
	
	@Test
	void testSommet2() {
		assertEquals(attendu.getFaces().get(3).getSommets().toString(), obtenu.getFaces().get(3).getSommets().toString());
	}
	
	@Test
	void testGraph() {
		assertEquals(attendu.toString(), obtenu.toString());
	}
	
	@Test
	void testNbFacesEF() {
		assertEquals(1704, obtenu2.getNbFaces());
		
	}
	
	@Test
	void testNbSommetsFileReader() {
		assertEquals(3, obtenu2.getNbSommet());
	}
	
	
	@Test
	void testSizeSommets() {
		assertEquals(6, obtenu.getFaces().size());
	}

}
