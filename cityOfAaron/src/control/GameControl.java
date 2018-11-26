/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.*;
import cityofaaron.CityOfAaron;
import java.util.ArrayList;


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
        CityOfAaron.setGame(game);
                
        // create the player object and set the name
        Player player = new Player();
        player.setName(_name);
        
        // save reference to the player object in the game
        game.setPlayer(player); 
        
        Map map = new Map();
        game.setMap(map);
        createMap();
    }
    
    public static void createCropDataObject() {
        CropData theCrops = new CropData();
        Game game = CityOfAaron.getGame();
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
        Game game = CityOfAaron.getGame();
        //create the Map object,
        //refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
        Location loc = new Location();
        
        String city = "You are in the city of Aaron. The city is central in the map\n" +
                      "bordering the river, which is a source of life.\n" +
                      "The city is where your people live.\n";
        //use setters in the Location class to set the description and symbol
        loc.setDescription(city);
        loc.setSymbol("$$$");
        for (int i = 0; i <MAX_ROW; i++) {
            theMap.setLocation(i, 0, loc);
        }
        
        String forest = "You are in the forest. The forest is a source of plant\n" +
                        "and animal life. The forest is near the City and surrounding\n" +
                        "the farmland.\n";
        //use setters in the Location class to set the description and symbol
        loc = new Location();
        loc.setDescription(forest);
        loc.setSymbol(":::");
        for (int i = 0; i <MAX_ROW; i++) {
            theMap.setLocation(i, 1, loc);
        }
        
        String mountain = "You are climbing up a mountain. The mountain surrounds\n" +
                          "your city. The mountain is south of your city\n" +
                          "It adds a boundry of protection to the city.\n";
        //use setters in the Location class to set the description and symbol
        loc = new Location();
        loc.setDescription(mountain);
        loc.setSymbol("^^^");
        for(int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 2, loc); 
        }
        
        String farmland = "You are on the fertile banks of the River.\n" +
                          "In the spring, this low farmland floods and is covered with rich\n" +
                          "new soil. Wheat is planted as far as you can see.";
        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        for(int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 3, loc); 
        }
        
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
        
        game.setMap(theMap);
    }
        
    public void displayMap(){
        Map map = game.getMap();
        for(int i = 0; i < MAX_ROW; i++){
            for(int j = 0; j < MAX_COL; j++){
                Location location = map.getLocation(i,j);
                String symbol = location.getSymbol();
                System.out.println(symbol + " ");
            }  
        }         
    }
    
    // create the list of tools
    public static ArrayList<ListItem> createToolList()
    {
        Game _game = CityOfAaron.getGame();
        ArrayList<ListItem> tools = new ArrayList<>();
        tools.add(new ListItem("hammer", 7));
        tools.add(new ListItem("shovel", 6));
        tools.add(new ListItem("scythe", 8));
        tools.add(new ListItem("plow", 4));

        // Save the tools in the game
        _game.setTools(tools);
        return tools;
    }
    
    public void displayTools() {
        System.out.println("List of Tools: ");
        ArrayList<ListItem> tools = GameControl.createToolList();
        tools.forEach((item) -> {
            System.out.println(item.getName()+ " " + item.getNumber());
        });
    }
    //create the list of provisions
        public static void createProvisionsList() {
            ArrayList<ListItem> provisions = new ArrayList<>();
            
            provisions.add(new ListItem("provision1", 15)); 
            provisions.add(new ListItem("provision2", 25));
            provisions.add(new ListItem("provision3", 30));
            provisions.add(new ListItem("provision4", 27));
            provisions.add(new ListItem("provision5", 32));
            
            game.setProvisions(provisions);
        }
        // method to display provisions list
   
        public static void showProvisionsList() {
            System.out.println("Provisions"); 
            ArrayList<ListItem> provisions = game.getProvisions();
            for(ListItem item : provisions) {
                System.out.println(item.getName() + ": " + item.getNumber()); 
            }
        }
        
        
        // display Provisions List
        public void  displayProvisions() {
            ArrayList<ListItem> provisionsList = game.getProvisions();
            System.out.println("Provisions"); 
            
            provisionsList.forEach((item) -> {
                System.out.println(item.getName() + ": " + item.getNumber());
        });    
            
         
        }
         
}
