package fr.epita.iam.datamodel;

/**
 * This class allows to update an Identity using user inputs
 *  @author shikha Ritu
 *
 */

public class Identity {
	private String uid;
	private String displayName;
	private String email;
	private String password;
	private boolean isAdmin = false;
	/**
	 * @param uid: Identity ID
	 * @param displayName: The name of the user
	 * @param email: Email of the user
	 */
	public Identity(String uid, String displayName, String email) {
		super();
		this.uid = uid;
		this.displayName = displayName;
		this.email = email;
	}
	
	public Identity(String uid, String displayName,
			String email, String password) {
		super();
		this.uid = uid;
		this.displayName = displayName;
		this.email = email;
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		
		return "UID: " + uid +"; NAME: " + displayName + "; EMAIL: " + email + "; PASSWORD:" + password + ";";

	}
	
	
}
