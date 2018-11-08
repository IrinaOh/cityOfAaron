/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import model.*;


/**
 *
 * @author Justin Wakefield
 */
public class GameMenuView {
    Scanner keyboard = new Scanner(System.in);
    private final String gameMenu;
    private final int max;
    
   /**
     * Constructor
     * Purpose: Initialize menu data
     * Parameters: none
     * Returns: none
     */
    
  public void displayMenuView()
    {
        
        Game myGame = new Game();
         int menuOption;
            do
            {
            //Display the Menu
                 System.out.println(gameMenu);
            //Prompt for input
                menuOption = getMenuOption();
            //Perform actions
                   doAction(menuOption);
            //Determine next view
            }  while (menuOption != max);    
    }
     public GameMenuView()
    {
        gameMenu = "\n" +
            "**********************************\n" +
            "* CITY OF AARON: GAME MENU *\n" +
            "**********************************\n" +
            " 1 - View the map\n" +
            " 2 - View/Print a list\n" +
            " 3 - Move to a new location\n" +
            " 4 - Manage the Crops\n" +
            " 5 - Return to the Main menu\n" ;

        max = 5;
    } 
    public int getMenuOption() {
    // The getMenuOption method
    int userInput;
    // begin loop
        do{
            // get user input from the keyboard
            userInput = keyboard.nextInt();

            // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\noption must be between 1 and " + max);
            } 
            return userInput;
            }while(userInput < 1 || userInput > max);
        
        }
    
    /**
     * Method: doAction
     * Purpose: performs selected option
     * Parameters:
     * @param option
     * Returns: none
     */
     public void doAction(int option) {
        // governing switch statement
        switch (option) {
            
            case 1: // View Map
                viewMap();
                break;
        
            case 2: // view list
                viewList();
                break;
          
            case 3: // move to new location
                moveToNewLocation();
                break;
          
            case 4: // manage crops
                manageCrops();
                break;
            
            case 5: //return to main menu
                break;
        }
    }
    
   
    public void viewMap() {
        System.out.println("View Map Option Selected"); 
    }
    
    public void viewList() {
        ListMenuView lmv = new ListMenuView();
        lmv.displayMenuView();
    }

    public void moveToNewLocation() {
        System.out.println("Move to New Location Option Selected");
    }
    
    public void manageCrops() {
        System.out.println("Manage Crops Option Selected");
    }
}
