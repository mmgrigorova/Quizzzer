package game;

import users.Player;
import utilities.Display;

import java.util.List;

public class Ranklist {
    private static int LINE_LENGTH = 70;

     //sort list of players by points and write it on console
//    public static void showRanklist(List<Player> players) {
//        players.sort((p1, p2) -> {
//            return p2.getPoints() - p1.getPoints(); // Ascending
//        });
//
//        Display.printHeader("Player Ranklist");
//
//        for (Player p : players) {
//            int rank = players.indexOf(p) + 1;
//            Display.printFormatted(rank + ". " + formatLines(p));
//        }
//
//        Display.printFooter();
//    }
    
    public static void showRanklist(List<Player> players) {
        players.sort((p1, p2) -> {
            return p2.getPoints() - p1.getPoints(); // Ascending
        });

        Display.printHeader("Player Ranklist");
        
        String leftAlignFormat = "| %-3s | %-35s | %-30s | %-35s |%n";

        System.out.format("+......+..............................+................................+.....................................+%n");
        System.out.format(leftAlignFormat,"Rank", "Player Name", "Points", "Badges");
        
    
      
        
        System.out.format("+.....................................+................................+.....................................+%n");        
//	    for (Player p : players) {
//	    	int rank = players.indexOf(p) + 1;
//	    	System.out.format(leftAlignFormat, "some data" + i, i * i, "master");
//	    	Display.printFormatted(rank + ". " + formatLines(p));
//	    }
        for (int i = 0; i < 5; i++) {
            System.out.format(leftAlignFormat,i+1, "some data" + i, i * i, "master");
            System.out.format("+.....................................+................................+.....................................+%n");     
        }
        //System.out.format("+-----------------+------+%n");

     
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
