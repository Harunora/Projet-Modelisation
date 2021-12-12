package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import mvc.Observer;
import mvc.Subject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasWriter implements Observer{

	public Graph model;
	public Canvas canvas;
	public GraphicsContext graphicContext;
	protected Color modelColor;
	protected Color backgroundColor;
	protected Color lineColor;
	protected List<double[]> x;
	protected List<double[]> y;
	protected List<double[]> z;
	protected List<Color> color;
	protected double height;
	protected double width;
	private boolean linePrint = true;
	private boolean colorPrint = true;
	public int homothesie=-100;

	public CanvasWriter(Canvas c, Graph lf) {
		x=new ArrayList<double[]>();
		y=new ArrayList<double[]>();
		z=new ArrayList<double[]>();
		color=new ArrayList<Color>();
		backgroundColor = Color.GRAY;
		lineColor= Color.BLACK;
		canvas=c;
		graphicContext=c.getGraphicsContext2D();
		width=c.getWidth()/2;
		height=c.getHeight()/2;
		model=lf;
		this.update(model);
	}

	public void changeHomothesie(int i) {
		homothesie=i;
		useGraph();

	}

	public void writeOnCanvas() {
		clear(backgroundColor);
		for(int i=0;i<this.x.size();i++){
			if(colorPrint) {
				graphicContext.setFill(this.color.get(i));
				graphicContext.fillPolygon(this.x.get(i),this.y.get(i), this.y.get(i).length);
			}
			if(linePrint) {
				graphicContext.setStroke(lineColor);
				graphicContext.strokePolygon(this.x.get(i),this.y.get(i), this.y.get(i).length);
			}
		}
	}

	public void clear(Paint c) {
		graphicContext.setFill(c);
		graphicContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

	}

	public void useGraph() {
		this.x.clear();
		this.y.clear();
		this.z.clear();
		this.color.clear();
		Collections.sort(model.getFaces());
		System.out.println("oui");
		for(int i=0;i<model.getNbFaces();i++) {
			double[] i1=new double[this.model.getFace(i).nbSommet];
			double[] i2=new double[this.model.getFace(i).nbSommet];
			double[] i3=new double[this.model.getFace(i).nbSommet];
			for(int j=0;j<this.model.getFace(i).nbSommet;j++) {
				i1[j]=this.model.getFaceX(i, j)*homothesie+height;
				i2[j]=this.model.getFaceY(i, j)*homothesie+width;
				i3[j]=this.model.getFaceZ(i, j)*homothesie+width;
			}
			this.x.add(i1);
			this.y.add(i2);
			this.z.add(i3);
			Color tmp=this.model.getFace(i).getColor();
			this.color.add(tmp);
		}
		writeOnCanvas();
	}

	public double getHighestValue(double[] tab) {
		double retour=-1000.00;
		for(int i=0;i<tab.length;i++) {
			if(retour<tab[i]) {
				retour=tab[i];
			}
		}
		return retour;
	}

	public int getPositionHighestZ() {
		int retour=0;

		for(int i=0;i<z.size();i++) {
			if(getHighestValue(z.get(i))>getHighestValue(z.get(retour))) {
				retour=i;
			}
		}

		return retour;
	}

	public void inversePrintLine() {
		this.linePrint=!this.linePrint;
	}

	public void inversePrintColor() {
		this.colorPrint=!this.colorPrint;
	}

	public void setBackgroundColor(Color value) {
		this.backgroundColor=value;
		useGraph();
	}
	
	public void setLineColor(Color value) {
		this.lineColor=value;
		useGraph();
	}

	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub
		update(subj, null);
	}

	@Override
	public void update(Subject subj, Object data) {
		this.model= (UpdateGraph) subj;
		useGraph();
	}

}
