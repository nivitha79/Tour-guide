package Hello;
import java.sql.*;
public class sqlDemo
{
	private static Connection con;
	public static Connection  getCon(){
	try
	{
		oracle.jdbc.driver.OracleDriver od=new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(od);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lbrce");
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	return con;
	}
}