
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
import CropData;
import java.util.Random;
import java.util.Scanner;

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
    public static int sellLand(int landPrice, int acresToSell, CropData)
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
    
    public static int buyLand(int priceOfLand, int acresToBuy, int wheatInStore,int people CropData)
    {
        
    }
    
    
            }

