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
import exceptions.CropException;
/**
 *
 * @author Justin Wakefield
 */
public class CropView {
    // Scanner Object
    private static Scanner keyboard = new Scanner(System.in);
    // References to Game and CropData
    private static Game game = CityOfAaron.getGame();
    private static CropData cropData = game.getCropData();
    
    /**
     * Method: buyLandView
     * Purpose: interface with user input for buying land
     * Parameters: none
     * Returns: none
     */
    public static void buyLandView() {
        
        //Get the cost of land for this round.    
        int price = CropControl.calcLandCost();

        //prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);

        //Get the user's input and save it
        int acresToBuy;
        boolean paramsNotOkay;
        do
        {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to buy? "); 
            acresToBuy=keyboard.nextInt();
            try
            {
                //Call the buyLand()method in the control layer to buy the land
                CropControl.buyLand(acresToBuy, price, cropData);
            }
            catch (CropException e)
            {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);

        //output how much land we now own
        System.out.format("You now own %d acres of land.",cropData.getAcresOwned());
    }    
    
    public static void sellLandView() {
        
        //Get cost of land this round
        int price = CropControl.calcLandCost();

        //prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n", price);
        System.out.print("How many acres of land do you wish to sell?");

        //Get the user's input and save it
        int toSell;
        toSell = keyboard.nextInt();

        //call the sellLand() method in the control layer to sell the land
        CropControl.sellLand(toSell, price, cropData);

        //output how much land we now own
        System.out.format("You now own %d acres of land.",cropData.getAcresOwned());
    }
    
    public static void feedPeopleView(CropData cropData){
        //get amount of wheat in store
        int wheat = cropData.getWheatInStore();
        
        //display wheat in store to user
        System.out.format("There are %d bushels of what in store.%n",wheat);
        System.out.print("How much wheat would you like to give to the people?");
        
        //get the user's input and save it
        int wheatForPeople;
        wheatForPeople = keyboard.nextInt();
        
        //give to the people
        CropControl.feedPeople(wheatForPeople, cropData);
        
        //output how much wheat we now have
        System.out.format("You now own %d wheat.",cropData.getWheatInStore());
    }
    
    public static void plantCropsView(CropData cropData) {
        //get acres owned and wheat in store from player
        int acres = cropData.getAcresOwned();
        int wheat = cropData.getWheatInStore();
        
        //display acres and wheat to user
        System.out.format("You own %d acres of land.%n", acres); 
        System.out.format("There are %d bushels of wheat in store.%n", wheat);
         
        //ask user how many bushels of wheat to plant
        System.out.print("How many acres would you like to plant?");
         
        //get user's input and save it
        int landToPlant;
        landToPlant = keyboard.nextInt();
         
        //plant crops
    
        CropControl.plantCrops(landToPlant, cropData);
         
    }
    
    public static void cropReportView(CropData cropData) {
        System.out.println("Crop Report View");
        
        int year = cropData.getYear(); 
        int acresOwned = cropData.getAcresOwned(); 
        int wheatInStore = cropData.getWheatInStore();
        int population = cropData.getPopulation(); 
        
        //System.out.print(year);
        System.out.format("The year is %d. %n", year); 
        System.out.format("You own %d acres of land.%n", acresOwned); 
        System.out.format("There are %d bushels of wheat in store.%n", wheatInStore); 
        System.out.format("The population is %d people.%n", population); 
        
    }
    
    
    
    /**
     * Method: runCropsView
     * Purpose: runs the game
     * Parameters: none
     * Returns: none
     */
    public static void runCropsView() {
      
        cropReportView(cropData);
        buyLandView();
        sellLandView();
        feedPeopleView(cropData);
        plantCropsView(cropData);
        
     
    }
}
