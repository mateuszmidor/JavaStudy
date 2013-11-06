import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TryWithResourceExample {
	
	private static final String FILENAME = "PlikTymczasowy.txt";

	public TryWithResourceExample(String input) throws Exception {
		
		System.out.println("Zapisujemy do pliku tekst: " + input);
		writeToFile(FILENAME, input);

		String output = readFromFile(FILENAME);
		System.out.println("Odczytujemy z pliku: " + output);

		System.out.println();
	}

	// zapisujemy do pliku z u�yciem "try-with-resource" statementu
	private void writeToFile(String filename, String input) {

		// try with resource - automatycznie zamknie printera 
		// po wykonaniu sekcji try {}
		try (PrintWriter pw = new PrintWriter(new FileWriter(filename), true)) {

			pw.println(input);

		} catch (IOException e) {
			logError(e);
		}
		// zamkni�cie zasobu odbywa si� automatycznie dzi�ki try-with-resource statement
		// jest czysto i schludnie
	}

	// czytamy z pliku bez u�ycia "try-with-resource" statementu
	private String readFromFile(String filename) throws Exception {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("")); //powinno byc FILENAME ale chcemy miec exception
			return br.readLine();
			
		} catch (IOException e) {
			logError(e);
			
			// r�cznie zamykamy BufferedReader
		} finally {
			if (null != br) // m�g� w og�le nie zosta� utworzony
				try {
					br.close();  // przy zamykaniu mo�e wyst�pi� wyj�tek
				} catch (IOException e) {
					logError(e);
				}
		}
		throw new Exception("Cosik nie posz�o z tym czytaniem pliku...");
	}
	
	private void logError(IOException e) {
		System.out.println(e.getMessage());
	}

}
