package simstation;

import mvc.*;
/**
 *
 * Edits:
 * Martin 4/10:
 * For this edit I created a Heading file which generates the North, South, East, West.
 * This will then be put in the random method which will generate the random heading
 *
 * Martin 4/11:
 * I changed up the heading file to look similar to the one the professor had during the lecture
 */

public enum Heading {
    NORTH, SOUTH, EAST, WEST;

    // Method to generate a random heading
    public static Heading parse(String heading){
        if(heading.equalsIgnoreCase("north")) return NORTH;
        if(heading.equalsIgnoreCase("east")) return EAST;
        if(heading.equalsIgnoreCase("south")) return SOUTH;
        if(heading.equalsIgnoreCase("west")) return WEST;
        Utilities.error("Invalid heading "+ heading);
        return null;
    }
    public static Heading random() {
        int luck=Utilities.rng.nextInt(4);
        if(luck==0) return NORTH;
        if(luck==1) return SOUTH;
        if(luck==2) return EAST;
        return WEST;
    }
}
