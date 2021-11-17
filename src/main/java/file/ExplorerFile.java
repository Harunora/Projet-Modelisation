package file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import graph.FileReader;
import graph.Graph;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class ExplorerFile {
	private TreeView<File> tree;
	protected MapFile mapFile = new MapFile();
	private File current = null;
	private String currentPath = "";
	private Graph graph;
	private String tmp;
	public FileReader r = new FileReader();
	public static boolean existFile(File[] f, File f1) {
		for (int i = 0; i < f.length; i++) {
			if (f[i].equals(f1)) {
				return true;
			}
		}
		return false;
	}
	public TreeView<File> getTree() {
		return tree;
	}

	public void setTree(TreeView<File> tree) {
		this.tree = tree;
	}

	public TreeItem<String> getNodesForDirectory(File directory) throws IOException {
		this.currentPath = "";
		TreeItem<String> root = new TreeItem<String>();

		for (File f : directory.listFiles()) {
			if (!f.isDirectory()) {
				String rep = directory.getAbsolutePath();
				this.currentPath = rep;
				File repFile = new File(rep);

				File[] fichiersPly = repFile.listFiles(new FileFilter() {
					public boolean accept(File pathname) {
						String fileName = pathname.getName();
						return fileName.endsWith(".ply");
					}
				});
				
				if (existFile(fichiersPly, f)) {
					for(int i = 0; i < fichiersPly.length ; i++) {
						mapFile.add(fichiersPly[i].getName(), fichiersPly[i]);
					}
					root.getChildren().add(new TreeItem<String>(f.getName()));
					
				}
			}			
		}
		return root;
	}
	public File getFile(TreeView<String> tv) {
		tv.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				tmp = ((TreeItem<String>) newValue).getValue();
			}
		});	
		current = mapFile.getFileOf(tmp);
		return current;
	}
	public void setCurrent(File current) {
		this.current = current;
	}
	public String getCurrentPath(TreeView<String> tv) {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	public Graph getGraph() {
		return graph;
	}
}