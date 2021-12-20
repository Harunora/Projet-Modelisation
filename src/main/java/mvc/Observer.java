package mvc;

/**
 * The Interface Observer.
 */
public interface Observer {
	
	/**
	 * Update.
	 *
	 * @param subj the subj
	 */
	public void update(Subject subj);
	
	/**
	 * Update.
	 *
	 * @param subj the subj
	 * @param data the data
	 */
	public void update(Subject subj, Object data);

}
