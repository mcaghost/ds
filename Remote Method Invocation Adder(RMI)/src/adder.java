import java.rmi.Remote;
import java.rmi.RemoteException;

public interface adder extends Remote{
public int getAddition(int num1,int num2)
		throws RemoteException;

public int getSubtraction(int num1,int num2)
throws RemoteException;

	
	}


