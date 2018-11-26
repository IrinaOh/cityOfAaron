/*
* The main() class file for the cityOfAaron project
* CIT-260
* Fall 2018
* Team members: Irina O'Hara, Rob Nebeker, Justin Wakefield
*/
package cityofaaron;

import model.Player;
import model.TeamMember;
import model.Game;
import view.*;

/**
 *
 * @author irina
 */
public class CityOfAaron {
    // variable for keeping a reference to the Game object
    private static Game game = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Player playerOne = new Player();
        
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenu();
        
//        Game game = new Game();
//        
//        playerOne.setName("Fred Flintstone");
//        
//        System.out.println(playerOne.toString());
//        
//        System.out.println(TeamMember.Father.toString());
    }

    
    public static Game getGame() {
       return game;
    }
    
    
    public static void setGame(Game game) {
        CityOfAaron.game = game;        
    }    
}
