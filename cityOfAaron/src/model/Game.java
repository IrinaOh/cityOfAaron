/*
* The Game() class file for the cityOfAaron project
* CIT-260
* Fall 2018
* Team members: Irina O'Hara, Rob Nebeker, Justin Wakefield
*/
package model;
import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;


/**
 *
 * @author irina
 */
public class Game implements Serializable{
    private Player player;
    private Game game;
    private CropData cropData;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;

    public Game(Player player, Game game, CropData cropData, ArrayList<ListItem> animals, ArrayList<ListItem> tools, ArrayList<ListItem> provisions) {
        this.player = player;
        this.game = game;
        this.cropData = cropData;
        this.animals = animals;
        this.tools = tools;
        this.provisions = provisions;
    }

    public Game() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public ArrayList<ListItem> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<ListItem> animals) {
        this.animals = animals;
    }

    public ArrayList<ListItem> getTools() {
        return tools;
    }

    public void setTools(ArrayList<ListItem> tools) {
        this.tools = tools;
    }

    public ArrayList<ListItem> getProvisions() {
        return provisions;
    }

    public void setProvisions(ArrayList<ListItem> provisions) {
        this.provisions = provisions;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.player);
        hash = 19 * hash + Objects.hashCode(this.game);
        hash = 19 * hash + Objects.hashCode(this.cropData);
        hash = 19 * hash + Objects.hashCode(this.animals);
        hash = 19 * hash + Objects.hashCode(this.tools);
        hash = 19 * hash + Objects.hashCode(this.provisions);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        if (!Objects.equals(this.cropData, other.cropData)) {
            return false;
        }
        if (!Objects.equals(this.animals, other.animals)) {
            return false;
        }
        if (!Objects.equals(this.tools, other.tools)) {
            return false;
        }
        if (!Objects.equals(this.provisions, other.provisions)) {
            return false;
        }
        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    



    
}
