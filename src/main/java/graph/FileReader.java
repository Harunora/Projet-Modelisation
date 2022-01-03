package graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javafx.scene.paint.Color;

/**
 * The Class FileReader.
 */
public class FileReader {
	
	/** The commentaire. */
	private String actual = "",auteur="",commentaire="";
	
	/** The ligne com. */
	private int ligneAuteur = 0,ligneCom = 0;
	
	/** The nb sommets. */
	private int nbFaces = 0,nbSommets = 0;
	
	/** The sommets. */
	private List<Sommet> sommets = new ArrayList<Sommet>();
	
	/** The faces. */
	private List<Face>faces = new ArrayList<Face>();
	
	/** The sommets de faces. */
	private List<String> sommetsDeFaces = new ArrayList<String>();
	
	/** The matrice. */
	protected Matrice matrice;




	/**
	 * Read.
	 *
	 * @param fileTest the file test
	 * @return the update graph
	 */
	public UpdateGraph read(File fileTest) {
		try {
			FileInputStream file = new FileInputStream(fileTest);
			Scanner scanner = new Scanner(file);
			int ligne = 1;
			while(scanner.hasNextLine())
			{
				actual = actualNext(scanner);
				startFile(scanner,  ligne);
				matrice = new Matrice(nbSommets, nbFaces);
				readSommet(nbSommets, sommets, scanner);
				readFace(nbFaces, sommets, faces, sommetsDeFaces, scanner);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return  new UpdateGraph(nbFaces, faces, matrice, sommetsDeFaces, auteur);
	}


	/**
	 * Start file.
	 *
	 * @param scanner the scanner
	 * @param ligne the ligne
	 */
	private void startFile(Scanner scanner, int ligne) {
		boolean achieved = false;
		while(!achieved) {
			ligne++;
			actual = actualNext(scanner);
			if(actual.equals("end_header"+"\n")) {
				achieved = true;
			}
			
			if(actual.equals("\n")) {
				ligne--;
			}


			if(actual.startsWith("element vertex")) {
				nbSommets = Integer.parseInt(actual.substring(15,actual.length()-1)); 
			}

			if(actual.startsWith("comment")) {
				if(actual.startsWith("comment made by")) {
					auteur = actual.substring(15);
					ligneAuteur = ligne;
				}else {
					commentaire += actual.substring(7) + "\n";
					ligneCom = ligne;
				}
				
			}

			if(actual.startsWith("element face")) {
				nbFaces = Integer.parseInt(actual.substring(13,actual.length()-1));
			}




		}
	}

	/**
	 * Actual next.
	 *
	 * @param scanner the scanner
	 * @return the string
	 */
	private String actualNext(Scanner scanner) {
		actual=scanner.nextLine()+"\n";
		return actual;
	}

	/**
	 * Read face.
	 *
	 * @param nbFaces the nb faces
	 * @param sommets the sommets
	 * @param faces the faces
	 * @param stringFace the string face
	 * @param scanner the scanner
	 */
	private void readFace(int nbFaces, List<Sommet> sommets, List<Face> faces,List<String> stringFace, Scanner scanner) {
		for(int i = 0; i<nbFaces; i++) {
			actual = actualNext(scanner);
			if(actual.equals("\n")) {
				i--;
			}
			else {
				stringFace.add(actual);
				List<Sommet> listSommetTmp = new ArrayList<Sommet>();
				List<Integer> listIdxSommet = new ArrayList<Integer>();
				StringTokenizer lineToken = new StringTokenizer(actual);
				int nb = Integer.parseInt(lineToken.nextToken());
				for(int j = 0; j<nb; j++ ) {
					listIdxSommet.add(Integer.parseInt(lineToken.nextToken()));
				}
				for(int j = 0; j< nb; j++) {
					listSommetTmp.add(sommets.get(listIdxSommet.get(j)));
				}
				faceAdd(faces, listSommetTmp, lineToken, nb);

			}
		}
	}

	/**
	 * Face add.
	 *
	 * @param faces the faces
	 * @param listSommetTmp the list sommet tmp
	 * @param lineToken the line token
	 * @param nb the nb
	 */
	private void faceAdd(List<Face> faces, List<Sommet> listSommetTmp, StringTokenizer lineToken, int nb) {

		Face faceTmp = new Face(nb,listSommetTmp, Color.WHITE);			
		faces.add(faceTmp);

	}


	/**
	 * Read sommet.
	 *
	 * @param nbSommets the nb sommets
	 * @param sommets the sommets
	 * @param scanner the scanner
	 */
	private void readSommet(int nbSommets, List<Sommet> sommets, Scanner scanner) {
		for(int i = 0; i<nbSommets; i++) {
			Sommet tmp;
			actual = actualNext(scanner);
			if(actual.equals("\n")) {
				i--;
			}else {
				String[] s1 = actual.split(" ");
				double[] tabXyz = addXyz(s1);
				tmp = new Sommet(tabXyz);
				sommets.add(tmp);
				matrice.add(tmp);				
			}
		}
	}

	/**
	 * Adds the xyz.
	 *
	 * @param s1 the s 1
	 * @return the double[]
	 */
	private double[] addXyz(String[] s1) {
		return new double[] {Double.parseDouble(s1[0]),Double.parseDouble(s1[1]),Double.parseDouble(s1[2])};
	}


	/**
	 * Gets the auteur.
	 *
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}


	/**
	 * Gets the commentaire.
	 *
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}


	/**
	 * Gets the ligne auteur.
	 *
	 * @return the ligne auteur
	 */
	public int getLigneAuteur() {
		return ligneAuteur;
	}


	/**
	 * Gets the ligne com.
	 *
	 * @return the ligne com
	 */
	public int getLigneCom() {
		return ligneCom;
	}


}