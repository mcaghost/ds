import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.mysql.cj.xdevapi.Statement;

public class StudDBOperations extends UnicastRemoteObject implements StudDBInfo{
	private static final long serialVersionUID=1L;
	Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	String colStr,resultStr;
	
	public StudDBOperations()throws RemoteException{
		super();
		con=null;
		stmt=null;
		rs=null;
		rsmd=null;
		colStr="";
		resultStr="";
		
	}
public void setDBcon() {
	try {
		String URL="jdbc:mysql://localhost:3306/studinfo";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(URL,"root","");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}@Override
public String getData(String strQry) throws RemoteException {
    try {
        setDBcon();
        System.out.println("Server Registered");
        stmt = con.createStatement();
        rs = stmt.executeQuery(strQry);
        rsmd = rs.getMetaData();

        // Fetch column names
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            colStr = colStr + rsmd.getColumnName(i) + "\t";
        }

        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                resultStr = resultStr + rs.getString(i) + "\t";
            }
            resultStr = resultStr + "\n";
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return colStr + "\n\n" + resultStr;
}

@Override
public String insertData(String strQry)throws RemoteException{
	try {
		setDBcon();
		System.out.println("Server Registered");
		stmt=con.createStatement();
		int recordInserted=stmt.executeUpdate(strQry);
		if(recordInserted !=0)
			resultStr="Record Inserted Successfully";
		else
			resultStr="Record Not Inserted ";

	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return resultStr;
}

}
