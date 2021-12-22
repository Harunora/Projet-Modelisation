package mvc;

/**
 * L'interface Observer.
 */
public interface Observer {
	
	/**
	 * Update.
	 *
	 * @param subj le sujet
	 */
	public void update(Subject subj);
	
	/**
	 * Update.
	 *
	 * @param subj le sujet
	 * @param data les donnees
	 */
	public void update(Subject subj, Object data);

}
