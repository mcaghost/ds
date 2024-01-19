import java.rmi.Naming;
import java.rmi.*;

import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Calculator service server started");
			adder stub=new CalcOperation();
			System.out.println("Calculator service binding...");
			LocateRegistry.createRegistry(5000);
			Naming.rebind("rmi://localhost:5000/CalcOpService", stub);
			
			System.out.println("Calculator service is register in registry");
		}
			catch(Exception e)
				{
					System.out.println(e);
	
				}
	}

}
