package B;

public class Cliente {
 
 private Boolean opt;
 private String email;
 
 public Cliente(String email, Boolean opt) {
	 this.email=email;
	 this.opt=opt;
 }
 public Boolean prefiereEmails() {
	 return this.opt;
 };
 
 
 public String getEmail() {
	 return this.email;
 };
}
