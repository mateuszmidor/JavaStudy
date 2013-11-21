import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileOperationsExample {
	public FileOperationsExample() {
		System.out.println("FileOperations example.");
		
		// przyk³adowa œcie¿ka do pliku
		Path windowsPath = Paths.get(System.getenv("windir")); // C:\Windows
		Path notepadName = Paths.get("notepad.exe");
		Path notatnikName = Paths.get("notatnik.exe");
		Path tmpPath = Paths.get(System.getProperty("java.io.tmpdir"));
		
		try {
			// 1. copy
			Path notepadOriginalPath = windowsPath.resolve(notepadName);
			Path notepadTmpPath = tmpPath.resolve(notepadName);
			
			System.out.printf("Copying %s to %s...%n", notepadOriginalPath, tmpPath);
			Files.copy(notepadOriginalPath, notepadTmpPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.printf("Done.%n");
			
			// 2. move/rename
			Path notatnikTmpPath = tmpPath.resolve(notatnikName);
			System.out.printf("Renaming %s to %s...%n", notepadTmpPath, notatnikTmpPath);
			Files.move(notepadTmpPath, notatnikTmpPath);
			System.out.println("Done.");
			
			// 3. deleting
			System.out.printf("Deleting %s...%n", notatnikTmpPath);
			Files.delete(notatnikTmpPath);
			System.out.println("Done.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
