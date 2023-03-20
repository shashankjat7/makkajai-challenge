
public class Makkajai {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(10);
        gameOfLife.tick();
        System.out.print("\nLive Coordinates after one tick are : ");
        gameOfLife.printLiveCellCoordinates();
    }
}