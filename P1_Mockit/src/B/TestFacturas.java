package B;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class TestFacturas {
		
	private static final Object[] getParameters() {
		return new Object[] { //Email //Message
				new Object[] {"miri@decathlon.com", true}, 
				new Object[] {"josedi@lidl.com", false},
				new Object[] {"manolo@ucm.com", true}
		};
	}
	
	@Test
	@Parameters(method = "getParameters")
	public void testMessageSend(String email, boolean preferEmail) throws Exception {
		Cliente client = mock(Cliente.class);
		when(client.getEmail()).thenReturn(email);
		when(client.prefiereEmails()).thenReturn(preferEmail);
		
		EmailService emailSer = mock(EmailService.class);
		PrinterService printerSer = mock(PrinterService.class);
		Factura factura_ = mock(Factura.class);
		
		EmisorFactura facturaEmitter = new EmisorFactura(printerSer, emailSer);
		
		facturaEmitter.emitirFactura(factura_, client);	
		
		if(preferEmail) {
			verify(emailSer).sendFactura(factura_, email);
			verify(printerSer, never()).printFactura(any());
		}
		else {
			verify(printerSer).printFactura(factura_);
			verify(emailSer, never()).sendFactura(any(), anyString());
		}
	}
}
