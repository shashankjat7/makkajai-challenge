// game size is 10 by default which is a sqare grid of size 10x10
// Please input the coordinates separated by a space
// Example input shape : 
// 1 2
// 2 2
// 3 2
// 1 1

import java.util.Scanner;

enum CellState {
    Live,
    Dead,
}

class GameOfLife {
    
    CellState [][] seed;
    int gameSize;

    void setInitialValues(CellState defaultState){
        // set initital values of in the game
        for(int i=0;i<gameSize;i++){
            for (int j=0; j<gameSize; j++){
                this.seed[i][j] = defaultState;
            }
        }
    }

    void setInputLiveCells(int inputCount){
        // set data of the initial live cells
        Scanner input = new Scanner(System.in);
        for(int i = 0; i< inputCount; i++){
            try{
                int x = input.nextInt();
                int y = input.nextInt();
                this.seed[x][y] = CellState.Live;
            }
            catch(Exception e){
                i--;
                System.out.println("the game is not that big dude, please enter the coordinates accordingly.");
                System.out.println(e);
                continue;
            }
        }
    }
    
    void initializeGame(int sizeOfGame,CellState defaultCellState){
        this.gameSize = sizeOfGame;
        this.seed = new CellState[sizeOfGame][sizeOfGame];
        setInitialValues(defaultCellState);
        Scanner input = new Scanner(System.in);
        System.out.print("How many input live cells are you going to enter kid? \n");
        int inputCount = input.nextInt();
        System.out.print("Please enter the coordiantes of those " + inputCount +" live cells (x y): \n");
        setInputLiveCells(inputCount);
    }
    
    int calculateLiveNeighbors(int x,int y){
        // calculate the neighbors of a cell
        int liveNeighborCount = 0;
        for (int i = x-1; i<= x+1; i++){
            for (int j = y-1; j<=y+1; j++){
                if (x ==i && y ==j){
                    continue;
                }
                try{
                    if(this.seed[i][j] == CellState.Live){
                        liveNeighborCount++;
                    }
                }
                catch(Exception e){}
            }
        }
        return liveNeighborCount;
    }
    
    void tick(){
        // perform a tick
        CellState [][] newSeed = new CellState[this.gameSize][this.gameSize];
        for (int x=0; x<this.gameSize; x++){
            for (int y=0; y<this.gameSize; y++){
                int liveNeighbors = calculateLiveNeighbors(x,y);
                if(this.seed[x][y] == CellState.Dead){
                    if(liveNeighbors == 3){
                        newSeed[x][y] = CellState.Live;
                        continue;
                    }
                    else{
                        newSeed[x][y] = CellState.Dead;
                    }
                }
                else{
                    if(liveNeighbors < 2 || liveNeighbors > 3){
                        newSeed[x][y] = CellState.Dead;
                        continue;
                    }
                    else{
                        newSeed[x][y] = CellState.Live;
                    }
                }
            }
        }
        this.seed = newSeed;
    }
    void showGameState(){
        // show the entire grid of cell states
        System.out.print("\n");
        for (int x=0; x<this.gameSize; x++){
            for (int y=0; y<this.gameSize; y++){
                System.out.print(this.seed[x][y]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    void printLiveCellCoordinates(){
        // print the coordinates of all the live cells
        System.out.print("\n");
        for (int x=0; x<this.gameSize; x++){
            for (int y=0; y<this.gameSize; y++){
                if(this.seed[x][y] == CellState.Live){
                    System.out.print(x + " " + y);
                    System.out.print("\n");
                    continue;
                }
            
            }
        }
    }
}

class Makkajai {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.initializeGame(10,CellState.Dead);
        gameOfLife.tick();
        System.out.print("\nLive Coordinates after one tick are : ");
        gameOfLife.printLiveCellCoordinates();
    }
}
