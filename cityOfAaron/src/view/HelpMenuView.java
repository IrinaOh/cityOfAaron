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
public class HelpMenuView extends MenuView{
    
    Scanner keyboard = new Scanner(System.in);
    
    /**
    * The HelpMenuView constructor
    * Purpose: Initialize the menu data
    * Parameters: none
    * Returns: none
    */
    // ===================================
    public HelpMenuView()
    {
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: HELP MENU *\n" +
            "**********************************\n" +
            " 1 - What are the goals of the game?\n" +
            " 2 - Where is the city of Aaron?\n" +
            " 3 - How do I view the map?\n" +
            " 4 - How do I move to another location?\n" +
            " 5 - How do I display a list of animals, provisions, and tools in the city storehouse?\n" +
            " 6 - Back to the Main Menu.\n",
            6);
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
            case 1: // if the option is 1, call displayGoalsOfTheGame( )
                viewGoals();
                break;
            case 2: // if the option is 2, call displayLocationOfCity( )
                viewCityLocation();
                break;
            case 3: // if the option is 3, call displayHowToViewMap( )
                viewMapHelp();
                break;
            case 4: // if the option is 4, call displayHowToMoveLocation( )
                viewMoveHelp();
                break;
            case 5: // if the option is 5, displayStoreHouseList()
                viewListHelp();
                break;
            case 6: // if the option is 6, return to main menu
                break;
        }        
    } 

    private void viewGoals() {
    System.out.println("The player of the game will assume the role of the leader over the city of Aaron. Wheat\n" +
        "is the staff of life, and is used as the main currency in the city. As ruler over the city, the\n" +
        "player’s task is to manage the village’s wheat crops so that the people of the village can\n" +
        "be adequately fed, while dealing with rats, and random crop yields. The city is blessed\n" +
        "when the people pay their tithes and offerings. After serving for 10 years, the player will\n" +
        "be judged by the people. If too many people die during the player’s term of office, the\n" +
        "player is removed from office and the game ends.");    
    }

    private void viewCityLocation() {
    System.out.println("The City Of Aaron is located near the cities of Moroni and Nephihah.");    
    }

    private void viewMapHelp() {
    System.out.println("To display the map enter 6 to RETURN TO THE MAIN MENU view, start a new game, and enter 1 ");    
    }

    private void viewMoveHelp() {
    System.out.println("To move to a new location enter 6 to RETURN TO THE MAIN MENU view, start a new game, and enter 3.");    
    }

    private void viewListHelp() {
    System.out.println("To display resources enter 6 to RETURN TO THE MAIN MENU view, start a new game or continue a saved one, and enter options 1-4.");    
    }
}
