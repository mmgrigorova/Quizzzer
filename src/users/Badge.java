package users;

import java.io.Serializable;

public class Badge implements Serializable{
	private String badgeName;
	private String badgeDescription;
	
	public Badge(String badgeName, String badgeDescription) {
		this.badgeName = badgeName;
		this.badgeDescription = badgeDescription;
	}
	
	public String getBadgeName() {
		return badgeName;
	}
	
	public String getBadgeDescription() {
		return badgeDescription;
	}

}
