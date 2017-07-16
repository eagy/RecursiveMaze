/**
 * Class uses a recursive division algorithm to build a maze. 
 * 
 * @author Daniel Eagy
 * @version 0.80 7/16/2017
 */
import java.io.IOException;
import java.util.Random;

public class ser222_unit7_hw02_base
{
    //standard console size in characters.
    private static final int LEVEL_HEIGHT = 25;
    private static final int LEVEL_WIDTH = 80;       
    
    private static final char ICON_WALL = '#';           
    private static final char ICON_BLANK = ' ';

    /**
     * Returns a 2D array containing a statically created maze with dimentions 80x24.
     * 
     * @return     2D array containing a maze 
     */
    private static char[][] makeMazeStatic()
    {
        //the following maze was generated with the recursive division method and then modified by hand.
        
        char level[][] =     
        {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', '#', ' ', ' ', '#', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', '#', '#', ' ', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', '#', '#', ' ', '#', ' ', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'}, 
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'}, 
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},         
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};
    
        return level;
    }
    
    /**
     * Creates a random maze in a 2D array.
     * 
     * @see <a href="http://en.wikipedia.org/wiki/Maze_generation_algorithm#Recursive_division_method">Recursive_division_method</a>
     * @return 2D array containing a maze
     */
    private static char[][] makeMaze()
    {
        char level[][] = createBlankLevel();
        
        makeMazeRecursive(level, 1, 1, LEVEL_WIDTH-2, LEVEL_HEIGHT-2); //TODO: may need to change but probably not.
        
        return level;
    }

    /**
     * Creates an empty level of standard level height and width. Level will be
     * blank but bordered with wall characters.
     * 
     * @return  2D array containing a maze
     */
    private static char[][] createBlankLevel()
    {   
        char level[][] = new char[LEVEL_HEIGHT][LEVEL_WIDTH];
        
        //reset level to be entirely blank
        for (int y = 0; y < LEVEL_HEIGHT; y++) 
            for (int x = 0; x < LEVEL_WIDTH; x++)
                level[y][x] = ' ';
    
        //top barrier   
        for (int x = 0; x < LEVEL_WIDTH; x++)
            level[0][x] = ICON_WALL;
    
        //bottom barrier
        for (int x = 0; x < LEVEL_WIDTH; x++)
            level[LEVEL_HEIGHT-1][x] = ICON_WALL;
    
        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            level[y][0] = ICON_WALL;
    
        //left barrier
        for (int y = 0; y < LEVEL_HEIGHT; y++)
            level[y][LEVEL_WIDTH-1] = ICON_WALL;
            
        return level;
    }

    //TODO: complete method.
    private static void makeMazeRecursive(char[][]level, int startX, int startY, int endX, int endY)
    {	
    	
    	Random rnd = new Random();

		int width = endX-startX;
		int height = endY-startY;
		/*
		if (width > height) {
			if (endX-startX-1 > 0 && endY-startY-1 > 0) {
				int rndX = rnd.nextInt(endX-startX-1)+startX+1;
				int rndY = rnd.nextInt(endY-startY-1)+startY+1;
			
				for (int y = startY; y <= endY; y++) {
	    			level[y][rndX] = ICON_WALL;
	    		}
	
				level[rnd.nextInt(rndY-startY)+startY][rndX] = ICON_BLANK;
				
				makeMazeRecursive(level, startX, startY, rndX-1, endY);
				makeMazeRecursive(level, rndX+1, startY, endX, endY);
			}
		}
		else {
			if (endX-startX-1 > 0 && endY-startY-1 > 0) {
				int rndX = rnd.nextInt(endX-startX-1)+startX+1;
				int rndY = rnd.nextInt(endY-startY-1)+startY+1;
				for (int x = startX; x <= endX; x++) {
	    			level[rndY][x] = ICON_WALL;
	    		}
				level[rndY][rnd.nextInt(rndX-startX)+startX] = ICON_BLANK;
				
				makeMazeRecursive(level, startX, startY, endX, rndY-1);
				makeMazeRecursive(level, startX, rndX+1, rndX-1, endY);
			}
		}
		*/
		
		if (width >= 2 && height >= 2) {
			
			int rndX = rnd.nextInt(endX-startX-1)+startX+1;
			int rndY = rnd.nextInt(endY-startY-1)+startY+1;
			
			for (int y = startY; y <= endY; y++) {
    			level[y][rndX] = ICON_WALL;
    		}

			
			
			level[rnd.nextInt(rndY-startY)+startY][rndX] = ICON_BLANK;
			if(rndY < endY)
				level[rnd.nextInt(endY-rndY)+rndY][rndX] = ICON_BLANK;
			else
				level[endY][rndX] = ICON_BLANK;

			for (int x = startX; x <= endX; x++) {
    			level[rndY][x] = ICON_WALL;
    		}
			level[rndY][rnd.nextInt(rndX-startX)+startX] = ICON_BLANK;
			if(rndX < endX)
				level[rndY][rnd.nextInt(endX-rndX)+rndX] = ICON_BLANK;
			else
				level[rndY][endX] = ICON_BLANK;
			makeMazeRecursive(level, startX, startY, rndX-1, rndY-1);
			makeMazeRecursive(level, rndX+1, startY, endX, rndY-1);
			makeMazeRecursive(level, startX, rndY+1, rndX-1, endY);
			makeMazeRecursive(level, rndX+1, rndY+1, endX, endY);
		}
		
		
		//This is my base case that I used to test my logic to see if i understood the basics of recursive division
		/*
		        	
		int midY = (startY+endY)/2;
    	int midX = (startX+endX)/2;
    	if (width >= 3 && height >= 3) {

			for (int y = startY; y <= endY; y++) {
    			level[y][midX] = ICON_WALL;
    		}
			level[rnd.nextInt(midY-startY)+startY][midX] = ICON_BLANK;
			level[rnd.nextInt(endY-midY)+midY][midX] = ICON_BLANK;
    		drawLevel(level);


			for (int x = startX; x <= endX; x++) {
    			level[midY][x] = ICON_WALL;
    		}
			level[midY][rnd.nextInt(midX-startX)+startX] = ICON_BLANK;
			level[midY][rnd.nextInt(endX-midX)+midX] = ICON_BLANK;
			drawLevel(level);

    		makeMazeRecursive(level, startX, startY, midX-1, midY-1);
    		makeMazeRecursive(level, midX+1, startY, endX, midY-1);
    		makeMazeRecursive(level, startX, midY+1, midX-1, endY);
    		makeMazeRecursive(level, midX+1, midY+1, endX, endY);
    		
    	}
 		*/
    }
     
    
    /**
     * Displays a level in the console.
     * 
     * @param level  2D array containing a maze
     */
    private static void drawLevel(char[][] level)
    {
        int y, x;
    
        for (y = 0; y < LEVEL_HEIGHT; y++) 
        {
            for (x = 0; x < LEVEL_WIDTH; x++)
                System.out.print(level[y][x]);
            System.out.println();
        }
    }

    /**
     * Entry point.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {       
        //show static maze (uncomment for sample output)
        //drawLevel(makeMazeStatic());
        //show recursive maze
        drawLevel(makeMaze());
    }
}
