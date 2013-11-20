import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
	public ByteStreamExample() {
		// Wszytstkie strumienie bajtowe 
		// dziedzicz¹ z InputeStream i OutputStream

		System.out.println("Byte stream example. Will copy text file.");

		// try with resource - auto closing streams
		try (FileInputStream in = new FileInputStream("xanadu.txt");
				FileOutputStream out = new FileOutputStream("copy_xanadu.txt")) {

			System.out.println("Copying bytes:");

			// w pêtli kopiujemy bajt po bajcie tekstu
			int c;

			// -1 oznacza koniec ByteStream'u
			while ((c = in.read()) != -1) {
				out.write(c);
				System.out.printf("%d-", c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n... done.\n");
	}
}
