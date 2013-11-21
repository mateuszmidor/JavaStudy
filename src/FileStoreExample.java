import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

public class FileStoreExample {
	public FileStoreExample() {

		System.out.println("FileStore example.");

		Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
		for (FileStore s : stores) {
			try {
				System.out.printf("%-25s %,dMB wolne z %,dMB %n", s.toString(),
						s.getUsableSpace() >> 20, s.getTotalSpace() >> 20);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
	}
}
