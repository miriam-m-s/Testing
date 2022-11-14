package C;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class TestWeb {
		
	private static final Object[] getParameters() {
		return new Object[] { //Email //Message
				new Object[] {true}, 
				new Object[] {false},
		};
	}
	
	@Test
	@Parameters(method = "getParameters")
	public void testMessageSend(boolean isOK) throws Exception {
		Logger client = mock(Logger.class);
		
		Result result = mock(Result.class);
		when(result.isOk()).thenReturn(isOK);
		
		Web web = mock(Web.class);
		
		Server server = mock(Server.class);
		when(server.connect(web)).thenReturn(result);
		
		WebVerificator webVer = new WebVerificator(client);
		webVer.checkWeb(server, web);
		if(isOK) 
			verify(client).registerWebisOk(web);
		else 
			verify(client).registerWebReturnedError(web, result);
	}
}
