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
	private File current = null;
	private String currentPath = "";
	private Graph graph;
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

	public TreeItem<File> getNodesForDirectory(File directory) throws IOException {
		this.currentPath = "";
		TreeItem<File> root = new TreeItem<File>(directory.getAbsoluteFile());

		for (File f : directory.listFiles()) {
			if (f.isDirectory()) {
				root.getChildren().add(getNodesForDirectory(f));
			} else {
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
					root.getChildren().add(new TreeItem<File>(f.getCanonicalFile()));
				}
			}
		}
		return root;
	}
	public File getFile(TreeView<File> tv) {
		tv.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				current = ((TreeItem<File>) newValue).getValue();
			}
		});	
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