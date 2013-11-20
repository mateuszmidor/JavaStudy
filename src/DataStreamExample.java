import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample {
	public DataStreamExample() {
		System.out
				.println("DataStream example. Will write and then read personal data from file.");

		// plik wyjœciowy
		String FILENAME = "datastream.bin";

		// dane pana andrzeja
		final String NAME = "Andrzej Andrzej";
		final Double HEIGHT = 179.50;
		final Integer ANNUAL_SALARY = 80000;

		// zapisujemy dane do pliku
		System.out.println("Writing MR. Andrzej data to file...");
		try (DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(FILENAME)))) {

			out.writeUTF(NAME);
			out.writeDouble(HEIGHT);
			out.writeInt(ANNUAL_SALARY);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Done.\nReading...");

		// czytamy dane z pliku
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream(FILENAME)))) {

			String name = in.readUTF();
			Double height = in.readDouble();
			Integer salry = in.readInt();
			
			System.out.printf("%s, %.2fcm, annually %,d€ %n", name, height, salry);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
	}
}
