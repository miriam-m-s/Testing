package B;

public class EmisorFactura {
	
		  private PrinterService printerService;
		  private EmailService emailService;
		  
		  public EmisorFactura(PrinterService printerService, EmailService emailService) {
		    this.printerService = printerService;
		    this.emailService = emailService;
		  }

		  public void emitirFactura(Factura factura, Cliente cliente) {
		    if(cliente.prefiereEmails()) {
		      emailService.sendFactura(factura,cliente.getEmail());
		      
		    } else {
		      printerService.printFactura(factura);
		    }
		  }
}
