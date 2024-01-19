import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudDBInfo extends Remote {
    // Method to retrieve data from the database
    public String getData(String strQry) throws RemoteException;

    // Method to insert data into the database
    public String insertData(String strQry) throws RemoteException;
}
