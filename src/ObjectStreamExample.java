import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class GameState implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String playerName;
	public Integer levelNumber;
	public Integer playerHealthPercentage;

	public GameState(String playerName, Integer levelNumber,
			Integer playerHealth) {
		super();
		this.playerName = playerName;
		this.levelNumber = levelNumber;
		this.playerHealthPercentage = playerHealth;
	}

}

public class ObjectStreamExample {
	public ObjectStreamExample() {
		System.out
				.println("ObjectStream example. Will write and then read GameState from file.");

		// plik wyjœciowy
		String FILENAME = "objectstream.bin";

		// zapisujemy stan gry do pliku
		System.out.println("Writing game state to file...");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(FILENAME)))) {

			GameState state = new GameState("Player Andrzej", 12, 75);
			out.writeObject(state);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done.\nReading...");

		// czytamy dane z pliku
		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(FILENAME)))) {

			GameState state = (GameState) in.readObject();

			System.out.printf("%s, level %d, health %d%% %n", state.playerName,
					state.levelNumber, state.playerHealthPercentage);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println();
	}
}
