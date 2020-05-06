package DoctorModel;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.research.ws.wadl.Request;

public class Doctor {
	

	
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
//		Date date = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String strDate = dateFormat.format(date);
		
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
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(" not inserted");
	}

	return Output;
}
	public String deleteSession(String docNic)
	{
		String output="";
		
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from doctor_portal where doc_nic=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setString(1,docNic);
			prepareStmt.execute();
			connection.close();
			
			output= "deleted successfully";
		}
		catch(Exception e)
		{
			output="error while deleting the Doctor";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String updateSession(String date,String name,String nic,String Specialization,String hospital,String timee,String timee2,String roomno)
	{
		String output="";
		
		try {
			Connection connection=connect();
			if(connection==null)
			{
				return "error while connecting to the database for updating";
			}
			
			String query="UPDATE doctor_portal SET `doc_name =?`,`doc_specialization=?`,`doc_hospital=?`, `room_no=?`, `date=?`,`time=?`,`time2=?` "
					+ "where doc_nic=?";
					
					PreparedStatement pStatement=connection.prepareStatement(query);
					
					//pStatement.setString(1, appointmentNum);
					
					pStatement.setString(1, name);
					pStatement.setString(2, Specialization);
					pStatement.setString(3, hospital);
					pStatement.setInt(4, Integer.parseInt(roomno));
					pStatement.setString(5, date);
					pStatement.setString(6, timee);
					pStatement.setString(7, timee2);
					pStatement.setString(8, nic);	
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					pStatement.execute();
					connection.close();
					System.out.print("updated");
					output="updated successfully";
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.print("not updated");
			output="error while updating the Doctor";
			System.err.println(e.getMessage());
		}
		return output;
	}
	public String readSession()
	{
		String output= "";
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
//			output += "<<td><input id=\"hidItemIDUpdate\" name=\"hidItemIDUpdate\" type=\"hidden\" value=\"" + nic + "\">" + Name + "</td>"; 
			output = "<table class=\"table\"><tr><th></th><th>Date</th>"					
					 +"<th>Doctor NIC</th>"
					 +"<th>Doctor Name</th>"
					 +"<th>Specialization</th>"
					 + "<th>Hospital</th>"
					 +"<th>Start Time</th>"
					 +"<th>End Time</th>"
					 +"<th>Room number</th>"
					 +"<th>Update</th>"
					 +"<th>Delete</th>"+"</tr>";
					 //+"<th>hospital</th></tr>";
					// + "<th>Update</th><th>Remove</th></tr>"; 	
			
			String  query="select * from doctor_portal order by session_id DESC ";
			Statement stmtStatement=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			
			
			while (rs.next())
			{
				String datee=rs.getString("date");
				String nic=rs.getString("doc_nic");
				String name=rs.getString("doc_name");
				String Specialization=rs.getString("doc_specialization");
				String hospital=rs.getString("doc_hospital");
				String stime=rs.getString("time");
				String etime=rs.getString("time2");
				String roomno=Integer.toString(rs.getInt("room_no"));
				
				
				
			
				
				output += "<tr><td><input id=\"hidItemIDUpdate\" name=\"hidItemIDUpdate\" type=\"hidden\" value=\"" + nic + "\"></td>";
				output += "<td>" + datee + "</td>";
				output += "<td>" + nic + "</td>"; 
				output += "<td>" + name + "</td>"; 
				output += "<td>" + Specialization + "</td>"; 
				output += "<td>" + hospital + "</td>"; 
				output += "<td>" + stime + "</td>"; 
				output += "<td>" + etime + "</td>"; 
				output += "<td>" + roomno + "</td>"; 
				output += "<td><input name=\"btnUpdate\" id=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btnUpdate btn btn-secondary\"></td>";	
				output += "<td><form method=\"post\" action=\"Doctor.jsp\">"
				 +"<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
				 +"<input name=\"hidItemIDDelete\" type=\"hidden\" value=\"" + nic + "\">" + "</form></td></tr>"; 
				
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
	
	

}