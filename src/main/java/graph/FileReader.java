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
 * The Class FileReader, read a file .ply and create a Graph with all data of it.
 * @author matheo
 */
public class FileReader {

	/** the line that is read , the name of the author of the ply, the comment of the author. */
	private String actualString = "",author="",comment="";

	/** The line where the author is writen , the line where the comment is writen */
	private int authorLine = 0,commentLine = 0;

	/** The amount of faces, the amount of vertices. */
	private int nbFaces = 0,nbVertices = 0;

	/** The list of all vertices. */
	private List<Vertex> vertices = new ArrayList<Vertex>();

	/** The list of all faces. */
	private List<Face>faces = new ArrayList<Face>();

	/** The list (in String) of all the faces */
	private List<String> listOfFaces = new ArrayList<String>();

	/** The matrix. */
	protected Matrix matrix;




	/**
	 * Read the file (it's the main function).
	 *
	 * @param fileRead the file that is read
	 * @return the UpdateGraph made with all the data of the file
	 */
	public UpdateGraph read(File fileRead) {
		try {
			FileInputStream file = new FileInputStream(fileRead);
			Scanner scanner = new Scanner(file);
			int line = 1;
			while(scanner.hasNextLine())
			{
				actualString = actualNext(scanner);
				startFile(scanner,  line);
				matrix = new Matrix(nbVertices, nbFaces);
				readVertex(nbVertices, vertices, scanner);
				readFace(nbFaces, vertices, faces, listOfFaces, scanner);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return  new UpdateGraph(nbFaces, faces, matrix, listOfFaces, author);
	}


	/**
	 * read the header of the file and get all data (author, comments, amount of vertices and faces) 
	 *
	 * @param scanner for read the file, 
	 * @param line the current line
	 */
	private void startFile(Scanner scanner, int line) {
		boolean achieved = false;
		while(!achieved) {
			line++;
			actualString = actualNext(scanner);
			if(actualString.equals("end_header"+"\n")) {achieved = true;}		
			if(actualString.equals("\n")) {line--;}
			if(actualString.startsWith("element vertex")) {nbVertices = Integer.parseInt(actualString.substring(15,actualString.length()-1)); }
			if(actualString.startsWith("comment")) {
				if(actualString.startsWith("comment made by")) {
					author = actualString.substring(15);
					authorLine = line;
				}else {
					comment += actualString.substring(7) + "\n";
					commentLine = line;
				}	
			}
			if(actualString.startsWith("element face")) {nbFaces = Integer.parseInt(actualString.substring(13,actualString.length()-1));}
		}
	}

	/**
	 * Go to the next line
	 *
	 * @param scanner the scanner
	 * @return the next line
	 */
	private String actualNext(Scanner scanner) {
		actualString=scanner.nextLine()+"\n";
		return actualString;
	}

	/**
	 * Read a face and add it to the list
	 *
	 * @param nbFaces the amount of faces
	 * @param listVertex the list of vertices
	 * @param faces list of faces
	 * @param stringFace the list of faces (String)
	 * @param scanner the scanner
	 */
	private void readFace(int nbFaces, List<Vertex> listVertex, List<Face> faces,List<String> stringFace, Scanner scanner) {
		for(int i = 0; i<nbFaces; i++) {
			actualString = actualNext(scanner);
			if(actualString.equals("\n")) {
				i--;
			}
			else {
				stringFace.add(actualString);
				List<Vertex> listVertexTmp = new ArrayList<Vertex>();				
				List<Integer> listIdxVertex = new ArrayList<Integer>();
				StringTokenizer lineToken = new StringTokenizer(actualString);
				int number = Integer.parseInt(lineToken.nextToken());
				for(int j = 0; j<number; j++ ) {
					listIdxVertex.add(Integer.parseInt(lineToken.nextToken()));
				}
				for(int j = 0; j< number; j++) {
					listVertexTmp.add(listVertex.get(listIdxVertex.get(j)));
				}
				faceAdd(faces, listVertexTmp, number);

			}
		}
	}

	/**
	 * Add a new face to the list
	 *
	 * @param faces the current list of faces
	 * @param listVertexTmp the temporary list of Vertex
	 * @param number the amount of vertices in the face
	 */
	private void faceAdd(List<Face> faces, List<Vertex> listVertexTmp, int number) {

		Face faceTmp = new Face(number,listVertexTmp, Color.WHITE);			
		faces.add(faceTmp);

	}


	/**
	 * Read the Vertex and get all the date 
	 *
	 * @param nbVertices the amount of vertices
	 * @param vertices the list of vertices
	 * @param scanner the scanner
	 */
	private void readVertex(int nbVertices, List<Vertex> vertices, Scanner scanner) {
		for(int i = 0; i<nbVertices; i++) {
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
	 * return a double[] with the xCoordinate , yCoordinate, zCoordinates on the split String
	 *
	 * @param split the String where the coordinate are
	 * @return the double[] with the coordinates
	 */
	private double[] addXyz(String[] split) {
		return new double[] {Double.parseDouble(split[0]),Double.parseDouble(split[1]),Double.parseDouble(split[2])};
	}


	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}


	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}


	/**
	 * Gets the line where the author is written.
	 *
	 * @return the line of the author
	 */
	public int getAuthorLine() {
		return authorLine;
	}


	/**
	 * Gets the line where there is comment
	 *
	 * @return the line of the comment
	 */
	public int getCommentLine() {
		return commentLine;
	}


}