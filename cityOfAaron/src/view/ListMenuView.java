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
 * @author Robert Nebeker
 */
public class ListMenuView {
    Scanner keyboard = new Scanner(System.in);
    private int max;
    private String listMenu;
    

  public void displayMenuView()
    {
        
        Game myGame = new Game();
         int menuOption = 0;
            do
            {
            //Display the Menu
                 System.out.println(listMenu);
            //Prompt for input
                menuOption = getMenuOption();
            //Perform actions
                   doAction(menuOption);
            //Determine next view
            }  while (menuOption != max);    
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
            
            case 5:
                System.out.println("Thanks for playing! Goodbye =D\n");
        }
    }

    public void listAnimals() {
        System.out.println("List Animals Option Selected");
    }

    public void listTools() {
        System.out.println("List Tools Option Selected");
    }
    
     public void listProvisions() {
        System.out.println("List Provisions Option Selected");
    }
     
    public void listTeam() {
        System.out.println("List Team Option Selected");
    }

    private void viewMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void viewList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void moveToNewLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void manageCrops() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}