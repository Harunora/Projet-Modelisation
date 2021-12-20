package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * The Class FileReaderTest.
 */
class FileReaderTest {
	
	/** The my path. */
	String myPath = System.getProperty("user.dir")+File.separator+"exemples"+File.separator;
	
	/** The file. */
	File file = new File(myPath+"cube.ply");
	
	/** The file 2. */
	File file2 = new File(myPath+"apple.ply");
	
	/** The r. */
	FileReader r = new FileReader();
	
	/** The r 2. */
	FileReader r2 = new FileReader();
	
	/** The attendu. */
	Graph attendu = implementation();
	
	/** The obtenu. */
	Graph obtenu = r.read(file);
	
	/** The obtenu 2. */
	Graph obtenu2 = r2.read(file2);
	
	/**
	 * Implementation.
	 *
	 * @return the graph
	 */
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
		f.add(new Face(4,listSommet1, null));
		f.add(new Face(4,listSommet2, null));
		f.add(new Face(4,listSommet3, null));
		f.add(new Face(4,listSommet4, null));
		f.add(new Face(4,listSommet5, null));
		f.add(new Face(4,listSommet6, null));
		matrice = new Matrice(7, 6);
		return new Graph(6,f, matrice, null, "");
	}
	
	/**
	 * Test nb faces.
	 */
	@Test
	void testNbFaces() {
		assertEquals(attendu.getNbFaces(), obtenu.getNbFaces());
	}
	
	/**
	 * Test nb sommets.
	 */
	@Test
	void testNbSommets() {
		assertEquals(attendu.getFaces().get(0).getNbSommet(), obtenu.getFaces().get(0).getNbSommet());
	}
	
	/**
	 * Test face 1.
	 */
	@Test
	void testFace1() {
		assertEquals(attendu.getFaces().get(0).toString(), obtenu.getFaces().get(0).toString());
	}
	
	/**
	 * Test face 2.
	 */
	@Test
	void testFace2() {
		assertEquals(attendu.getFaces().get(1).toString(), obtenu.getFaces().get(1).toString());
	}
	
	/**
	 * Test sommet 1.
	 */
	@Test
	void testSommet1() {
		assertEquals(attendu.getFaces().get(1).getSommets().toString(), obtenu.getFaces().get(1).getSommets().toString());
	}
	
	/**
	 * Test sommet 2.
	 */
	@Test
	void testSommet2() {
		assertEquals(attendu.getFaces().get(3).getSommets().toString(), obtenu.getFaces().get(3).getSommets().toString());
	}
	
	/**
	 * Test graph.
	 */
	@Test
	void testGraph() {
		assertEquals(attendu.toString(), obtenu.toString());
	}
	
	/**
	 * Test nb faces EF.
	 */
	@Test
	void testNbFacesEF() {
		assertEquals(1704, obtenu2.getNbFaces());
		
	}
	
	/**
	 * Test nb sommets file reader.
	 */
	@Test
	void testNbSommetsFileReader() {
		assertEquals(3, obtenu2.getNbSommet());
	}
	
	
	/**
	 * Test size sommets.
	 */
	@Test
	void testSizeSommets() {
		assertEquals(6, obtenu.getFaces().size());
	}

}
