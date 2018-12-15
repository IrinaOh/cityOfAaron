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
    private static final int HARVEST_8TO12_BASE = 2;
    private static final int HARVEST_8TO12_RANGE = 3;
    private static final int HARVEST_0TO7_BASE = 1;
    private static final int HARVEST_0TO7_RANGE = 3;
    private static final int HARVEST_ABOVE12_BASE = 2;
    private static final int HARVEST_ABOVE12_RANGE = 4;
    private static final int RATS_BASE = 1;
    private static final int RATS_RANGE = 100;
    private static final int EBRS_8TO12_BASE = 3;
    private static final int EBRS_8TO12_RANGE = 4;
    private static final int EBRS_0TO7_BASE = 6;
    private static final int EBRS_0TO7_RANGE = 4;
    private static final int EBRS_ABOVE_BASE = 3;
    private static final int EBRS_ABOVE_RANGE = 2;
    private static final int GROWTH_BASE = 1;
    private static final int GROWTH_RANGE = 5;
    
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
     * Method: sellLand
     * Purpose: to Sell Land
     * @param landPrice
     * @param acresToSell
     * @param cropData
     * @return cropData.getAcresOwned()
    * The sellLand method
    * Purpose: To sell land
    * parameters: the price of land, the number of acres to sell, and
    * a reference to a CropData object
    * Returns: the number of acres owned after the sale
    * Pre-conditions: acres to sell must be positive
    * and <=acresOwned
    */
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
        //acresOwned variable
        int acresOwned = cropData.getAcresOwned();

        //if acresToSell < 0, return -1
        if (acresToSell < 0)
            throw new CropException("A negative value was input."); 

        if (acresToSell > acresOwned)
            throw new CropException("You don't own enough land to sell that amount."); 

        // acresOwned - acresToSell
        acresOwned -= acresToSell;

        // save the new acresOwned amount            
        cropData.setAcresOwned(acresOwned);

        //wheatInStore = wheatInStore + (acresToSell * landPrice)
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore += (acresToSell * landPrice);

        // save result 
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
     * @param landPrice
     * @param acresToBuy
     * @param cropData
     * @return 
     */
    
    public static int buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException{

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

        cropData.setAcresOwned(acresOwned + acresToBuy);
        cropData.setWheatInStore(cropData.getWheatInStore() - totalPrice);
        return cropData.getAcresOwned();
    }  
    
    /**
    * Method: feedPeople
    * Purpose: feed the people
    * @param wheatInStore
    * @param cropData
    * @return CropData.wheatInStore
    * Pre-Conditions:
    *  -wheatForPeople must be a positive number
    *  -wheatInStore > wheatForPeople
    */ 
     public static int feedPeople(int wheatForPeople, CropData cropData) throws CropException {
         
        int wheatInStore = cropData.getWheatInStore();  
        int peopleFed = cropData.getPeopleFed();
        
        if (wheatForPeople < 0) {
            throw new CropException("Can't accept a negative value.");
        }
        
        // if wheatInStore < wheatForPeople return -1
        if(wheatForPeople > wheatInStore){
            throw new CropException("Not enough wheat.");
        }
        
        //wheatInStore = wheatInStore – wheatForPeople
        wheatInStore -= wheatForPeople;
        cropData.setWheatInStore(wheatInStore);
        
        // wheatForPeople 
        peopleFed += wheatForPeople;
        cropData.setPeopleFed(wheatForPeople);

        return wheatInStore;
     }
     
    /**
     * The plantCrop method
     * Purpose: To crop wheat
     * Parameters: the number of wheat to plant, the number of land to plant on
     * Returns: the number of wheat after planting
     * Pre-conditions: number of wheat must be positive, there must be enough land to plant on.
     */

    public static int plantCrops(int acresToPlant, CropData cropData) throws CropException
    {
        int acresOwned = cropData.getAcresOwned();
        int wheatInStore = cropData.getWheatInStore();
        //if acresToPlant < 0, return -1
        if(acresToPlant < 0){
            throw new CropException("Number of acres to plant should be larger than 0.");
        }
        
        //if acresOwned < acresToPlant, return -1
        if(acresOwned < acresToPlant){
            throw new CropException("You should have enough acres to plant on.");
        }
        
        //if wheatInStore < ( acresToPlant / 2), return -1        
        if(wheatInStore < acresToPlant/2){
            throw new CropException("You should have enough wheat to plant. You can plant 2 acres with one bushel of wheat");
        }
        
        if(acresToPlant == 0){
            throw new CropException("A number of acres cannot equal 0.");
        }
        
        //wheatInStore = wheatInStore - wheatToPlant
        int wheatToPlant = acresToPlant/2;
        wheatInStore -= wheatToPlant;
        cropData.setWheatInStore(wheatInStore);
        cropData.setAcresPlanted(acresToPlant + cropData.getAcresPlanted());
        
        //return wheatInStore
        return wheatInStore;
    }     
    
    public static int setOffering(int offering, CropData cropData) throws CropException{
        
        if (offering < 0 || offering > 100){
           throw new CropException("Please enter a number between 0-100");
        }
        
        cropData.setOffering(offering);
        return offering;                                
    }
    
    public static int harvestCrops(CropData cropData){
        
        int offering = cropData.getOffering();
        int acres = cropData.getAcresPlanted();
        int wheatInStore = cropData.getWheatInStore();
        
        if (offering < 8) {
            int yield = random.nextInt(HARVEST_0TO7_RANGE) + HARVEST_0TO7_BASE;
            cropData.setCropYield(yield);
            int harvest = yield * acres;
            cropData.setHarvest(harvest);
        }
        if (8 <= offering && offering <= 12) {
            int yield = random.nextInt(HARVEST_8TO12_BASE) + HARVEST_8TO12_BASE;
            cropData.setCropYield(yield);
            int harvest = yield * acres;
            cropData.setHarvest(harvest);
        }
        if (offering > 12) {
            int yield = random.nextInt(HARVEST_ABOVE12_BASE) + HARVEST_ABOVE12_BASE;
            cropData.setCropYield(yield);
            int harvest = yield * acres;
            cropData.setHarvest(harvest);
        }
       
        int harvest = cropData.getHarvest();
        System.out.println("You harvested " + harvest + " bushels of wheat.");
        return wheatInStore;   
    }
    
    public static int payOffering(CropData cropData){
        
        int offering = cropData.getOffering(); 
        int harvest = cropData.getHarvest(); //get the amount of wheat harvested.
        int payOffering = offering * harvest / 100; //calculate how much wheat will need to be paid as an offering. Change to a percentage
        
        cropData.setOfferingBushels(payOffering); //set the amount of tithing (in bushels of wheat) that was paid.
        harvest -= payOffering; //this will be the new amount of wheat harvested after tithing is paid on it.
        cropData.setHarvestAfterOffering(harvest);//set the harvest amount after paying tithing on it.
        int wheatInStore = cropData.getWheatInStore() + harvest;//get the current wheat in store and add the new harvested amount
        cropData.setWheatInStore(wheatInStore);//set the new amount of wheat in store
        
        System.out.println("You paid " + payOffering + " bushels of wheat in offering.");
        return wheatInStore;
    }
    
    public static int calcEatenByRats(CropData cropData){
        
        int randomRatNumber = random.nextInt(RATS_RANGE) + RATS_BASE; //calculate the random rat number between 1 - 100
        int tithingPaid = cropData.getOffering();  //get the amount of tithing paid.
        int wheatInStore = cropData.getWheatInStore(); //get the amount of wheat in store

        if (tithingPaid < 8)  //if random generated number is less than 30 and tithingPaid is less than 8
            {
                int multiplier = random.nextInt(EBRS_0TO7_RANGE) + EBRS_0TO7_BASE;
                int eatenByRats = wheatInStore * multiplier / 100;
                cropData.setEatenByRats(eatenByRats);
                wheatInStore = wheatInStore - eatenByRats;
                cropData.setWheatInStore(wheatInStore);
            }

        else if (tithingPaid >= 8 && tithingPaid <=12) //if random generated number is less than 30 and tithingPaid is less >= 8 and <= 12
            {
                int multiplier = random.nextInt(EBRS_8TO12_RANGE) + EBRS_8TO12_BASE;
                int eatenByRats = wheatInStore * multiplier / 100;
                cropData.setEatenByRats(eatenByRats);
                wheatInStore = wheatInStore - eatenByRats;
                cropData.setWheatInStore(wheatInStore);
            }

        else 
        {
            int multiplier = random.nextInt(EBRS_ABOVE_RANGE) + EBRS_ABOVE_BASE; //all other conditions
            int eatenByRats = wheatInStore * multiplier / 100;
            cropData.setEatenByRats(eatenByRats);
            wheatInStore = wheatInStore - eatenByRats;
            cropData.setWheatInStore(wheatInStore);
        }
        int eatenByRats = cropData.getEatenByRats();
        System.out.println("There were " + eatenByRats + " bushels of wheat eaten by rats.");
        return wheatInStore;
    }
    
    public static int growPopulation(CropData cropData){
        int randomGrowthNumber = random.nextInt(GROWTH_RANGE) + GROWTH_BASE;//call method to generate number between 1 and 5
        int currentPopulation = cropData.getPopulation();//get current population
        int populationGrowth = currentPopulation * randomGrowthNumber / 100;//get the population growth, divide by 100 to change to a percentage number
        cropData.setNewPeople(populationGrowth);//set the number of new people that moved to the city
        int newPopulation = currentPopulation + populationGrowth;
        cropData.setPopulation(newPopulation);//set the new population
        
        System.out.println("The population has grown and is now " + currentPopulation + " .");
        return currentPopulation;
    }
    
    public static int calcStarved(CropData cropData){
        
        int wheatSetAside = cropData.getWheatForPeople();  //Gets the amount of wheat set aside to feed the people for the year.
        int numThatCanBeFed = wheatSetAside/20; //Divides the wheat set aside by 20 to get how many people can be fed for the year (it takes 20 bushels of wheat per person per year).
        int currentPopulation = cropData.getPopulation(); //Gets current population.
        int numThatStarve = currentPopulation - numThatCanBeFed;//Get the number of people that starved by subtracting the number of people that "can" be fed from the current population

        if(numThatCanBeFed >= currentPopulation) //This is good no one starved
        {
            cropData.setNumStarved(0);
            cropData.setPeopleFed(currentPopulation);
        }
        else
        {
            cropData.setNumStarved(numThatStarve);//Sets the number of people that starved for the year
            cropData.setPeopleFed(numThatCanBeFed);//sets the number of people fed
            currentPopulation = currentPopulation - numThatStarve;//Updates the population by subtracting the number that starved from the population
            cropData.setPopulation(currentPopulation);//sets the current population
        }
        System.out.println(numThatStarve + " of population has starved. The total population is now " + currentPopulation + " .");
        System.out.println("\n");
        return currentPopulation;
    }
}


        



    
        
    
    
    
            
