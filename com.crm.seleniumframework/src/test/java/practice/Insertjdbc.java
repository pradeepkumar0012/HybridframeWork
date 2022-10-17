package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Insertjdbc {
public static void main(String[] args) throws Throwable {
	Driver driverref=new Driver();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/q_spiders","root","root");
	Statement stat = con.createStatement();
	String querry="insert into student(first_name,last_name,address)values('raju','BN','INDIA')";
	String querry1="insert into student(first_name,last_name,address)values('yogu','BN','INDIA')";
	 int result = stat.executeUpdate(querry);
	 int result1 = stat.executeUpdate(querry1);
	 if((result==1)&&(result1==1)) {
		 System.out.println("user is created");
	 }else {
		 System.out.println("user is not created");
		
	 }
	 con.close();
}
}
