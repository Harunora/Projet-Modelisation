package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private List<Observer> list = new ArrayList<Observer>();
	
	protected void notifyObserver() {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this);
		}
	}

	protected void notifyObserver(Object data) {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this,data);
		}
	}

	public void attach(Observer observer) {
		this.list.add(observer);
	}

	public void detach(Observer observer) {
		this.list.remove(observer);
	}
}
