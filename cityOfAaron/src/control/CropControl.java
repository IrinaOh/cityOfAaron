/**
 * The CropControl class - part of the control layer
 * class contains all of the calculation methods for managing the crops
 * Author: <Justin Wakefield>
 * Date last modified: October 25, 2018
 */
package control;

/**
 *
 * @author Justin Wakefield
 */
import model.CropData;
import java.util.Random;
import exceptions.*;

public class CropControl {
    //random number generator
    private static Random random = new Random();
    
    //constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    
    /**
     * calcLandCost()method
     * Purpose: Calculate a random land cost between 17 and 26 bushels/acre
     * Parameters: none
     * Returns: the land cost
     */
    
    public static int calcLandCost()
    {
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
        return landPrice;
    }
    
    /**
    * The sellLand method
    * Purpose: To sell land
    * parameters: the price of land, the number of acres to sell, and
    * a reference to a CropData object
    * Returns: the number of acres owned after the sale
    * Pre-conditions: acres to sell must be positive
    * and <=acresOwned
    */
    public static int sellLand(int landPrice, int acresToSell, CropData cropData)
    {
        //if acresToSell < 0, return -1
        if (acresToSell < 0)
            return -1;
        
        //if acresToSell > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned)
            return -1;
        //acresOwned = acresOwned - acresToSell
        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);
        
        //wheatInStore = wheatInStore + (acresToSell * landPrice)
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += (acresToSell * landPrice);
        cropData.setWheatInStore(wheatInStore);
        
        //return acresOwned
        return acresOwned;
    }

    /**
     *
     * @param percent
     * @param cropData
     * @return
     */
    public static int setOffering(int percent, CropData cropData) {
        int offering = 0;
        if (percent > 0)     
            offering = (percent * cropData.getWheatInStore()) / 100;
        if (percent == 0) 
            return 0;
        if(percent < 0)
            return -1;
        
        cropData.setOffering(offering);
        return offering;                        
        
    }
       
    

    public static int calcLandPrice() {return 0;
}
        
    

    
    /**
     * The buyLand method
     * Purpose: To buy land
     * Parameters: The price of land, number of acres to buy, wheat in store
     * and people to tend the land.
     * Returns: The amount of land and wheat after purchase
     * Pre-conditions: The number of acres to buy can't be positive, there must
     * be enough people to tend the land, and you must have enough wheat to buy
     * the land.
     * @param landPrice
     * @param acresToBuy
     * @param cropData
     * @return 
     */
    
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData){
        /*
        Clearly define the problem the method is to solve 
        A bushel of wheat is the currency in our game.  The price of land is a 
        random value generated by the game.  landPrice is p bushels per acre. 
        To buy land a player needs to have enough people to tend for. One person
        can take care of 10 acres. Pe is for people to tend the land.  If the 
        player elects to buy n acres of land, the program must do the following
        calculations, where w is the total amount of bushels of wheat we own, 
        and a is the total number of acres we own: 

        w = w - (p * n)
        a = a + n
        pe = 10 * a
        */
       try {
           int totalPrice = acresToBuy * landPrice;
       
        
       // if acresToBuy < 0, return -1
       if (acresToBuy < 0) {
           throw new CropException("Cannot insert a negative value");
       }
       // if wheatInStore < ( landPrice * acresToBuy), return -1
       int acresOwned = cropData.getAcresOwned();
       if (acresToBuy * landPrice > acresOwned){
           throw new CropException("Not enough wheat to buy land.");
       }
       //If acresToBuy > 10*people, return -1
       int people = cropData.getPopulation();
       if (acresToBuy > (10 * people)){
           throw new CropException("Not enough people to tend the land.");
       }
       if (acresToBuy == 0) {return cropData.getAcresOwned();}
       
       else {
           cropData.setAcresOwned(cropData.getAcresOwned() + acresToBuy);
           
           cropData.setWheatInStore(cropData.getWheatInStore() - totalPrice);
           
           return cropData.getAcresOwned();
       }
       }
       catch (CropException e) {
           System.out.println("No can do");
           System.out.println(e.getMessage());
       }
        return 0;
    
       
        /**
    * Method: feedPeople
    * Purpose: feed the people
    * @param wheatInStore
    * @param wheatForPeople
    * @param cropData
    * @return CropData.wheatInStore
    * Pre-Conditions:
    *  -wheatForPeople must be a positive number
    *  -wheatInStore > wheatForPeople
    */ 
        
    
        //int wheatForPeople = 0;      
        
        /*
        People are fed with wheat in the game. To feed the people, the player
        needs to have enought wheat.  If there is not enought wheat ws, then
        there will be an error.  The program must do the following calculations
        where wp equals wheat for people and ws equals wheat in store.
        */   }
     public static int feedPeople(int wheatInStore, CropData cropData){
    //if wheatForPeople < 0, return -1
    try {
    int wheatForPeople = cropData.getWheatForPeople();
    if (wheatForPeople < 0) {
        throw new CropException("Can't accept a negative value.");
    }
    // if wheatInStore < wheatForPeople return -1
    if(wheatForPeople > wheatInStore){
        throw new CropException("Not enough wheat.");
    }
    //wheatInStore = wheatInStore – wheatForPeople
    if (wheatForPeople < wheatInStore){
    wheatInStore -= wheatForPeople;
    cropData.setWheatInStore(wheatInStore);
    // wheatForPeople 
    cropData.setWheatForPeople(wheatForPeople);
    //return wheatInStore
    return wheatInStore;
    }
    
    }
    catch (CropException e) {
        System.out.println("cannot do that.");
        System.out.println(e.getMessage());
    }
        return 0;
     }
    /**
     * The plantCrop method
     * Purpose: To crop wheat
     * Parameters: the number of wheat to plant, the number of land to plant on
     * Returns: the number of wheat after planting
     * Pre-conditions: number of wheat must be positive, there must be enough land to plant on.
     */

    public static int plantCrops(int acresToPlant, CropData cropData)
    {
        //if acresToPlant < 0, return -1
        if(acresToPlant < 0)
            return -1;
        
        //if acresOwned < acresToPlant, return -1
        int acresOwned = cropData.getAcresOwned();
        if(acresOwned < acresToPlant)
            return -1;
        
        //if wheatInStore < ( acresToPlant / 2), return -1
        int wheatInStore = cropData.getWheatInStore();
        if(wheatInStore < acresToPlant/2)
            return -1;  
        
        //wheatInStore = wheatInStore - wheatToPlant
        int wheatToPlant = acresToPlant/2;
        wheatInStore -= wheatToPlant;
        cropData.setWheatInStore(wheatInStore);
        
        //return wheatInStore
        return wheatInStore;
    }
    
    
}
    
        
    
    
    
            

