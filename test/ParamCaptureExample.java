import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


interface StringEmbracer {
	public String embrace(String text) ;
	
}

public class ParamCaptureExample {
	public StringEmbracer embracer;
	
	@Before
	public void setup() {

		embracer = createNiceMock(StringEmbracer.class);
		final Capture<String> argument = new Capture<String>();
		expect(embracer.embrace(EasyMock.capture(argument))).andAnswer( new IAnswer<String>() {

			@Override
			public String answer() throws Throwable {
				return "[" + argument.getValue() + "]";
			}
			
		});
		

		replay(embracer);
	}
	
	@Test
	public void testEmbrace() {
		final String TEXT = "A camel. Why not?";
		final String EMBRACED_TEXT = "[A camel. Why not?]"; 
		
		Assert.assertEquals(EMBRACED_TEXT, embracer.embrace(TEXT));
		verify(embracer);
	}

}
