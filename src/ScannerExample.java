import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
	public ScannerExample() {

		System.out.println("ScannerExample. Will print subsequent words from file:");

		try (Scanner s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")))) {

			s.useDelimiter("\r\n| "); // rozdzielaj po newlinach i spacjach
			
			while (s.hasNext()) {
				System.out.printf("%s-", s.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n... done.\n");

	}
}
