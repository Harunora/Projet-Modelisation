package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class MapFile.
 */
public class MapFile {
	
	/** The mapfile. */
	protected Map<String, File> mapfile;
	
	/**
	 * Instantiates a new map file.
	 */
	@SuppressWarnings("unchecked")
	public MapFile() {
		mapfile = new HashMap<String, File>();
	}
	
	/**
	 * Adds the.
	 *
	 * @param s the s
	 * @param f the f
	 * @return true, if successful
	 */
	public boolean add(String s , File f) {
		mapfile.put(s, f);
		return true;
	}
	
	/**
	 * Gets the file of.
	 *
	 * @param s the s
	 * @return the file of
	 */
	public File getFileOf(String s) {
		return mapfile.get(s);
	}
	
}
