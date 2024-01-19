import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcOperation extends UnicastRemoteObject implements adder {
	final long serialVersionUID=1L;
	CalcOperation()throws RemoteException{
		super();
	}
	
	public int getAddition(int num1,int num2)throws RemoteException{
		return num1+num2;
		
	}
	public int getSubtraction(int num1,int num2)throws RemoteException{
		return num1-num2;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
