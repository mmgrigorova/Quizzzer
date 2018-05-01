package game;

import utilities.Display;

import java.util.ArrayList;

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


    public void displayMenu(){
        for (int i = 1; i < menuElements.size() + 1; i++) {
            String menuItem = String.format("%d. %s", i, menuElements.get(i-1));
            Display.printFormatted(menuItem);
        }
    }

    public int getMenuSize(){
        return menuSize;
    }

}
