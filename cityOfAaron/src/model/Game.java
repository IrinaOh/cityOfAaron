/*
* The main() class file for the cityOfAaron project
* CIT-260
* Fall 2018
* Team members: Irina O'Hara, Rob Nebeker, Justin Wakefield
*/
package model;
import java.io.Serializable;

/**
 *
 * @author irina
 */
public class Game implements Serializable{
    private Player player;
    
    public Game(){}

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
}
