package utilities;

public class Display {
    public static void drawLine(){
        for (int i = 0; i < 40; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    public static void drawPlayerHeader(String playerName, int gamePoints){
        System.out.println(playerName + " game Points: " + gamePoints);
    }
}