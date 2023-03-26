import java.util.Arrays;
public class GamePainter {

	// This class defines ui methods to print and show live state of the game.

    static public int [][] printLiveCellCoordinates(Cell [][] grid, int gameSize){
        // print the coordinates of all the live cells
        System.out.print("\n");
        int [][] liveCellCoordinates = new int [0][2];
        for (int x=0; x<gameSize; x++){
            for (int y=0; y<gameSize; y++){
                if(grid[x][y].isLive()){
                    System.out.print(x + " " + y);
                    System.out.print("\n");
                    liveCellCoordinates = Arrays.copyOf(liveCellCoordinates, liveCellCoordinates.length + 1);
                    int [] z = {x, y};
                    liveCellCoordinates[liveCellCoordinates.length - 1] = z;
                    continue;
                }
            
            }
        }
        return liveCellCoordinates;
    }
}