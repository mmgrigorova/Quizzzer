package game;

import users.Player;
import utilities.Display;

import java.util.List;

public class Ranklist {
    private static int LINE_LENGTH = 70;


    public static void showRanklist(List<Player> players) {
        players.sort((p1, p2) -> {
            return p2.getPoints() - p1.getPoints(); // Ascending
        });

        Display.printHeader("Player Ranklist");
        
        String leftAlignFormat = "| %-4s | %-20s | %-10s | %-93s |%n";

        System.out.format(leftAlignFormat,"RANK", "PLAYER NAME", "POINTS", "BADGES");
        
        Display.drawLine();   
	    for (Player p : players) {
	    	int rank = players.indexOf(p) + 1;
	    	 System.out.format(leftAlignFormat,rank, p.getUserName(), p.getPoints(), p.getBadges());
	         Display.drawLine("-");
	    }
        for (int i = 0; i < 5; i++) {
           
        }

        Display.printFooter();
    }

    private static String formatLines(Player p) {
        String name = p.getUserName();
        String points = String.valueOf(p.getPoints());

        StringBuilder dots = new StringBuilder();
        int dotNumber = LINE_LENGTH - name.length() - points.length();
        for (int i = 0; i < dotNumber; i++) {
            dots.append(".");
        }
        return String.format("%s" + dots + "%s", name, points);
    }

}
