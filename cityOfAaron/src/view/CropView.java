/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
/**
 *
 * @author Justin Wakefield
 */
public class CropView {
     // Scanner Object
    private static Scanner keyboard = new Scanner(System.in);
    // References to Game and CropData
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    
    /**
     * Method: buyLandView
     * Purpose: interface with user input for buying land
     * Parameters: none
     * Returns: none
     */
    public static void buyLandView() {
        
    //Get the cost of land for this round.    
    int price = CropControl.calcLandPrice();
    
    //prompt the user to enter the number of acres to buy
    System.out.format("Land is selling for %d bushels per acre.%n",price);
    System.out.print("How many acres of land do you wish to buy?");
    
    //Get the user's input and save it
    int toBuy;
    toBuy=keyboard.nextInt();
    
    //Call the buyLand()method in the control layer to buy the land
    CropControl.buyLand(toBuy,price,cropData);
    
    //output how much land we now own
    System.out.format("You now own %d acres of land.",cropData.getAcresOwned());
    }
}
