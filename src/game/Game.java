package game;

import users.Player;
import utilities.Display;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Game implements Finishable, Playable {
    protected static List<Player> players;
    protected static List<Question> questions;
    protected InGameQuestionList questionList;
    private QuestionCategory questionCategory;

    protected Game(QuestionCategory questionCategory) {
        //players = new ArrayList<>();
        this.questionCategory = questionCategory;
        //this.gameMode = gameMode;
    }

    
    // load players and questions
    public static void loadData() {

        players = new ArrayList<>();
        questions = new ArrayList<>();
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            fin = new FileInputStream("Players.txt");
            ois = new ObjectInputStream(fin);
            while (true) {
                try {
                    players.add((Player) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            fin = new FileInputStream("Questions.txt");
            ois = new ObjectInputStream(fin);
            while (true) {
                try {
                    questions.add((Question) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // saves list of players to file
    public static void saveGame() {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fout = new FileOutputStream("Players.txt");
            oos = new ObjectOutputStream(fout);

            for (Player player : players) {
                oos.writeObject(player);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addQuestion(Question newQuestion) {
        questions.add(newQuestion);
    }

    public void welcomePlayer(String playerName, Player player) {
        Display.printTitle("** Hello, " + playerName + "! You have " + player.getPoints() +
                " points. Have fun playing Quizzzer! **");
        Display.drawLine(".");
    }

    protected void addPointsToPlayer(Player player, int points) {
        player.increasePoints(points);
    }

    InGameQuestionList initializeQuestionList() {
        // TODO Auto-generated method stub
        return null;
    }

    public void addPlayer(Player p) {
        Game.players.add(p);
    }

    protected void displayGameInformation(String playerName, int gamePointsPlayer) {
        Display.drawPlayerHeader(playerName, gamePointsPlayer);
    }

    protected abstract int getPlayersAnswer();
}
