package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MapFile {
	protected Map<String, File> mapfile;
	
	@SuppressWarnings("unchecked")
	public MapFile() {
		mapfile = new HashMap<String, File>();
	}
	
	public boolean add(String s , File f) {
		mapfile.put(s, f);
		return true;
	}
	public File getFileOf(String s) {
		return mapfile.get(s);
	}
	
}
