/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author irina
 */
public class HelpMenuView {
    
    Scanner keyboard = new Scanner(System.in);
    private final String theHelpMenu;
    private final int max;
    
    /**
    * The displayHelpView method
    * Purpose: displays the menu, gets the user's input, and does the
    *   selected action
    * Parameters: none
    * Returns: none
    */
    // =========================================================
        public void displayMenuView()
    {
        int menuOption;
        do
        {
            // Display the menu
            System.out.println(theHelpMenu);
            
            // Prompt the user and get the user’s input
            menuOption = getMenuOption();
            
            // Perform the desired action
            doAction(menuOption);
            
            // Determine and display the next view
        } while (menuOption != max);
     }
    
    /**
    * The HelpMenuView constructor
    * Purpose: Initialize the menu data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public HelpMenuView()
    {
        theHelpMenu = "\n" +
            "**********************************\n" +
            "* CITY OF AARON: HELP MENU *\n" +
            "**********************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another location?\n" +
            " 5 - How do I display a list of animals, provisions, and tools in the city storehouse?\n" +
            " 6 - Back to the Main Menu.\n";

        max = 6;
    }  
    
    /**
    * The getMenuOption method
    * Purpose: gets the user's input
    * Parameters: none
    * Returns: integer - the option selected
     * @return 
    */
    // ===================================
    public int getMenuOption()
    {
        // declare a variable to hold user’s input
        int userInput;
        
        // begin loop
        do
        {    
            // get user input from the keyboard
            userInput = keyboard.nextInt();
            
            // if it is not a valid value, output an error message
            if (userInput < 1 || userInput > max)
            {
            System.out.println("Option must be between 1 and " + max);
            }
            
        // loop back to the top if input was not valid
        } while(userInput < 1 || userInput > max);
        
        // return the value input by the user
        return userInput;
    }
    
    /**
    *The doAction method
    * Purpose: performs the selected action
    * Parameters: none
    * Returns: none
     * @param option
    */
    // ===================================
    public void doAction(int option)
    {
        switch (option)
        {
            case 1: // if the option is 1, call displayGoalsOfTheGame( )
                displayGoalsOfTheGame();
                break;
            case 2: // if the option is 2, call displayLocationOfCity( )
                startLocationOfCity();
                break;
            case 3: // if the option is 3, call displayHowToViewMap( )
                displayHowToViewMap();
                break;
            case 4: // if the option is 4, call displayHowToMoveLocation( )
                displayHowToMoveLocation();
                break;
            case 5: // if the option is 5, displayStoreHouseList()
                displayStoreHouseList();
                break;
            case 6: // if the option is 6, return to main menu
                break;
        }        
    } 

    private void displayGoalsOfTheGame() {
    System.out.println("This option will display the goals of the game.");    
    }

    private void startLocationOfCity() {
    System.out.println("This option will display where the city of Aaron is located.");    
    }

    private void displayHowToViewMap() {
    System.out.println("This option will tell you how to display the map.");    
    }

    private void displayHowToMoveLocation() {
    System.out.println("This option will explain how to move to a location.");    
    }

    private void displayStoreHouseList() {
    System.out.println("This option will display the contents of the storehouse.");    
    }
}
