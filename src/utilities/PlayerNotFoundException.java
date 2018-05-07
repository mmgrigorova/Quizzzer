package utilities;

/**
 * This exception ensures that when Administrator tries to delete or punish a player who does not exist, they get
 * notified about it.
 */

public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException (String message){
            super(message);
    }
}
