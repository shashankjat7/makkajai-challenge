
public class GameOfLife {

    private Cell [][] grid;
    private int gameSize;
    private CellState defaultState = CellState.Dead;
    private int [][] initialLiveCoordinates;


    public GameOfLife(int gameSize,int [][] initialLiveCoordinates){
        this.gameSize = gameSize;
        this.initialLiveCoordinates = initialLiveCoordinates;
        initializeGame();
    }

    public void initializeGame(){
        Seeder seeder = new Seeder(gameSize);
        grid = seeder.setInitialGrid(CellState.Dead,initialLiveCoordinates);
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
    
    public int [][] printLiveCellCoordinates(){
        int [][] liveCellCoordinates = GamePainter.printLiveCellCoordinates(grid,gameSize);
        return liveCellCoordinates;
    }
}