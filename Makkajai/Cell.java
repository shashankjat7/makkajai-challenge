enum CellState {
    Live,
    Dead,
}

public class Cell{
    private int xCoordinate;
    private int yCoordinate;
    private CellState state;

    public Cell(int x, int y, CellState state){
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.state = state;
    }

    public Cell getUpdatedCell(int liveNeighborCount){
        if(state == CellState.Live && (liveNeighborCount < 2 || liveNeighborCount > 3)){
            return new Cell(xCoordinate,yCoordinate,CellState.Dead);
        }
        else if(state == CellState.Dead && liveNeighborCount == 3){
            return new Cell(xCoordinate,yCoordinate,CellState.Live);
        }
        return new Cell(xCoordinate,yCoordinate,state);
    }

    public boolean isLive(){
        return state == CellState.Live ? true : false;
    }
    public void setState(CellState newState){
        state = newState;
    }
    public CellState getCellState(){
        return state;
    }

}