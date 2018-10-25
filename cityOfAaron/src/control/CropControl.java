
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
     * The buyLand method
     * Purpose: To buy land
     * Parameters: The price of land, number of acres to buy, wheat in store
     * and people to tend the land.
     * Returns: The amount of land and wheat after purchase
     * Pre-conditions: The number of acres to buy can't be positive, there must
     * be enough people to tend the land, and you must have enough wheat to buy
     * the land.
     */
    
    public int buyLand(int landPrice, int acresToBuy, CropData cropData){
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
        
        
       // if acresToBuy < 0, return -1
       if (acresToBuy < 0)
           return -1;
       // if wheatInStore < ( landPrice * acresToBuy), return -1
       int acresOwned = cropData.getAcresOwned();
       if (acresToBuy * landPrice > acresOwned)
           return -1;
       //If acresToBuy > 10*people, return -1
       int people = 
       //acresOwned = acresOwned + acresToBuy
       acresOwned += acresToBuy;
       // wheatInStore = wheatInStore - (acresToBuy x landPrice)
       int wheat = cropData.getWheatInStore();
       wheat -= (acresToBuy * landPrice);
       cropData.setWheatInStore(wheat);
       // return acresOwned
       return acresOwned;
       // return wheatInStore
       return wheatInStore;

        
    }
    
        
    
    
    
            

