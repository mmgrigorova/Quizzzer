package game;

import users.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ranklist {

    // sort list of players by points and write it on console
    public static void showRanklist(List<Player> players) {
        players.sort((p1, p2) -> {
            return p2.getPoints() - p1.getPoints(); // Ascending
        });

        //TODO Check rendering in a table: https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
        for (Player p : players) {
            System.out.println(p);
        }
    }
}
