package game;

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
            System.out.printf("%d. %s", i, menuElements.get(i-1));
            System.out.println();
        }
    }

    public int getMenuSize(){
        return menuSize;
    }

}
