package Game;

import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;

public class Menu {
    private ArrayList<String> menuElements;
    private int menuSize;

    Menu(String... menuItems){
        menuElements = new ArrayList<>();
        for (String menuItem : menuItems) {
            menuElements.add(menuItem);
        }
        menuSize = menuElements.size();
    }


    public void displayMenu() throws InterruptedException, LineUnavailableException{
        for (int i = 1; i < menuElements.size() + 1; i++) {
            System.out.printf("%d. %s", i, menuElements.get(i-1));
            System.out.println();
            //Thread.sleep(1000);
            GameSound s = new GameSound();
            s.tone(400, 600);
        }
    }

    public int getMenuSize(){
        return menuSize;
    }

}
