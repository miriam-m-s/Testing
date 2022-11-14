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
		Cliente client = mock(Cliente.class);
		
		TemplateEngine tempEng = mock(TemplateEngine.class);
		MailServer gmail = mock(MailServer.class);
		Template temp = mock(Template.class);
		
		when(client.getEmail()).thenReturn("decathlon@gmail.com");
		when(tempEng.preparaMensaje(temp, client)).thenReturn("Recibido message");
		
		Mensaje msg = new Mensaje(gmail,tempEng);
		msg.sendMensaje(client,temp);
		
		verify(gmail).send("decathlon@gmail.com", "Recibido message");
	}
}
