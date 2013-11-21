import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirContentListerExample {
	public DirContentListerExample() {
		System.out
				.println("Directory lister example. ");

		Path windowsPath = Paths.get(System.getenv("windir")); // C:\Windows

		listDirectories(windowsPath);
		listExeAndDlls(windowsPath);
	}

	private void listExeAndDlls(Path windowsPath) {
		System.out.println("Will print Exe and Dll files under Windows\\");

		// wykorzystujemy Globa zeby odfiltrowac tylko rozszerzenia exe i dll
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(
				windowsPath, "*.{exe,dll}")) {

			for (Path file : stream) {
				System.out.println(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
	}

	private void listDirectories(Path windowsPath) {
		System.out.println("Will print directories under Windows\\");

		// filtr do zawartosci katalogu
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {

				// interesuja nas tylko katalogi
				return Files.isDirectory(entry);
			}
		};

		// strumien z zawartoscia katalogu windows
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(
				windowsPath, filter)) {

			for (Path dir : stream) {
				System.out.println(dir);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
}
