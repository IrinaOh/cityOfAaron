/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Justin Wakefield
 */
public class Map {
    private int rowCount; //stores the number of rows
    private int colCount; //stores the number of columns
    private Location[][]locations; //a reference to a 2-dimensional array
                                    //of Location objects
    
    /**
     * default Map constructor
     * Purpose: Set data members to default values
     * Parameters: none
     * Returns: none
     */
    public Map(){};
    /**
    *Parameterized Map constructor
    * Purpose: Sets row and column values
    * and creates an array of Location objects
    * Parameters: row count and column count
    * Returns: none
    * @param _rows
     *@param _cols
    */
    public Map(int _rows, int _cols)
    {
        rowCount = _rows;
        colCount = _cols;
        
        //create the array of location objects
        locations = new Location[_rows][_cols];
    }
    
    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }
    /**
     * The getLocation method
     * Purpose: returns the location object at the given row and column
     * Parameters: a row and column
     * Returns: a Location object
     * @param row
     * @param col
     * @return 
     */
    public Location getLocation(int row, int col)
    {
        return locations[row][col];        
    }
    /**
     * The setLocation method
     * Purpose: stores a location object at the row and column
     * Parameters: a row and column, and a reference to a location object
     * Returns: void
     * @param row
     * @param col
     * @param _location
     */
    public void setLocation (int row, int col, Location _location)
    {
        locations[row][col] = _location;
    }
}
