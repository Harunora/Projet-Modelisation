package graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter {
	
	
	GraphicsContext graphicContext;
	Graph listface;
	List<double[]> x;
	List<double[]> y;
	public CanvasWriter(GraphicsContext gc, Graph lf) {
		// TODO Auto-generated constructor stub
		this.x=new ArrayList<double[]>();
		this.y=new ArrayList<double[]>();
		graphicContext=gc;
		listface=lf;
		for(int i=0;i<listface.getNbFaces();i++) {
			double[] i1=new double[lf.faces.get(i).nbSommet];
			double[] i2=new double[lf.faces.get(i).nbSommet];
			for(int j=0;j<lf.faces.get(i).nbSommet;j++) {
				i1[j]=lf.faces.get(i).sommets.get(j).getX();
				i2[j]=lf.faces.get(i).sommets.get(j).getY();
			}
			this.x.add(i1);
			this.y.add(i2);
		}
		
		writeOnCanvas();
	}
	
	public void writeOnCanvas() {
		for(int i=0;i<x.get(i).length;i++) {
			double[] i1=this.x.get(i);
			double[] i2=this.y.get(i);
			if(i1.length==i2.length) {
			graphicContext.strokePolygon(i1,i2,i1.length);
			}
		}
	}
}
