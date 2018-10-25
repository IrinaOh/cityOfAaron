/*
* The main() class file for the cityOfAaron project
* CIT-260
* Fall 2018
* Team members: Irina O'Hara, Rob Nebeker, Justin Wakefield
*/
package cityofaaron;

import model.Player;
import model.TeamMember;
import model.ListItem;

/**
 *
 * @author irina
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flintstone");
        
        System.out.println(playerOne.toString());
        
        System.out.println(TeamMember.Father.toString());
    }
    
}
