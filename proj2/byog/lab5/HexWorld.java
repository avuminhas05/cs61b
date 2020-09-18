package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final long SEED = 771390;
    private static final Random RANDOM = new Random(SEED);

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(8);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.TREE;
            case 4: return Tileset.FLOOR;
            case 5: return Tileset.GRASS;
            case 6: return Tileset.SAND;
            case 7: return Tileset.WATER;
            default: return Tileset.NOTHING;
        }
    }

    /**
     * add a line to the world at given position of given size
     * @param x x coordinate of position
     * @param y y coordinat eof position
     * @param l lenght of line
     * @param world the world to draw on
     * @param t the tile, to draw world with
     */
    private static void addLine(int x, int y, int l, TETile[][] world, TETile t){
        for(int i = 0; i<l; i++){
            if( x<WIDTH && y<HEIGHT)
                world[x][y] = t;
            x++;
        }
    }

    /**
     * adds a hexagon to world
     * @param x bottom left x coordinate of hexagon
     * @param y bottom left y coordinate of hexagon
     * @param s side length of hexagon
     * @param world the world to draw on
     * @param t the tile with which world will be drawn
     */
    public static void addHexagon(int x, int y, int s, TETile[][] world, TETile t){
        x = x + (s-1); // x coordinate of position where first tile appear.
        int lineSize = s;

        // add lower half of hexagon
        for (int i = 0; i<s; i++){
            addLine(x, y, lineSize, world, t);
            x = x-1;
            y = y + 1;
            lineSize = lineSize + 2;
        }

        lineSize = lineSize - 2;
        x = x + 1;

        // add upper half of hexagon
        for(int i = 0; i<s; i++){
            addLine(x, y, lineSize, world, t);
            x = x + 1;
            y = y + 1;
            lineSize = lineSize - 2;
        }
    }

    /**
     * Add sequence of random hexagons vertically
     * @param x bottom left x coordinate of starting position of sequence
     * @param y bottom left y coordinate of starting position of sequence
     * @param s side length of hexagon
     * @param num number of hexagons in the sequence
     * @param world the world to which hexagons will be added
     */
    private static void addHexagonsVertically(int x, int y, int num, int s, TETile[][] world){
        for(int i = 0; i<num; i++){
            addHexagon(x, y, s, world, randomTile());
            y = y + (2*s);
        }
    }

    // Returns the height of hexagon of size s
    private static int hexagonHeight(int s){
        return 2*s;
    }

    // Returns the width of hexagon of size s
    private static int hexagonWidth(int s){
        return s + 2*(s-1);
    }

    // Returns the maximum pattern size(side length) based on sideLength of hexagon
    private static int getPatternSize(int s){
        int hexagonW = hexagonWidth(s);
        int hexagonH = hexagonHeight(s);
        int size1 = ((WIDTH/(2*s - 1)) + 1)/2;
        int size2 = ((HEIGHT/hexagonH)+1)/2;
        return Math.min(size1, size2);

    }

    // Geneates a pattern
    private static void generatePattern(TETile[][] world, int s, int patternSize) {
        int xChange = 2*s - 1;
        int yChange = s;
        int x = 0;
        int y = (patternSize-1)*yChange;
        int num = patternSize;
        for(int i = 0; i<patternSize; i++) {
            addHexagonsVertically(x, y, num, s, world);
            y = y - yChange;
            x = x + xChange;
            num++;
        }
        y = y + 2*yChange;
        num = num-2;
        for(int i = 1; i<patternSize; i++){
            addHexagonsVertically(x, y, num, s, world);
            y = y + yChange;
            x = x + xChange;
            num--;
        }
    }


    // Generates a random world of hexagons
    public static void generateWorld(TETile[][] world){
        int sideLength = RANDOM.nextInt(5) + 1;
        int patternSize = getPatternSize(sideLength);

        generatePattern(world, sideLength, patternSize);


    }

    public static void main(String[] args) {

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];

        for(int x = 0; x<WIDTH; x++){
            for(int y = 0; y<HEIGHT; y++){
                world[x][y] = Tileset.NOTHING;
            }
        }


        generateWorld(world);
        ter.renderFrame(world);
    }
}
