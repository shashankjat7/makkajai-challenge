
public class Makkajai {
    public static void main(String[] args) {
    	int [][] initialLiveCoordinates = new int [0][0];
        GameOfLife gameOfLife = new GameOfLife(10,initialLiveCoordinates);
        gameOfLife.tick();
        System.out.print("\nLive Coordinates after one tick are : ");
        gameOfLife.printLiveCellCoordinates();
    }
}