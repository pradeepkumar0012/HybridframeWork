package practice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import com.mysql.jdbc.Driver;

public class Jdbc {
	public static void main(String[] args) throws Throwable {
		Driver driverref=new Driver();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/q_spiders","root","root");
		Statement stat = con.createStatement();
		String selectquerry="select * from student ";
		ResultSet result = stat.executeQuery(selectquerry);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		con.close();


	}

}



