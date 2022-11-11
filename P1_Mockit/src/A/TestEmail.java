package A;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.mockito.Mockito.*;

/*@RunWith(JUnitParamsRunner.class)*/
public class TestEmail {
	/*	
	private static final Object[] getEmail() {
		return new Object[] {//M1 D1 M2 D2  YEAR
				new Object[] {1 , 1, 1, 3, 2005}, 
				new Object[] {1 , 1, 1, 3, 2005}, 
		};
	}
	
	@Before
	public void setUp() throws Exception {
	
	}
	
	@Test
	@Parameters(method = "getEmail")
	public void testMail() {
	
	
	}*/
	
	@Test
	public void testMessageSend() throws Exception {
		Cliente miri = mock(Cliente.class);
		
		TemplateEngine tempEng = mock(TemplateEngine.class);
		MailServer gmail = mock(MailServer.class);
		Template temp=mock(Template.class);
		
		when(miri.getEmail()).thenReturn("Decathlon.gmail");
		when(tempEng.preparaMensaje(temp, miri)).thenReturn("Recibido message");
		
		Mensaje msg = new Mensaje(gmail,tempEng);
		msg.sendMensaje(miri,temp);
		
		verify(gmail).send("Decathlon.gmail", "Recibido message");
	}
}
