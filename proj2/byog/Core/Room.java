package byog.Core;

import byog.TileEngine.TETile;

import java.util.List;

public class Room {

    // Creates a room of given width(w) and height(h)
    public Room(int w, int h){

    }
    // Opens the room at given position(to add a hallway)
    public void open(Position p){

    }
    // Returns list of all open positions in room
    public List<Position> getOpenPosition(){
        return null;
    }
    // Set the tiles of floor
    public void setFloorTile(TETile t){

    }
    // Set the tiles of wall
    public void setWallTile(TETile t){

    }


    public int getWidth(){
        return 0;
    }
    public int getHeight(){
        return 0;
    }
    public TETile getFloorTile(){
        return null;
    }
    public TETile getWallTile(){
        return null;
    }

}
