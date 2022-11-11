package A;

public class Mensaje {
	
private TemplateEngine templateEngine;
private MailServer mailServer;

public Mensaje(MailServer mailServer, TemplateEngine templateEngine) {
	this.mailServer = mailServer;
	this.templateEngine = templateEngine;
}

public void sendMensaje(Cliente cliente, Template template) {
	String msgContenido = templateEngine.preparaMensaje(template, cliente);
    mailServer.send(cliente.getEmail(), msgContenido);
}
}