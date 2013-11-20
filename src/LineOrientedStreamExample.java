import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LineOrientedStreamExample {
	public LineOrientedStreamExample() {
		
		// czytami/zapisujemy text ca³ymi linijkami
		// PrintWriter, w przeciwienstwie do BufferedWriter, daje metody print, println
		
		System.out.println("Line oriented stream example. Will copy text file.");

		try (BufferedReader in = new BufferedReader(new FileReader("xanadu.txt"));
				PrintWriter out = new PrintWriter(new FileWriter("copy_xanadu.txt"))) {

			System.out.println("Copying lines:");
			
			String s;
			
			// null to koniec streamu
			while ((s = in.readLine()) != null) {
				out.println(s);
				System.out.printf("(%s)\n", s);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("... done.\n");

	}
}
