package mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Subject(Sujet).
 */
public abstract class Subject {

	/** La liste d'observeur. */
	private List<Observer> list = new ArrayList<>();
	
	/**
	 * Notifie l'observeur.
	 */
	public void notifyObserver() {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this);
		}
	}

	/**
	 * Notifie l'observeur.
	 *
	 * @param data les donnees
	 */
	protected void notifyObserver(Object data) {
		for(int i = 0; i<this.list.size(); i++) {
			this.list.get(i).update(this,data);
		}
	}

	/**
	 * Atache un obeserveur au modele.
	 *
	 * @param observer l'observeur
	 */
	public void attach(Observer observer) {
		this.list.add(observer);
	}

	/**
	 * Detache un obeserveur au modele.
	 *
	 * @param observer l'observeur
	 */
	public void detach(Observer observer) {
		this.list.remove(observer);
	}
}
