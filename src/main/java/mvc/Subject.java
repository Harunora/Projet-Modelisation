package mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Subject.
 */
public abstract class Subject {

	/** The list. */
	private List<Observer> list = new ArrayList<>();
	
	/**
	 * Notify observer.
	 */
	public void notifyObserver() {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this);
		}
	}

	/**
	 * Notify observer.
	 *
	 * @param data the data
	 */
	protected void notifyObserver(Object data) {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this,data);
		}
	}

	/**
	 * Attach.
	 *
	 * @param observer the observer
	 */
	public void attach(Observer observer) {
		this.list.add(observer);
	}

	/**
	 * Detach.
	 *
	 * @param observer the observer
	 */
	public void detach(Observer observer) {
		this.list.remove(observer);
	}
}
