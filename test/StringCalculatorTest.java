import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private PrintStream consoleOutputPrinter;
	private ByteArrayOutputStream outputPrinterStorage = new ByteArrayOutputStream();
	private StringCalculator calculator;
	private PrintStream originalOuput;

	@Before
	public void setUp() throws Exception {
		consoleOutputPrinter = new PrintStream(outputPrinterStorage);
		calculator = new StringCalculator();
		originalOuput = System.out;
		System.setOut(consoleOutputPrinter);
	}

	@After
	public void tearDown() {
		System.setOut(originalOuput);
	}
	
	@Test
	public void testAdd() {
		Assert.assertEquals(10, calculator.addAndPrintOut("1 2 3 4"));
		Assert.assertEquals("10", outputPrinterStorage.toString());
	}

}
