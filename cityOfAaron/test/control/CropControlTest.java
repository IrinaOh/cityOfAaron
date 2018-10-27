/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Justin Wakefield
 */
public class CropControlTest {
    
    public CropControlTest() {
    }

    /**
     * Test of calcLandCost method, of class CropControl.
     */
    @Test
    public void testCalcLandCost() {
        System.out.println("calcLandCost");
        int expResult = 0;
        int result = CropControl.calcLandCost();
        assertEquals(expResult, result);

    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
        System.out.println("sellLand");
        int landPrice = 0;
        int acresToSell = 0;
        CropData cropData = null;
        int expResult = 0;
        int result = CropControl.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of buyLand method, of class CropControl.
     */
    @Test
    public void testBuyLand() {
        System.out.println("buyLand -Test Case 1");
        CropData cropData = new CropData();
        cropData.setAcresOwned(2000);
        cropData.setWheatInStore(600);
        cropData.setPopulation(200);
        CropControl instance = new CropControl();
        
        int landPrice = 10;
        int acresToBuy = 0;      
        int expResult = 2000;
        int result;     
        result = instance.buyLand(landPrice, acresToBuy, cropData);
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople Test Case 1");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setWheatForPeople(10);
        cropData.setWheatInStore(300);
        
        int wheatInStore = 300;
        int wheatForPeople = 10;
        int expResult = 290;
        int result;
        result = CropControl.feedPeople(wheatInStore, cropData);
        System.out.println(result);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of plantCrops method, of class CropControl.
     */
    @Test
    public void testPlantCrops() {
        System.out.println("plantCrops test case");
        CropData cropData = new CropData();
        cropData.setAcresOwned(200);
        cropData.setWheatInStore(600);
        CropControl instance = new CropControl();
        
        int acresToPlant = 100;
        int acresOwned = 200;   
        int wheatInStore = 600;
        int expResult = 550;
        int result;     
        result = instance.plantCrops(acresToPlant, cropData);
        System.out.println(result);
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of setOffering method, of class CropControl.
     */
    @Test
    public void testSetOffering() {
        System.out.println("setOffering");
        int percent = 0;
        CropData cropData = null;
        int expResult = 0;
        int result = CropControl.setOffering(percent, cropData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    
}
