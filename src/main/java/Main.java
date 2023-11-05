import models.Cliente;
import repository.ClienteRepository;

public class Main{
	
	public static void main(String[] args ) {
		System.out.println("Hello Wolrd");
		ClienteRepository repository =  new ClienteRepository();
		System.out.println("Control1");
		Cliente cliente =  new Cliente("Huillca","Huaracallo", "John");
		System.out.println("Control2");
		repository.create(cliente);
		System.out.println("Control3");
		for(Cliente client :  repository.findAll()) {
			System.out.print(client.toString());
		}
	} 
	
}
