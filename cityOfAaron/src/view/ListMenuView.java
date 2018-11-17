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
public class ListMenuView extends MenuView {
    Scanner keyboard = new Scanner(System.in);
    private final int max;
    private final String listMenu;
    
   
    public ListMenuView()
    {
       listMenu = super "\n" +
            "**********************************\n" +
            "* CITY OF AARON: LIST MENU *\n" +
            "**********************************\n" +
            " 1 - List the animals in the storehouse\n" +
            " 2 - List the tools in the storehouse\n" +
            " 3 - List the provisions in the storehouse\n" +
            " 4 - List the authors of this game\n" +
            " 5 - Return to Game Menu\n";

        max = 5;
    }
    
   
    /**
     * Method: doAction
     * Purpose: performs selected option
     * Parameters:
     * @param option
     * Returns: none
     */
    @Override public void doAction(int option) {
        // governing switch statement
        switch (option) {
            
            case 1: // View Animals
                listAnimals();
                break;
        
            case 2: // view tools
                listTools();
                break;
          
            case 3: // list provisions
                listProvisions();
                break;
          
            case 4: // list authors
                listTeam();
                break;
            
            case 5: //return to game menu
                break;
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

}