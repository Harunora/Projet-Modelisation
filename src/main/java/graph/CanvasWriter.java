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


/**
 * The Class CanvasWriter.
 */
public class CanvasWriter implements Observer{

	/** The model. */
	public Graph model;
	
	/** The canvas. */
	public Canvas canvas;
	
	/** The graphic context. */
	public GraphicsContext graphicContext;
	
	/** The point color. */
	protected Color pointColor;
	
	/** The background color. */
	protected Color backgroundColor;
	
	/** The line color. */
	protected Color lineColor;
	
	/** The x. */
	protected List<double[]> x;
	
	/** The y. */
	protected List<double[]> y;
	
	/** The z. */
	protected List<double[]> z;
	
	/** The color. */
	protected List<Color> color;
	
	/** The height. */
	protected double height;
	
	/** The width. */
	protected double width;
	
	/** The line print. */
	private boolean linePrint = true;
	
	/** The color print. */
	private boolean colorPrint = true;
	
	/** The point print. */
	private boolean pointPrint = true;
	
	/** The homothesie. */
	public int homothesie=-100;

	/**
	 * Instantiates a new canvas writer.
	 *
	 * @param c the c
	 * @param lf the lf
	 */
	public CanvasWriter(Canvas c, Graph lf) {
		x=new ArrayList<double[]>();
		y=new ArrayList<double[]>();
		z=new ArrayList<double[]>();
		color=new ArrayList<Color>();
		backgroundColor = Color.GRAY;
		lineColor= Color.BLACK;
		pointColor=Color.BLACK;
		canvas=c;
		graphicContext=c.getGraphicsContext2D();
		width=c.getWidth()/2;
		height=c.getHeight()/2;
		model=lf;
		this.update(model);
	}

	/*
	public void changeHomothesie(int i) {
		homothesie=i;
		useGraph();

	}
	*/

	/**
	 * Write on canvas.
	 */
	public void writeOnCanvas() {
		clear(backgroundColor);
		for(int i=0;i<this.x.size();i++){
			if(pointPrint) {
				graphicContext.setStroke(pointColor);
				for(int j=0;j<this.x.get(i).length;j++) {
					graphicContext.strokeOval(this.x.get(i)[j]-1,this.y.get(i)[j]-1,2, 2);
				}
			}
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

	/**
	 * Clear.
	 *
	 * @param c the c
	 */
	public void clear(Paint c) {
		graphicContext.setFill(c);
		graphicContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

	}

	/**
	 * Use graph.
	 */
	public void useGraph() {
		this.x.clear();
		this.y.clear();
		this.z.clear();
		this.color.clear();
		Collections.sort(model.getFaces());
		System.out.println("oui");
		for(int i=0;i<model.getNbFaces();i++) {
			double[] i1=new double[this.model.getFace(i).nbvertices];
			double[] i2=new double[this.model.getFace(i).nbvertices];
			double[] i3=new double[this.model.getFace(i).nbvertices];
			for(int j=0;j<this.model.getFace(i).nbvertices;j++) {
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

	/**
	 * Prints the line.
	 *
	 * @param value the value
	 */
	public void printLine(boolean value) {
		this.linePrint=value;
	}

	/**
	 * Prints the color.
	 *
	 * @param value the value
	 */
	public void printColor(boolean value) {
		this.colorPrint=value;
	}
	
	/**
	 * Prints the point.
	 *
	 * @param value the value
	 */
	public void printPoint(boolean value) {
		this.pointPrint=value;
	}
	
	/**
	 * Sets the background color.
	 *
	 * @param value the new background color
	 */
	public void setBackgroundColor(Color value) {
		this.backgroundColor=value;
		useGraph();
	}
	
	/**
	 * Sets the line color.
	 *
	 * @param value the new line color
	 */
	public void setLineColor(Color value) {
		this.lineColor=value;
		useGraph();
	}
	
	/**
	 * Sets the point color.
	 *
	 * @param value the new point color
	 */
	public void setPointColor(Color value) {
		this.pointColor=value;
		useGraph();
	}

	/**
	 * Update.
	 *
	 * @param subj the subj
	 */
	@Override
	public void update(Subject subj) {
		// TODO Auto-generated method stub
		update(subj, null);
	}

	/**
	 * Update.
	 *
	 * @param subj the subj
	 * @param data the data
	 */
	@Override
	public void update(Subject subj, Object data) {
		this.model= (UpdateGraph) subj;
		useGraph();
	}

}
