
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Ogólnie: Stream - strumienie bajtowe, Reader/Writer - strumienie znakowe
		 * 
		 * InputStream, FileInputStream, BufferedInputStream - bajtowe
		 * OutputStream, FileOutputStream, BufferedOutputStream - bajtowe
		 * Reader, FileReader, BufferedReader - znakowe, konwertuj¹ do 16bit unicode
		 * Writer, FileWriter, BufferedWriter - znakowe, konwertuj¹ z 16bit unicode
		 * PrintWriter - jak BufferedWriter ale oferuje jeszcze metody print/println
		 */
		
		new ByteStreamExample(); // FileInputStream, FileOutputStream
		new CharacterStreamExample(); // FileReader, WileWriter
		new LineOrientedStreamExample(); // BufferedReader, PrintWriter
		new ScannerExample();  // Scanner
		new DataStreamExample(); // DataInputStream, DataOutputStream
		new ObjectStreamExample(); // ObjectInputStream, ObjectOutputStream
		
		
	}
}
