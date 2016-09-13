package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBconnect {
	
	private Connection conn;
	private Statement st;
	private ResultSet result;
	
	public DBconnect(){
		//create DB connection
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2", "root", "");
			st = (Statement) conn.createStatement();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public ResultSet getData(String query){
		
		try{
			//String query="select * from name";
			result = st.executeQuery(query);
			//print all records from db
//			System.out.println("Records from Database");
//			while(res.next()){
//				String id = res.getString("id");
//				String name = res.getString("name");
//				System.out.println("id " + id + " name " + name);
//			}
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	
	public void insertData(String query){
		try{
			st.executeUpdate(query);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
