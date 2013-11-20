import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample {
	public CharacterStreamExample() {
		// wszystkie strumienie znakowe 
		// dziedzicz¹ z Reader i Writer
		// znaki kodowane s¹ wewnêtrznie do UNICODE
		
		System.out.println("Character stream example. Will copy text file, coding characters as 16 bit UNICODE.");
		
		
		try (FileReader in = new FileReader("xanadu.txt");
				FileWriter out = new FileWriter("copy_xanadu.txt")) {
			
			System.out.println("Copying characters:");
			
			int c;
			
			// -1 to koniec streamu
			while((c = in.read()) != -1) {
				out.write(c);
				System.out.printf("%c-", c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n... done.\n");
	}
}
