public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Przyk³ad Try-with-resource statement");
		try {

			new TryWithResourceExample("Sia³a baba mak, nie wiedzia³a jak");

		} catch (Exception e) {

			System.out.printf("Ups... mieliœmy error (\"%s\"). Stack trace:%n",
					e.getMessage());
			for (StackTraceElement element : e.getStackTrace())
				printStackElement(element);
		}

	}

	private static void printStackElement(StackTraceElement e) {

		System.err.printf("		%s w %s, linia %d %n", e.getMethodName(),
				e.getFileName(), e.getLineNumber());

	}

}
