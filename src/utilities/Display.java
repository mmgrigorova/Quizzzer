package utilities;

public class Display {
    private static int SCREEN_WIDTH = 110;
    private static int START_PADDING = 8;

    public static void drawLine() {
        System.out.printf("|");
        for (int i = 0; i < SCREEN_WIDTH-2; i++) {
            System.out.printf("_");
        }
        System.out.println("|");
        printFormatted("");
    }

    public static void drawPlayerHeader(String playerName, int gamePoints) {
        System.out.println(playerName + " game Points: " + gamePoints);
    }

    public static void showGameName() {
        System.out.printf("   _    _    _    _    _    _    _    _  \n" +
                "  / \\  / \\  / \\  / \\  / \\  / \\  / \\  / \\ \n" +
                " ( Q )( U )( I )( Z )( Z )( Z )( E )( R )\n" +
                "  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/  \\_/ \n");


        Display.drawLine();
        printFormatted("QUIZZZER GAME");
        Display.drawLine();
    }

    public static void printFormatted(String toPrint) {
        int startPadding = START_PADDING;
        int endPadding = SCREEN_WIDTH - (startPadding+toPrint.length()+1);
        System.out.printf("|       ");
        System.out.printf("%s", toPrint);
        System.out.printf("%" + endPadding + "s|",  " ");
        System.out.println();
    }
}