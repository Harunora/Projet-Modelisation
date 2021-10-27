package graph;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter {

	Graph listface;
	public Canvas canvas;
	
	public GraphicsContext graphicContext;
	List<Color> color;
	List<double[]> x;
	List<double[]> y;
	
	double height;
	double width;
	
	public int homothesie=-100;
	
	
	public CanvasWriter(Canvas c, Graph lf) {
		x=new ArrayList<double[]>();
		y=new ArrayList<double[]>();
		canvas=c;
		graphicContext=c.getGraphicsContext2D();
		width=c.getWidth()/2;
		height=c.getHeight()/2;
		listface=lf;
		useGraph();
	}

	
	public void changeHomothesie(int i) {
		homothesie=i;
		useGraph();
		
	}
	
	public void writeOnCanvas() {
		clear(javafx.scene.paint.Color.WHITE);
		for(int i=0;i<x.size();i++) {
			graphicContext.strokePolygon(this.x.get(i),this.y.get(i), this.y.get(i).length);
			graphicContext.setFill(javafx.scene.paint.Color.RED);
			graphicContext.fillPolygon(this.x.get(i),this.y.get(i), this.y.get(i).length);
		}
	}
	
	public void clear(Paint c) {
		graphicContext.setFill(c);
		System.out.println(canvas.getWidth()+"!"+ canvas.getHeight());
		graphicContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
	}

	public void useGraph() {
		
		for(int i=0;i<listface.getNbFaces();i++) {
			double[] i1=new double[this.listface.getFace(i).nbSommet];
			double[] i2=new double[this.listface.getFace(i).nbSommet];
			for(int j=0;j<this.listface.getFace(i).nbSommet;j++) {
				i1[j]=this.listface.getFace(i).sommets.get(j).getX()*homothesie+height;
				i2[j]=this.listface.getFace(i).sommets.get(j).getY()*homothesie+width; 
			}
			
			this.x.add(i1);
			this.y.add(i2);
			
		}
		writeOnCanvas();
	}
}
