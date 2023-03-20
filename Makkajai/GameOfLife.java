import java.util.Scanner;

public class GameOfLife {

    private Cell [][] grid;
    private int gameSize;
    private CellState defaultState = CellState.Dead;


    public GameOfLife(int gameSize){
        this.gameSize = gameSize;
        initializeGame();
    }

    public void initializeGame(){
        grid = new Cell[gameSize][gameSize];
        setInitialGrid();
        Scanner input = new Scanner(System.in);
        System.out.print("How many input live cells are you going to enter kid? \n");
        int inputCount = input.nextInt();
        System.out.print("Please enter the coordiantes of those " + inputCount +" live cells (x y): \n");
        setInputLiveCells(inputCount);
    }

    private void setInitialGrid(){
        // set initital values of the game
        for(int i=0;i<gameSize;i++){
            for (int j=0; j<gameSize; j++){
                grid[i][j] = new Cell(i,j,defaultState);
            }
        }
    }

    private void setInputLiveCells(int inputCount){
        // set data of the initial live cells
        Scanner input = new Scanner(System.in);
        for(int i = 0; i< inputCount; i++){
            try{
                int xCoordinate = input.nextInt();
                int yCoordinate = input.nextInt();
                grid[xCoordinate][yCoordinate].setState(CellState.Live);
            }
            catch(Exception e){
                i--;
                System.out.println("the game is not that big dude, please enter the coordinates accordingly.");
                System.out.println(e);
                continue;
            }
        }
    }

    
    private int calculateLiveNeighbors(int xCoordinate,int yCoordinate){
        // calculate the neighbors of a cell
        int liveNeighborCount = 0;
        for (int i = xCoordinate-1; i<= xCoordinate+1; i++){
            for (int j = yCoordinate-1; j<=yCoordinate+1; j++){
                if (xCoordinate ==i && yCoordinate ==j){
                    continue;
                }
                try{
                    if(grid[i][j].isLive()){
                        liveNeighborCount++;
                    }
                }
                catch(Exception e){}
            }
        }
        return liveNeighborCount;
    }
    
    public void tick(){
        // perform a tick
        Cell [][] newGrid = new Cell[gameSize][gameSize];
        for (int x=0; x<gameSize; x++){
            for (int y=0; y<gameSize; y++){
                int liveNeighbors = calculateLiveNeighbors(x,y);
                Cell newCell = grid[x][y].getUpdatedCell(liveNeighbors);
                newGrid[x][y] = newCell;
            }
        }
        this.grid = newGrid;
    }
    public void showGameState(){
        // show the entire grid of cell states
        System.out.print("\n");
        for (int x=0; x<gameSize; x++){
            for (int y=0; y<gameSize; y++){
                System.out.print(grid[x][y].getCellState());
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    public void printLiveCellCoordinates(){
        // print the coordinates of all the live cells
        System.out.print("\n");
        for (int x=0; x<gameSize; x++){
            for (int y=0; y<gameSize; y++){
                if(grid[x][y].isLive()){
                    System.out.print(x + " " + y);
                    System.out.print("\n");
                    continue;
                }
            
            }
        }
    }
}