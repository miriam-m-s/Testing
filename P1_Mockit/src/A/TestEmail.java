package A;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class TestEmail {
		
	private static final Object[] getParameters() {
		return new Object[] { //Email //Message
				new Object[] {"miri@decathlon.com", "Recibido message"}, 
				new Object[] {"josedi@lidl.com", "Nueva oferta"},
				new Object[] {"manolo@ucm.com", "Usted ha suspendido 10"}
		};
	}
	
	@Test
	@Parameters(method = "getParameters")
	public void testMessageSend(String email, String message) throws Exception {
		Cliente client = mock(Cliente.class);
		TemplateEngine tempEng = mock(TemplateEngine.class);
		
		MailServer gmail = mock(MailServer.class);
		Template temp = mock(Template.class);
		
		when(client.getEmail()).thenReturn(email);
		when(tempEng.preparaMensaje(temp, client)).thenReturn(message);
		
		Mensaje msg = new Mensaje(gmail,tempEng);
		msg.sendMensaje(client,temp);
		
		verify(gmail).send(email, message);
	}
}
