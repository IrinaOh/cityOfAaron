// The MainMenuView class - part of the view layer
// Object of this class manages the main menu
// Author: Justin, Rob, Austin, Irina team
// Date last modified: November 2018
//-------------------------------------------------------------
package view;
import control.GameControl;
import java.util.Scanner;
/**
 *
 * @author irina
 */
public class MainMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);


    /**
    * The displayMenu method
    * Purpose: displays the menu, gets the user's input, and does the
    * selected action
    * Parameters: none
    * Returns: none 
    */

    public  MainMenuView(){
        super ("\n" +
        "**********************************\n" +
        "* CITY OF AARON: MAIN GAME MENU *\n" +
        "**********************************\n" +
        " 1 - Start new game\n" +
        " 2 - Get and start a saved game\n" +
        " 3 - Get help on playing the game\n" +
        " 4 - Save game\n" +
        " 5 - Quit\n",
        5);
    }
    /**
    *The doAction method
    * Purpose: performs the selected action
    * Parameters: none
    * Returns: none
     * @param option
    */
    // ===================================
    @Override
    public void doAction(int option)
    {
        switch (option)
        {
        case 1: // create and start a new game
        startNewGame();
        break;
        case 2: // get and start a saved game
        startSavedGame();
        break;
        case 3: // get help menu
        displayHelpMenuView();
        break;
        case 4: // save game
        displaySaveGameView();
        break;
        case 5:
        System.out.println("Thanks for playing ... goodbye.");
        }
    } 
    
    /**
    * The startNewGame method
    * Purpose: creates game object and starts the game
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public void startNewGame()
    {
        // Display the Banner Page.
        System.out.println("Welcome to the city of Aaron");
        // Create a new Player object
        // Prompt for and get the user’s name.
        String name;
        System.out.println("Please type in your first name: ");
        name = keyboard.next();
        // Call the CreateNewGame() method in the GameControl class
        control.GameControl.createNewGame(name);
        // Display a welcome message
        System.out.println("Welcome " + name + " have fun!!!");
        GameControl.createNewGame(name);
        GameControl.createCropDataObject();
        GameControl.createMap();
        GameControl.createToolList();
        // Display the Game menu
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    }
    
    /**
    * The startNewGame method
    * Purpose: creates game object and starts the game
    * Parameters: none
    * Returns: none
    */
    // ===================================
    
    public void startSavedGame() 
    {
        System.out.println("Start Saved Game option Selected");
        Scanner input = new Scanner(System.in);    

        // prompt user to get a file path
        System.out.println("Enter name of previously saved game: ");
        String fileName;
        fileName = input.nextLine();
        // call the getSavedGame() method in the GameControl class
        GameControl gc = new GameControl();
        gc.getSavedGame(fileName);
        System.out.println("Your game " + fileName +  " has been restored");
        // display the game menu for the loaded game
        GameMenuView gm = new GameMenuView();
        gm.displayMenu();
    }
    
    public void displayHelpMenuView()
    {
        HelpMenuView hmv = new HelpMenuView();
        hmv.displayMenu(); 
    }
    
    public void displaySaveGameView()
    {
        SaveGameView sgv = new SaveGameView();
        sgv.displayMenu();
    }

}