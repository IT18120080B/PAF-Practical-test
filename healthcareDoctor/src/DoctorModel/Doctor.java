package DoctorModel;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.research.ws.wadl.Request;

public class Doctor {
	

//Database Connection---------------------------------------	
	public Connection connect()

	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", ""); 
			System.out.print("Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}
	
	
	
//Read sessions---------------------------------------------------	
	public String readSession()

	{
		String output= "";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}

			output = "<table class='table'><tr><th></th><th>Date</th>"					
					 +"<th>Doctor NIC</th>"
					 +"<th>Doctor Name</th>"
					 +"<th>Specialization</th>"
					 + "<th>Hospital</th>"
					 +"<th>Start Time</th>"
					 +"<th>End Time</th>"
					 +"<th>Room number</th>"
					 +"<th>Update</th>"
					 +"<th>Delete</th>"+"</tr>";
						
			
			String  query="select * from doctor_portal order by session_id DESC ";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
			
			while (rs.next())
			{
				String docid=rs.getString("session_id");
				String datee=rs.getString("date");
				String nic=rs.getString("doc_nic");
				String name=rs.getString("doc_name");
				String Specialization=rs.getString("doc_specialization");
				String hospital=rs.getString("doc_hospital");
				String stime=rs.getString("time");
				String etime=rs.getString("time2");
				String roomno=Integer.toString(rs.getInt("room_no"));
				
				
				
			
				
				output += "<tr><td><input id='hidItemIDUpdate' name='hidItemIDUpdate' type='hidden' value='"+ docid +"'></td>";
				output += "<td>" + datee + "</td>";
				output += "<td>" + nic + "</td>"; 
				output += "<td>" + name + "</td>"; 
				output += "<td>" + Specialization + "</td>"; 
				output += "<td>" + hospital + "</td>"; 
				output += "<td>" + stime + "</td>"; 
				output += "<td>" + etime + "</td>"; 
				output += "<td>" + roomno + "</td>"; 
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'</td>"
						+ "<td><input name='btnRemove' type='button'"
						+ "value='Remove' class='btnRemove btn btn-danger' data-docid='"
						+ docid + "'>" + "</td></tr>"; 
						
				
				//-------------------------------------------------------
				
			
				
				
				
				
				
				
				
				
			}
			con.close();
			
			output+="</table>";
			System.out.println("table can be view");
		}
		catch(Exception e)
		{
			output="error while reading the appointment";
			System.err.println(e.getMessage());
			System.out.println("table can't be view");
		}
		return output;	
		
	}
	
	
	//Add sessions-------------------------------------------------
	public String addSession(String nic,String name,String Specialization,String hospital,String room,String datee,String time,String time2)
	{
	String Output ="";
	
	try {
		//patientDatabase newp = new patientDatabase();
		Connection con = connect();

		if (con == null) {
			//return "Error while connectingto the database for inserting";
		}

		String query = " insert into doctor_portal (`doc_nic`,`doc_name`,`doc_specialization`,`doc_hospital`, `room_no`, `date`,`time`,`time2`) "
				+ "values(?,?,?,?,?,?,?,?)";

		
		PreparedStatement preparedStmt = con.prepareStatement(query);
	
		preparedStmt.setString(1, nic);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, Specialization);
		preparedStmt.setString(4, hospital);
		preparedStmt.setInt(5, Integer.parseInt(room) );
		preparedStmt.setString(6, datee);
		preparedStmt.setString(7, time);
		preparedStmt.setString(8, time2);
		
		preparedStmt.execute();
		con.close();
		System.out.println("inserted");
		Output = "Inserted successfully";
		String newDOC = readSession();
		 Output = "{\"status\":\"success\", \"data\": \"" +newDOC + "\"}"; 
	} catch (Exception e) {

		Output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
				 System.err.println(e.getMessage()); 
	}

	return Output;
}
	
	//Delete Sessions----------------------------------------------
	public String deleteSession(String docNic)
	{
		String output="";
		
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from doctor_portal where session_id=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setString(1,docNic);
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully";
			String newDOC = readSession();
			output = "{\"status\":\"success\", \"data\": \"" +newDOC + "\"}"; 
		}
		catch(Exception e)
		{
			output="error while deleting the Doctor";
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
			 System.err.println(e.getMessage());
		
		}
		return output;
	}
	
//Update Sessions--------------------------------------------------------------------
	public String updateSession(String date,String name,String nic,String Specialization,String hospital,String timee,String timee2,String roomno, String docid )
	{
		String output="";
		
		try {
			Connection connection=connect();
			if(connection==null)
			{
				return "error while connecting to the database for updating";
			}
			
			String query="UPDATE doctor_portal SET doc_nic=?,doc_name =?,doc_specialization=?,doc_hospital=?, room_no=?, date=?,time=?,time2=?"
					+ "where session_id=?";
					
					PreparedStatement pStatement=connection.prepareStatement(query);
					
				
					
					pStatement.setString(1, nic);
					pStatement.setString(2, name);
					pStatement.setString(3, Specialization);
					pStatement.setString(4, hospital);
					pStatement.setInt(5, Integer.parseInt(roomno));
					pStatement.setString(6, date);
					pStatement.setString(7, timee);
					pStatement.setString(8, timee2);
					pStatement.setInt(9, Integer.parseInt(docid));				
					pStatement.execute();
					connection.close();
					System.out.print("updated");
					output="updated successfully";
					String newDOC = readSession();
					output = "{\"status\":\"success\", \"data\": \"" +newDOC + "\"}"; 
		}
		catch (Exception e) {
		
			System.out.print("not updated");
			output="error while updating the Doctor";
			output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
			 System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	

}