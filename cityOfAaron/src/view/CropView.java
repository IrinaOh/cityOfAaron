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
                CropControl.buyLand(price, acresToBuy, cropData);
            }
            catch (CropException e)
            {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);

        //output how much land we now own
        System.out.format("\nYou now own %d acres of land.",cropData.getAcresOwned());
    }    
    
    public static void sellLandView() {
        //Get cost of land this round
        int price = CropControl.calcLandCost();
        //prompt the user to enter the number of acres to buy
        System.out.format("\nLand is selling for %d bushels per acre.%n", price);
        
        boolean ok = true;
        do {
            try {
                System.out.print("How many acres of land do you wish to sell?");
                //Get the user's input and save it
                int toSell;
                toSell = keyboard.nextInt();
                
                // actually sell the land
                CropControl.sellLand(price, toSell, cropData);
                ok =  false;
            }
            catch (CropException e) {
                System.out.println(e.getMessage());
                ok = true;
            }
        } while (ok); 
        //output how much land we now own
        System.out.format("\nYou now own %d acres of land.",cropData.getAcresOwned());
    }
    
    public static void feedPeopleView() {
        //get amount of wheat in store
        int wheat = cropData.getWheatInStore();
        int peopleFed = cropData.getPeopleFed();
        //display wheat in store to user
        System.out.format("\nThere are %d bushels of wheat in store.%n", wheat);
        
        boolean ok = true;
        
        do {
            ok = false;
            //ask user how much wheat to feed the people
            System.out.print("\nHow much wheat would you like to give to the people?");
            //get input
            int wheatForPeople = keyboard.nextInt(); 
            try{
                //give to the people
                CropControl.feedPeople(wheatForPeople, cropData);
            }
            catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                ok = true;
            }
        } while (ok);   
        
        //display to user 
        System.out.format("\nYou now own %d bushels of wheat.", cropData.getWheatInStore());
    }
    
    public static void plantCropsView() {
        //get acres owned and wheat in store from player
        int acres = cropData.getAcresOwned();
        int wheat = cropData.getWheatInStore();
        boolean paramsNotOkay;
        
        //ask how many acres to plant and catch exceptions       
        do{
            paramsNotOkay = false;
            //ask user how many bushels of wheat to plant
            System.out.println("\nHow many acres of land would you like to plant?");
            //get user's input and save it
            int landToPlant;
            landToPlant = keyboard.nextInt();
            try {
                //call plantCrops method to plant crops
                CropControl.plantCrops(landToPlant, cropData);
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while(paramsNotOkay);
        
        //display acres and wheat to user 
        System.out.format("\nYou now own %d bushels of wheat.", cropData.getWheatInStore());
        System.out.format("\nYou have planted %d acres of land total.", cropData.getAcresPlanted());
    }
    
    public static void setOffering() {

        boolean paramsNotOkay;      
        do{
            paramsNotOkay = false;
            System.out.println("\nHow much offering would you like to make in percent?");
            //get user's input and save it
            int offering = keyboard.nextInt();
            try {
                CropControl.setOffering(offering, cropData);
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        }while(paramsNotOkay);
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
        feedPeopleView();
        plantCropsView();  
        setOffering();
        CropControl.harvestCrops(cropData);
        CropControl.payOffering(cropData);
        CropControl.calcEatenByRats(cropData);
        CropControl.growPopulation(cropData);
        CropControl.calcStarved(cropData);
    }
}
