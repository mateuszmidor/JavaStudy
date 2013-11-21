import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadAllLinesExample {
	public ReadAllLinesExample() {
		System.out.println("readAllLines example.");

		Path xanadu = Paths.get("xanadu.txt");
		List<String> lines;
		try {
			lines = Files.readAllLines(xanadu, Charset.forName("UTF-8"));
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
	}
}
