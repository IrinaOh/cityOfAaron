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
    
    
    
}
