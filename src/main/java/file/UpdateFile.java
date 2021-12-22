package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La classe UpdateFile.
 */
public class UpdateFile {
	
	/** La ligne auteur et la ligne commentaire. */
	int ligneAuteur,ligneCom;
	
	/** Le contenu du fichier. */
	List<String> contenuFichier = new ArrayList<>();
	
	/** Le fichier. */
	File fichier;

	/**
	 * Instantie un nouveau fichier mis a jour.
	 *
	 * @param fichier le fichier
	 * @param ligneAuteur le ligne auteur
	 * @param ligneCom le ligne commentaire
	 */
	public UpdateFile(File fichier, int ligneAuteur, int ligneCom){
		this.ligneAuteur = ligneAuteur;
		this.ligneCom = ligneCom;
		this.fichier = fichier;
		fileReader();
	}

	/**
	 * Remplace auteur.
	 *
	 * @param ligne le numero de la ligne
	 * @param comment le nouveau auteur
	 */
	public void remplaceAuteur(int ligne, String comment) {
		if(ligneAuteur == 0) {
			contenuFichier.add(2, "comment made by " + comment);
		}else {
			if(ligne == ligneAuteur && ligne == ligneCom) {
				contenuFichier.set(ligne-1, ("comment made by " + comment) ) ;
			}	
		}
		fileWriter();
	}
	
	/**
	 * Remplace commentaire.
	 *
	 * @param ligne le numero de la ligne
	 * @param comment le nouveau commentaire
	 */
	public void remplaceCommentaire(int ligne, String comment) {
		if(ligneCom == 0) {
			if(ligneAuteur==0) {
				contenuFichier.add(2, "comment " + comment);				
			}else {
				contenuFichier.add(3, "comment " + comment);
			}
		}else {
			if(ligne == ligneCom) {
				contenuFichier.set(ligne-1, ("comment " + comment) ) ;
			}	
		}
		fileWriter();
	}

	/**
	 * File writer.
	 */
	public void fileWriter() {
		try(PrintWriter pw = new PrintWriter(fichier)){
			for(int i = 0; i<contenuFichier.size(); i++) {
				pw.println(String.valueOf(contenuFichier.get(i)));				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * File reader.
	 */
	public void fileReader() {
		contenuFichier.clear();
		String text;
		FileInputStream file = null;
		try {
			file = new FileInputStream(fichier);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine())
		{
			text=scanner.nextLine();
			contenuFichier.add(text);
		}
		scanner.close();
	}

	/**
	 * Methode Tostring.
	 *
	 * @return the string
	 */
	public String toString() {
		String res = "";
		for(int i = 0; i<contenuFichier.size();i++) {
			res+=contenuFichier.get(i);
		}
		return res;
	}

}
