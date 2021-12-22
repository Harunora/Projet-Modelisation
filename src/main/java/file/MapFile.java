package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * La classe MapFile.
 * 
 * @author Julien Lalloyer
 */
public class MapFile {
	
	/** Le tableau fichier. */
	protected Map<String, File> mapfile;
	
	/**
	 * Instantie un nouveau tableau fichier.
	 */
	public MapFile() {
		mapfile = new HashMap<>();
	}
	
	/**
	 * ajoute a la table.
	 *
	 * @param chaine la chaine associee au fichier
	 * @param fichier  le fichier associer a la chaine
	 * @return true, si cela est bien effectue
	 */
	public boolean add(String chaine , File fichier) {
		mapfile.put(chaine, fichier);
		return true;
	}
	
	/**
	 * Prend le fichier associer a la chaine
	 *
	 * @param chaine la chaine associee au fichier
	 * @return le fichier associer a la chaine
	 */
	public File getFileOf(String chaine) {
		return mapfile.get(chaine);
	}
	
}
