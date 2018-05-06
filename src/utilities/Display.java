package utilities;

public class Display {
    private static int SCREEN_WIDTH = 140;
    private static int START_PADDING = 8;

    public static void drawLine() {
        System.out.printf("|");
        for (int i = 0; i < SCREEN_WIDTH - 2; i++) {
            System.out.printf("_");
        }
        System.out.println("|");
        printFormatted("");
    }

    public static void drawLine(String symbol) {
        System.out.printf("|");
        for (int i = 0; i < SCREEN_WIDTH - 2; i++) {
            System.out.printf(symbol);
        }
        System.out.println("|");
        printFormatted("");
    }

    public static void drawPlayerHeader(String playerName, int gamePoints) {
        drawLine();
        printFormatted("Player: " + playerName);
        printFormatted("Points: " + gamePoints);
        drawLine(".");
    }

    public static void drawPlayerHeader(String playerName1, int gamePoints1, String playerName2, int gamePoints2) {
        drawLine();
        String top = String.format("%1$-10s %2$80s", playerName1, playerName2);
        String bottom = String.format("%1$-10s %2$80s", gamePoints1, gamePoints2);
        printFormatted(top);
        printFormatted(bottom);
        drawLine(".");
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
        String[] linesToPrint = toPrint.split("\n");
        for (String s : linesToPrint) {
            int startPadding = START_PADDING;
            int endPadding = SCREEN_WIDTH - (startPadding + s.length() + 1);
            if (s.contains("\t")) {
                endPadding -= 3;
            }
            System.out.printf("|       ");
            System.out.printf("%s", s);
            System.out.printf("%" + endPadding + "s|", " ");
            System.out.println();
        }

    }

    public static void skipLine() {
        printFormatted(" ");
    }

    public static void printTitle(String title) {
        Display.drawLine();
        Display.printFormatted(title);
        Display.skipLine();
    }

    public static void printHeader(String header) {
        Display.drawLine();
        Display.printFormatted(header);
        Display.drawLine(".");
    }

    public static void printFooter() {
        skipLine();
        drawLine();
    }
}