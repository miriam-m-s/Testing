package C;

public class WebVerificator {
	
	private Logger log;
	
	public WebVerificator(Logger log) {
		this.log = log;
	}
	public void checkWeb(Server server, Web web) {
		Result result = server.connect(web);
		
		if (result.isOk( )) {
			log.registerWebisOk(web);
		} else {
			log.registerWebReturnedError(web,result);
		}
}
}