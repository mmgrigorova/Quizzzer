package game;

import utilities.Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Instruction {
    private static String instructions = "Quizzzer is a trivia game which you can play by yourself or with a " +
            "friend."+
            "\nFirst you need to select if you want to play by yourself(Single Player mode) or with a friend (Double " +
            "player mode)." +
            "\nThe Single player questions are closed questions with four possible answers. One of them is correct." +
            "\nThe Double player questions are open questions which require input by each player."+
            "The winner is the player who was closest to the correct answer."+
            "\nEvery correct question brings certain amount of points."+
            "At the end of the game, should you decide the Save and Exit the Quizzzer, the accumulated points get " +
                    "added to each player's profile.";

//    private static String instructions = "Quizzzer is a trivia game which you can play by yourself or with a " +
//            "friend.";

    public static void showInstructions(){
        Display.printHeader("How to Play Quizzzer");
        ArrayList<String> instructionLines = splitByLength(instructions, 70);
        for (String instructionLine : instructionLines) {
                Display.printFormatted(instructionLine);
        }
        Display.skipLine();
        Display.printFormatted("Have a nice time playing Quizzzer!");
        Display.drawLine();
    }


    private static ArrayList<String> splitByLength(String str, int size) {
        ArrayList<String> lines = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        String par = str;

        while (par.length() > 0){
            if(par.length() > size){
                int start = Math.min(size,par.length());
                for (int i = start; i > 0; i--) {
                    if(par.charAt(i) == ' '){
                        endIndex = i;
                        break;
                    }
                }

            String chunk = par.substring(startIndex, endIndex);
            lines.add(chunk);
            par = par.substring(endIndex);
            } else {
                lines.add(par);
                break;
            }
        }
        return lines;
    }
}
