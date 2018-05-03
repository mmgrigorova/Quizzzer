package users;

import java.util.Iterator;
import java.util.List;

public class Administrator extends User {

	public Administrator(String userName) {
		super(userName);
	}
	
	public void punishPlayer(String playerName, int pointsToDeduct, List<Player> players) {
		boolean operationDone = false;
		for (Player p : players) {
			if (p.getUserName().equals(playerName)) {
				p.decreasePoints(pointsToDeduct);
				operationDone = true;
			}
		}
		if (!operationDone) {
			System.out.println("There is no such player");
		}
	}
	
	public void deletePlayer(String playerName, List<Player> players) {
		boolean operationDone = false;
		
		for (Iterator<Player> it = players.iterator(); it.hasNext(); ) {
			if (it.next().getUserName().equals(playerName)) {
				it.remove();
				operationDone = true;
			}
		}
		
		if (!operationDone) {
			System.out.println("There is no such player");
		}
	}
}
