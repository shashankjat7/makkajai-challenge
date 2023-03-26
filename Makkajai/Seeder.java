import java.util.Scanner;

public class Seeder {
	private int gameSize;
	private int inputCount;

	public Seeder(int gameSize){
		this.gameSize = gameSize;
	}

	public Cell [][] setInitialGrid(CellState defaultState, int [][] initialLiveCoordinates){
        // set initital values of the game
        Cell [][] grid = new Cell[gameSize][gameSize];
        for(int x = 0;x <gameSize;x++){
            for (int y=0; y<gameSize; y++){
                grid[x][y] = new Cell(x,y,defaultState);
            }
        }
        if(initialLiveCoordinates.length == 0){
        	grid = setInputLiveCells(grid);
        }
        else{
        	grid = setProvidedCoordinates(grid, initialLiveCoordinates);
        }
        return grid;
    }

    private Cell [][] setProvidedCoordinates(Cell [][] grid, int [][] initialLiveCoordinates){
    	System.out.println(initialLiveCoordinates.length);
    	for(int i = 0;i<initialLiveCoordinates.length;i++){
    		grid[initialLiveCoordinates[i][0]][initialLiveCoordinates[i][1]].setState(CellState.Live);
    	}
    	return grid;
    }

    private void getInputCellCount(){
    	Scanner input = new Scanner(System.in);
        System.out.print("How many input live cells are you going to enter kid? \n");
        int inputCount = input.nextInt();
        this.inputCount = inputCount;
    }

    private Cell [][] setInputLiveCells(Cell [][] grid){
        // set data of the initial live cells
        getInputCellCount();
        System.out.print("Please enter the coordiantes of those " + inputCount +" live cells (x y): \n");
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
        return grid;
    }

}