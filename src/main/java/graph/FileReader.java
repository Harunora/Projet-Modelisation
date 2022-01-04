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
	private String actualString = "",author="",comment="";

	/** The ligne com. */
	private int authorLine = 0,commentLine = 0;

	/** The nb sommets. */
	private int nbFaces = 0,nbVertex = 0;

	/** The sommets. */
	private List<Vertex> vertices = new ArrayList<Vertex>();

	/** The faces. */
	private List<Face>faces = new ArrayList<Face>();

	/** The sommets de faces. */
	private List<String> listOfFaces = new ArrayList<String>();

	/** The matrice. */
	protected Matrix matrix;




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
				actualString = actualNext(scanner);
				startFile(scanner,  ligne);
				matrix = new Matrix(nbVertex, nbFaces);
				readVertex(nbVertex, vertices, scanner);
				readFace(nbFaces, vertices, faces, listOfFaces, scanner);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return  new UpdateGraph(nbFaces, faces, matrix, listOfFaces, author);
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
			actualString = actualNext(scanner);
			if(actualString.equals("end_header"+"\n")) {achieved = true;}		
			if(actualString.equals("\n")) {ligne--;}
			if(actualString.startsWith("element vertex")) {nbVertex = Integer.parseInt(actualString.substring(15,actualString.length()-1)); }
			if(actualString.startsWith("comment")) {
				if(actualString.startsWith("comment made by")) {
					author = actualString.substring(15);
					authorLine = ligne;
				}else {
					comment += actualString.substring(7) + "\n";
					commentLine = ligne;
				}	
			}
			if(actualString.startsWith("element face")) {nbFaces = Integer.parseInt(actualString.substring(13,actualString.length()-1));}
		}
	}

	/**
	 * Actual next.
	 *
	 * @param scanner the scanner
	 * @return the string
	 */
	private String actualNext(Scanner scanner) {
		actualString=scanner.nextLine()+"\n";
		return actualString;
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
	private void readFace(int nbFaces, List<Vertex> sommets, List<Face> faces,List<String> stringFace, Scanner scanner) {
		for(int i = 0; i<nbFaces; i++) {
			actualString = actualNext(scanner);
			if(actualString.equals("\n")) {
				i--;
			}
			else {
				stringFace.add(actualString);
				List<Vertex> listSommetTmp = new ArrayList<Vertex>();
				List<Integer> listIdxSommet = new ArrayList<Integer>();
				StringTokenizer lineToken = new StringTokenizer(actualString);
				int number = Integer.parseInt(lineToken.nextToken());
				for(int j = 0; j<number; j++ ) {
					listIdxSommet.add(Integer.parseInt(lineToken.nextToken()));
				}
				for(int j = 0; j< number; j++) {
					listSommetTmp.add(sommets.get(listIdxSommet.get(j)));
				}
				faceAdd(faces, listSommetTmp, number);

			}
		}
	}

	/**
	 * Face add.
	 *
	 * @param faces the faces
	 * @param listSommetTmp the list sommet tmp
	 * @param lineToken the line token
	 * @param number the nb
	 */
	private void faceAdd(List<Face> faces, List<Vertex> listSommetTmp, int number) {

		Face faceTmp = new Face(number,listSommetTmp, Color.WHITE);			
		faces.add(faceTmp);

	}


	/**
	 * Read sommet.
	 *
	 * @param nbVertex the nb sommets
	 * @param vertices the sommets
	 * @param scanner the scanner
	 */
	private void readVertex(int nbVertex, List<Vertex> vertices, Scanner scanner) {
		for(int i = 0; i<nbVertex; i++) {
			Vertex tmp;
			actualString = actualNext(scanner);
			if(actualString.equals("\n")) {
				i--;
			}else {
				String[] split = actualString.split(" ");
				double[] tabXyz = addXyz(split);
				tmp = new Vertex(tabXyz);
				vertices.add(tmp);
				matrix.add(tmp);				
			}
		}
	}

	/**
	 * Adds the xyz.
	 *
	 * @param split the s 1
	 * @return the double[]
	 */
	private double[] addXyz(String[] split) {
		return new double[] {Double.parseDouble(split[0]),Double.parseDouble(split[1]),Double.parseDouble(split[2])};
	}


	/**
	 * Gets the auteur.
	 *
	 * @return the auteur
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * Gets the commentaire.
	 *
	 * @return the commentaire
	 */
	public String getComment() {
		return comment;
	}


	/**
	 * Gets the ligne auteur.
	 *
	 * @return the ligne auteur
	 */
	public int getAuthorLine() {
		return authorLine;
	}


	/**
	 * Gets the ligne com.
	 *
	 * @return the ligne com
	 */
	public int getCommentLine() {
		return commentLine;
	}


}