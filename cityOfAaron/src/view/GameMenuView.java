/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.CropControl;
import control.GameControl;
import java.util.Scanner;
import model.*;


/**
 *
 * @author Justin Wakefield
 */
public class GameMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    
    Game theGame = new Game();
    
  
    

     public GameMenuView()
    {
        super("\n" +
            "**********************************\n" +
            "* CITY OF AARON: GAME MENU *\n" +
            "**********************************\n" +
            " 1 - View the map\n" +
            " 2 - View/Print a list\n" +
            " 3 - Move to a new location\n" +
            " 4 - Manage the Crops\n" +
            " 5 - Return to the Main menu\n" ,

        5);
    } 
     
     
 
    
    /**
     * Method: doAction
     * Purpose: performs selected option
     * Parameters:
     * @param option
     * Returns: none
     */
    @Override
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
        GameControl theGameControl = new GameControl();
        theGameControl.displayMap(); 
    }
    
    public void viewList() {
        System.out.println("View List Option Selected");
        ListMenuView lv = new ListMenuView();
        lv.displayMenu(); 
    }

    public void moveToNewLocation() {
        System.out.println("Move to New Location Option Selected");
    }
    
    public void manageCrops() {
        System.out.println("Manage Crops Option Selected");
        CropView.buyLandView();
        CropView.sellLandView();
        CropView.plantCropsView();
    }
}
