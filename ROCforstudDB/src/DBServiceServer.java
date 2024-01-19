import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DBServiceServer {

    public DBServiceServer() {
        super();
    }

    public static void main(String[] args) {
        try {
            StudDBInfo skeleton = new StudDBOperations();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/studinfo", skeleton);
            System.out.println("Server Registered..");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
