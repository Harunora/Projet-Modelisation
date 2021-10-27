package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UpdateGraphTest {
	String myPath = System.getProperty("user.dir")+File.separator+"data"+File.separator;
	File file = new File(myPath+"test.ply");
	File file2 = new File(myPath+"apple.ply");
	
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
		List<String> string = new ArrayList<String>();
		string.add("4 0 1 2 3\n");
		string.add("4 7 6 5 4\n");
		string.add("4 0 4 5 1\n");
		string.add("4 1 5 6 2\n");
		string.add("4 2 6 7 3\n");
		string.add("4 3 7 4 0\n");
		return new Graph(6,f, matrice, string);
	}
	@Test
	void testString() {
		FileReader r = new FileReader();
		Graph attendu = implementation();
		Graph obtenu = r.read(file);
		assertEquals(attendu.getSommetsDeFaces(), obtenu.getSommetsDeFaces());
	}
	
	@Test
	void testUpdate1() {
		FileReader r = new FileReader();
		UpdateGraph u = new UpdateGraph(); 
		Graph attendu = implementation();
		Graph old = r.read(file);
		Graph obtenu = u.Update(old);
		assertEquals(attendu.getSommetsDeFaces(), obtenu.getSommetsDeFaces());
	}
	
	@Test
	void testUpdate2() {
		FileReader r = new FileReader();
		UpdateGraph u = new UpdateGraph(); 
		Graph old = r.read(file2);
		Graph obtenu = u.Update(old);
		assertEquals(old.getSommetsDeFaces(), obtenu.getSommetsDeFaces());
	}

}