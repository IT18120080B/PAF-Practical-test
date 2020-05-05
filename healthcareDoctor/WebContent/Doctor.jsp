<%@page import="DoctorModel.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getParameter("hidItemIDDelete") != null) {
		Doctor itemObject = new Doctor();
		String stsMsg = itemObject.deleteSession(request.getParameter("hidItemIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
		
	}

	if (request.getParameter("hidItemIDSave") == "") {
		Doctor reg = new Doctor();
		//reg.connect();
		String stsMsg = reg.addSession(request.getParameter("docNic"), request.getParameter("docName"),
				request.getParameter("specialization"), request.getParameter("Hosptial"),
				request.getParameter("Room_No"), request.getParameter("datee"), request.getParameter("timee"),
				request.getParameter("timee2"));
		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("loginGui.jsp");
		
	}
	else{
		Doctor update = new Doctor();
		//app.connect();
		String stsMsg = update.updateSession(request.getParameter("hidItemIDSave"), request.getParameter("docName"),
				request.getParameter("Hosptial"), request.getParameter("Room_No"),
				request.getParameter("timee"), request.getParameter("timee2"),
				request.getParameter("datee"));
		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("patient.jsp");
		
	}
	if (request.getParameter("hidItemIDDelete") != null) {
		Doctor itemObject = new Doctor();
		String stsMsg = itemObject.deleteSession(request.getParameter("hidItemIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
	
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors' Portal</title>
<link href="myStyle.css" rel="stylesheet" />
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="jquery-3.5.0.min.js"></script>
<script src="Doctor1.js"></script>

</head>
<body>
	<div class="container">

		<p class="font-weight-bold">
		<center>
			<h1>Doctors' Portal</h1>
		</center>
		</p>
		<br> <br>
		<fieldset>

			<legend>Add Sessions</legend>
			<form method="post" id="DOC"action="Doctor.jsp">


				Doctor NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="docNic"
					type="text" class="form-control" name="docNic"> <br>
				Doctor Doctor Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="docName" class="form-control" name="docName">
				 <br> Doctor
				Specialization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="specialization" class="form-control"
					name="specialization"> <br>
					Hospital &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Hosptial" id ="Hospital"class="form-control">
							
				<br> Room No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				name="Room_No" id="Room_No" class="form-control">


<br> Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="date" name="datee" class="form-control" id="datee" >
					<br>
				
				
				Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time" id="timee"
					name="timee"> 
					
					to Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="time" id ="timee2" name="timee2"> <br> <br>
			


					<br>
				<div id="alertSuccess" class="alert alert-success"></div>
 				<div id="alertError" class="alert alert-danger"></div>
					
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary btn-lg btn-block">

				<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">

					
						
				</div>
			</form>
		</fieldset>
		<br> <br> <br>
		
		

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