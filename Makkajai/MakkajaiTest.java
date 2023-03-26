import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class MakkajaiTest{

	@Test
	public void blockPattern() {
		int [][] input = {{1,1},{1,2},{2,1},{2,2}};
		int [][] output = {{1,1},{1,2},{2,1},{2,2}};
		GameOfLife gameOfLife = new GameOfLife(10,input);
		gameOfLife.tick();
        int [][] liveCoordinates = gameOfLife.printLiveCellCoordinates();

		assertEquals(output.length,liveCoordinates.length);
		for (int i =0 ; i<output.length; i++){
			assertEquals(output[i][0],liveCoordinates[i][0]);
			assertEquals(output[i][1],liveCoordinates[i][1]);
		}
	}

	@Test
	public void boatpattern() {
		int [][] input = {{0,1},{1,0},{2,1},{0,2},{1,2}};
		int [][] output = {{0,1},{0,2},{1,0},{1,2},{2,1}};
		GameOfLife gameOfLife = new GameOfLife(10,input);
		gameOfLife.tick();
        int [][] liveCoordinates = gameOfLife.printLiveCellCoordinates();

		assertEquals(output.length,liveCoordinates.length);
		for (int i =0 ; i<output.length; i++){
			assertEquals(output[i][0],liveCoordinates[i][0]);
			assertEquals(output[i][1],liveCoordinates[i][1]);
		}
	}

	@Test
	public void blinkerPattern() {
		int [][] input = {{1,0},{1,1},{1,2}};
		int [][] output = {{0,1},{1,1},{2,1}};
		GameOfLife gameOfLife = new GameOfLife(10,input);
		gameOfLife.tick();
        int [][] liveCoordinates = gameOfLife.printLiveCellCoordinates();

		assertEquals(output.length,liveCoordinates.length);
		for (int i =0 ; i<output.length; i++){
			assertEquals(output[i][0],liveCoordinates[i][0]);
			assertEquals(output[i][1],liveCoordinates[i][1]);
		}
	}

	@Test
	public void toadPattern() {
		int [][] input = {{1,1},{1,2},{1,3},{2,2},{2,3},{2,4}};
		int [][] output = {{0,2},{1,1},{1,4},{2,1},{2,4},{3,3}};
		GameOfLife gameOfLife = new GameOfLife(10,input);
		gameOfLife.tick();
        int [][] liveCoordinates = gameOfLife.printLiveCellCoordinates();

		assertEquals(output.length,liveCoordinates.length);
		for (int i =0 ; i<output.length; i++){
			assertEquals(output[i][0],liveCoordinates[i][0]);
			assertEquals(output[i][1],liveCoordinates[i][1]);
		}
	}
}