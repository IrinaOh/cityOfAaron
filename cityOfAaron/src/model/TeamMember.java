/*
* The TeamMember() class file for the cityOfAaron project
* CIT-260
* Fall 2018
* Team members: Irina O'Hara, Rob Nebeker, Justin Wakefield
*/
package model;

/**
 *
 * @author irina
 */
public enum TeamMember {
    
    Father("Lehi", "He is the prophet and leader of the family."),
    Mother("Sariah", "She is Lehi's wife and mother of the family."),
    Nephi("Nephi", "Faithful son and later the prophet leader of the Nephites"),
    Jacob("Jacob", "Nephi's faithful brother, prophet and successor to Nephi"),
    Sam("Sam", "The youngest boy and faithful brother of Nephi."),
    Laman("Laman", "The oldest rebellious brother and leader of the Lamanites."),
    Lemuel("Lemuel", "The 2nd oldest rebellious brother who went with Laman"),
    Zoram("Zoram", "Laban servant that became a faithful follower of Nephi");
    
    private String name;
    private String title;

    TeamMember(String name, String title){
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "TeamMember{" + "name=" + name + ", title=" + title + '}';
    }
    
    
}
