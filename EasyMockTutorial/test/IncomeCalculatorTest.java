import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

interface INumberProvider {
	public int provide();
}

public class IncomeCalculatorTest {

	private ICalcMethod calcMethod;
	private IncomeCalculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new IncomeCalculator();
		calcMethod = createNiceMock(ICalcMethod.class);
	}

	@Test
	public void testCalc1() {

		// Setting up the expected value of the method call calc
		expect(calcMethod.calc(Position.PROGRAMMER)).andReturn(50000.0);
		expect(calcMethod.calc(Position.BOSS)).andReturn(70000.0).times(2);
		// Setup is finished need to activate the mock
		replay(calcMethod);

		calc.setCalcMethod(calcMethod);
		calc.setPosition(Position.BOSS);
		assertEquals(70000.0, calc.calc(), 0);
		assertEquals(70000.0, calc.calc(), 0);
		calc.setPosition(Position.PROGRAMMER);
		assertEquals(50000.0, calc.calc(), 0);
		calc.setPosition(Position.SURFER);

		verify(calcMethod);
	}

	// no calc method - should throw
	@Test(expected = RuntimeException.class)
	public void testNoCalcMethod() {
		calc.setPosition(Position.SURFER);
		calc.calc();
	}

	// no position - should throw
	@Test(expected = RuntimeException.class)
	public void testNoPosition() {
		expect(calcMethod.calc(Position.BOSS)).andReturn(70000.0);
		replay(calcMethod);
		calc.setCalcMethod(calcMethod);
		calc.calc();
	}
}
