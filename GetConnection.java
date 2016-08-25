package fileuploading;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetConnection {
	
public static Connection connection=null;

	public static Connection getConnection(){
		try{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/shoppingcart", "admin","admin");
		}catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] ar){
		/*try{
		Connection con=getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from categories");
		while(rs.next()){
			System.out.println(rs.getString("catname"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
}
