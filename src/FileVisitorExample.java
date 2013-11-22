import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class FilePrinter extends SimpleFileVisitor<Path> {

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {

		// skip .git directory
		if (isGitDirectory(dir)) {
			return SKIP_SUBTREE;
		}

		// print directory name
		printDirectory(dir);
		return super.preVisitDirectory(dir, attrs);
	}

	private boolean isGitDirectory(Path path) {
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher(
				"glob:.git");
		return matcher.matches(path.getFileName());
	}
	
	private void printDirectory(Path dir) {
		String padding = generatePadding(dir);
		System.out.printf("%s%s %n", padding, dir.getFileName());
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {

		printFile(file, attrs);
		return super.visitFile(file, attrs);
	}

	private void printFile(Path file, BasicFileAttributes attrs) {
		String padding = generatePadding(file);
		String mime = getMimeType(file);
		System.out.printf("%s%s%s - %,d Bytes %n", padding,
				file.getFileName(), mime, attrs.size());
	}

	private String getMimeType(Path file) {
		String mime = null;
		try {
			mime =  Files.probeContentType(file);
		} catch (IOException e) {
			mime = "unaccessible";
		}
		
		return (mime == null) ? "" : String.format("[%s]", mime);
	}

	private String generatePadding(Path file) {
		int n = (file.getNameCount() - 1) * 4; // jak g³êboko w hierarchii
												// jesteœmy
		return n == 0 ? "" : String.format("%" + n + "s", "");
	}
}

public class FileVisitorExample {
	public FileVisitorExample() {
		System.out
				.println("FileVisitor example. Will print current directory tree");

		Path startingPath = Paths.get(".");
		try {
			Files.walkFileTree(startingPath, new FilePrinter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
