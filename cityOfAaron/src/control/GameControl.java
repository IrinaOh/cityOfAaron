/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.*;
import cityofaaron.CityOfAaron;


/**
 *
 * @author irina
 */
public class GameControl {
    
    
    public static void createNewGame(String _name)
    {
        
        // create the game object
        Game game = new Game();
        
        // create the player object and set the name
        Player player = new Player();
        player.setName(_name);
        
        // save reference to the player object in the game
        game.setPlayer(player);
        
        
        // create and initialize a CropData object
        CropData cropData = new CropData();
        

        CityOfAaron.setGame(game);
    }
    public static void createCropDataObject() {
    CropData theCrops = new CropData();
           
            
            theCrops.setYear(0);
            theCrops.setPopulation(100);
            theCrops.setNewPeople(5);
            theCrops.setCropYield(3);
            theCrops.setNumberWhoDied(0);
            theCrops.setOffering(10);
            theCrops.setWheatInStore(2700);
            theCrops.setAcresOwned(1000);
            theCrops.setAcresPlanted(1000);
            theCrops.setHarvest(3000);
            theCrops.setOfferingBushels(300);
            theCrops.setAcresPlanted(1000);
            
            //save the cropData in the Game object
            
         theGame.setCropData(theCrops);    
    }
/**The createMap method
 * Purpose: creates the location objects and map
 * Parameters:none
 * Returns: none
 */
    public static void createMap()
    {
        int MAX_ROW = 0;
        int MAX_COL = 0;
        //create the Map object,
        //refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        //create a string that will go in the Location objects
        //that contain the river
        String river = "You are on the River. The river is the source\n" +
                       "of life for our city. The river marks the eastern\n" +
                       "boundary of the city - it is wilderness to the East.\n";
        
        Location loc = new Location();
        
        //use setters in the Location class to set the description and symbol
         loc.setDescription(river);
         loc.setSymbol("~~~");
         
         //set this location object in each cell of the array in column 4
        for(int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 4, loc); 
        }
        
        //define the string for a farm land location
        String farmland = "You are on the fertile banks of the River.\n" +
                          "In the spring, this low farmland floods and is covered with rich\n" +
                          "new soil. Wheat is planted as far as you can see.";
            
        //set a farmland location with a hint
        Location loc2 = new Location();
        loc2.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc2.setSymbol("///");
        theMap.setLocation(0, 2, loc2);
}
}
