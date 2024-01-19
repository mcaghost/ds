import java.rmi.Naming;

public class Client {
	
	public static void main(String[] args) {
	try {
		System.out.println("Client Program Started");
		adder stub=(adder)Naming.lookup("rmi://localhost:5000/CalcOpService");
		System.out.println("Addition= "+stub.getAddition(31,4));
		System.out.println("Subtraction= "+stub.getSubtraction(31,4));
		

		
	}catch(Exception e) {
		System.out.println(e);
	}

}}
