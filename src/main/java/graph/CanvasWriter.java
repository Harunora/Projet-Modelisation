package graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter {
	
	Canvas canvas;
	GraphicsContext graphicContext;
	Graph listface;
	List<Color> color;
	List<double[]> x;
	List<double[]> y;
	
	public CanvasWriter(Canvas c, Graph lf) {
		
		// TODO Auto-generated constructor stub
		this.x=new ArrayList<double[]>();
		this.y=new ArrayList<double[]>();
		this.canvas=c;
		graphicContext=c.getGraphicsContext2D();
		
		listface=lf;
		useGraph();
	}
	
	public void writeOnCanvas() {
		for(int i=0;i<x.size();i++) {
			double[] i1=this.x.get(i);
			double[] i2=this.y.get(i);
			
			graphicContext.strokePolygon(i1, i2, i1.length);
			
			//graphicContext.setFill(null);
			//graphicContext.fillPolygon(i1, i2,i1.length);
		}
	}
	
	public void useGraph() {
		for(int i=0;i<listface.getNbFaces();i++) {
			double[] i1=new double[this.listface.faces.get(i).nbSommet];
			double[] i2=new double[this.listface.faces.get(i).nbSommet];
			for(int j=0;j<this.listface.faces.get(i).nbSommet;j++) {
				i1[j]=this.listface.faces.get(i).sommets.get(j).getX()+canvas.getHeight()/2;
				i2[j]=this.listface.faces.get(i).sommets.get(j).getY()+canvas.getWidth()/2;
				System.out.println(i1[j]+";"+i2[j]);
			}
			
			this.x.add(i1);
			this.y.add(i2);
			
		}
		writeOnCanvas();
	}
}
