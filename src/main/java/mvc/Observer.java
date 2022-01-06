package mvc;

/**
 * L'interface Observer.
 */
public interface Observer {
	
	/**
	 * Update.
	 *
	 * @param subj the subject
	 */
	public void update(Subject subj);
	
	/**
	 * Update.
	 *
	 * @param subj the subject
	 * @param data the data
	 */
	public void update(Subject subj, Object data);

}
