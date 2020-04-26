<%@page import="DoctorModel.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getParameter("docNic") != null) {
		Doctor reg = new Doctor();
		//reg.connect();
		String stsMsg = reg.addSession(request.getParameter("docNic"), request.getParameter("docName"),request.getParameter("specialization"),
				request.getParameter("Hosptial"), request.getParameter("Room_No"),
				request.getParameter("datee"), request.getParameter("timee"), request.getParameter("timee2"));

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("loginGui.jsp");

	}

	if (request.getParameter("docId") != null) {
		Doctor itemObject = new Doctor();
		String stsMsg = itemObject.deleteSession(request.getParameter("docId"));

		session.setAttribute("statusMsg", stsMsg);
	}

	if (request.getParameter("udoctorId") != null) {
		Doctor update = new Doctor();
		//app.connect();
		String stsMsg = update.updateSession(request.getParameter("udoctorId"),
				request.getParameter("uname"),
				request.getParameter("uHosptial"), request.getParameter("update_date"),
				request.getParameter("upTime"), request.getParameter("upTime2"),
				request.getParameter("Room_No"));

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("patient.jsp");

	}
%>





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors' Portal</title>
<link href="myStyle.css" rel="stylesheet" />
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="js/jquery-3.5.0.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">

		 <p class="font-weight-bold"><center><h1>Doctors' Portal</h1></center></p><br><br>
		<fieldset>

			<legend>Add Sessions</legend>
			<form method="post" action="Doctor.jsp">
			

				Doctor NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" class="form-control"
					name="docNic"> <br> <br> Doctor
					
					
			Doctor Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" class="form-control"
					name="docName"> <br> <br> Doctor
					
					
				Specialization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" class="form-control"
					name="specialization"> <br>
					
					

				<div class = "form-row">
					<div class = "form-group   col-md-6">
					
				<br> Hospital &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
					name="Hosptial" class="form-control">
					<option value="Suwasewana" selected="selected">Suwasewana</option>
					<option value="Nawaloka" selected="selected">Nawaloka</option>
					<option value="Asiri" selected="selected">Asiri</option></select>
					
					</div>
					<div class = "form-group   col-md-6">
				 <br> Room No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
					name="Room_No" class="form-control">
					<option value="101" selected="selected">101</option>
					<option value="202" selected="selected">202</option>
					<option value="303" selected="selected">303</option>
				</select> <br>
				</div>
				</div>
				<br> Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
					name="datee" class="form-check-input" value="Monday">    Monday  <input type="radio"
					
					name="datee" value="Tuesday">Tuesday <input type="radio"
					name="datee" value="Wednesday">Wednesday <input
					type="radio"  name="datee" value="Thursday">Thursday <input
					type="radio"  name="datee" value="Friday">Friday <br>
				<br> Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time"
					name="timee"> to Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="time" name="timee2"> <br>
			
				<br>
				<div class="container">
					
					<input name="btnSubmit" type="submit" value="Submit" class="btn btn-primary btn-lg btn-block"> 
				</div>
			</form>
		</fieldset>
		<br> <br> <br>
		<fieldset>
			<legend>Delete Sessions</legend>
			<form method="post" action="Doctor.jsp">

				Doctor NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" class="form-control"
					name="docId"> <br> <br>


				<div class="container">
					<input name="btnSubmit" type="submit" value=Delete class="btn btn-danger btn-lg btn-block"> 
				</div>
			</form>
		</fieldset>
		<br> <br>
		
		<div class="container">
			<fieldset>

				<legend>Update Sessions</legend>
				<form method="post" action="Doctor.jsp">
					Doctor NIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" class="form-control"
						name="udoctorId"><br>  Updated Hospital
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="uHosptial" class="form-control"> 
						<option value="Suwasewana" selected="selected">Suwasewana</option>
						<option value="Nawaloka" selected="selected">Nawaloka</option>
						<option value="Asiri" selected="selected">Asiri</option>
					</select> 
					
					
					
					<br> Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" 
						name="update_date">Monday <input type="radio"
						name="update_date">Tuesday <input type="radio"
						name="update_date">Wednsday <input type="radio"
						name="update_date">Thursday <input type="radio"
						name="update_date">Friday <br>
						
						
						
						
						
					<br> Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time"
						name="upTime"> To Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="time"  name="upTime2"> <br> <br> Updated
					Room No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="Room_No"  class="form-control">
						<option value="101" selected="selected">101</option>
						<option value="202" selected="selected">202</option>
						<option value="303" selected="selected">303</option>
					</select> <br>
					<br>
					<div class="container">
						<div class="container">
							<input name="update" type="submit" value="Update" class="btn btn-success btn-lg btn-block"> 
							
						</div>
					</div>
				</form>


			</fieldset>
		</div>

		<div class="container">
			<fieldset>
				<legend>View session</legend>
				<form method="post" action="Doctor.jsp">
					<%
						Doctor viewDoc = new Doctor();
						out.print(viewDoc.readSession());
					%>



				</form>
			</fieldset>
		</div>
	</div>
</body>
</html>