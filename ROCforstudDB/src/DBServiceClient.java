import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class DBServiceClient {

    public DBServiceClient() {
        super();
    }

    public static void main(String[] args) {
        String sql = "", ch = "";
        try {
            StudDBInfo stub = (StudDBInfo) Naming.lookup("rmi://localhost:1900/studinfo");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Select an Option");
                System.out.println("1:Retrieve Student Information");
                System.out.println("2:Insert Student Information");
                System.out.println("3:Exit");
                System.out.println("Enter your Choice");
                ch = br.readLine();

                if (ch.equals("1")) {
                    sql = "SELECT * FROM studentnew";
                    sql = stub.getData(sql);
                } else if (ch.equals("2")) {
                    sql = "INSERT INTO studentnew(sroll, sname) VALUES (10, 'Harshal')";
                    sql = stub.insertData(sql);
                } else if (ch.equals("3")) {
                    System.exit(0);
                } else {
                    sql = "Please select a valid option";
                }
                System.out.println(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
