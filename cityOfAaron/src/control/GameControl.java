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
    
    // size of the Locations Array
    private static final int MAX_ROW=5;
    private static final int MAX_COL=5; 
    private static Game game;
    private static Map map;
    
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
        
        // Create Map
        Map map = new Map();
        game.setMap(map);
        
        
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
            
        game.setCropData(theCrops);    
    }
/**The createMap method
 * Purpose: creates the location objects and map
 * Parameters:none
 * Returns: none
 */
    public static void createMap()
    {

        Location loc = new Location();
        
        //create the Map object,
        //refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        
        //create a string that will go in the Location objects
        //that contain the river
        String river = "You are on the River. The river is the source\n" +
                       "of life for our city. The river marks the eastern\n" +
                       "boundary of the city - it is wilderness to the East.\n";
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
        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        theMap.setLocation(0, 2, loc);
        //Location loc2 = new Location();
        //loc2.setDescription(farmland);
        //loc2.setSymbol("!!!");
        //    for (int i = 2; i <5; i++) {
         //       theMap.setLocation(i, 2, loc2);
         //   }
        //Location loc3 = new Location();
        //loc3.setDescription(farmland);
        //loc3.setSymbol("!!!");
        //    for (int i = 3; i <4; i++) {
        //        theMap.setLocation(i, 3, loc3);
        //    }
        
     
        String mountain = "You are climbing up a mountain. The mountain surrounds\n" +
                          "your city. The mountain is south of your city\n" +
                          "It adds a boundry of protection to the city.\n";
        //use setters in the Location class to set the description and symbol
        loc.setDescription(mountain);
        loc.setSymbol("^^^");
            for (int i = 0; i <5; i++) {
                theMap.setLocation(i, 0, loc);
            }
        
        
        String forest = "You are in the forest. The forest is a source of plant\n" +
                        "and animal life. The forest is near the City and surrounding\n" +
                        "the farmland.\n";
        //use setters in the Location class to set the description and symbol
        loc.setDescription(forest);
        loc.setSymbol(":::");
            for (int i = 1; i <5; i++) {
                theMap.setLocation(i, 1, loc);
            }
        
        String city = "You are in the city of Aaron. The city is central in the map\n" +
                      "bordering the river, which is a source of life.\n" +
                      "The city is where your people live.\n";
                //use setters in the Location class to set the description and symbol
        loc.setDescription(city);
        loc.setSymbol("$$$");
            for (int i = 1; i <5; i++) {
                theMap.setLocation(4, 3, loc);
            }
    
            
}
        
     public void displayMap(){
         game = CityOfAaron.getGame();
         Map _map = game.getMap();
        for(int i = 0; i < MAX_ROW; i++)
                {
            for(int j = 0; j < MAX_COL; j++)
                if (_map.getLocation(i, j) == null){
                    System.out.println("...");
                }
                else {
                    System.out.println(_map.getLocation (i,j).getSymbol());
                }
                    System.out.println("");
                            
                }
         
         }
}
