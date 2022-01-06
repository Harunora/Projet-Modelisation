package mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * class Subject.
 */
public abstract class Subject {

	/** List of Observer */
	private List<Observer> list = new ArrayList<>();
	
	/**
	 * Notify the Observer.
	 */
	public void notifyObserver() {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this);
		}
	}

	/**
	 * Notify the observer.
	 *
	 * @param data the data
	 */
	protected void notifyObserver(Object data) {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this,data);
		}
	}

	/**
	 * attach a model to the observer
	 *
	 * @param observer there observer
	 */
	public void attach(Observer observer) {
		this.list.add(observer);
	}

	/**
	 * Detach an observer of the model
	 *
	 * @param observer the observer
	 */
	public void detach(Observer observer) {
		this.list.remove(observer);
	}
}
