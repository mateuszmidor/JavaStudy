import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsExample {
	public PathsExample()  {
		System.out.println("Paths example.");
	
		// przyk³adowa œcie¿ka do pliku
		String location = "xanadu.txt";
		
		// tworzymy obiekt Path ze stringa
		Path path = Paths.get(location).toAbsolutePath();
		System.out.printf("Created path: %s %n", path.toString());
		System.out.printf("As URI: %s %n", path.toUri().toString());
		System.out.printf("Parent folder: %s %n", path.getParent());
		System.out.printf("Root: %s %n", path.getRoot());
		System.out.printf("Filename: %s %n", path.getFileName());
		System.out.printf("First folder in path: %s %n", path.getName(0));
		System.out.printf("Num segments in path: %d %n", path.getNameCount());
		
		System.out.println();
	}
}
