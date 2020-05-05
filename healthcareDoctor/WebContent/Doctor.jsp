<%@page import="DoctorModel.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getParameter("docNic") != null) {
		Doctor reg = new Doctor();
		//reg.connect();
		String stsMsg = reg.addSession(request.getParameter("docNic"), request.getParameter("docName"),
				request.getParameter("specialization"), request.getParameter("Hosptial"),
				request.getParameter("Room_No"), request.getParameter("datee"), request.getParameter("timee"),
				request.getParameter("timee2"));

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
		String stsMsg = update.updateSession(request.getParameter("udoctorId"), request.getParameter("uname"),
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
<script src="Components/Doctor1.js"></script>

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
					type="text" class="form-control" name="docNic"> <br> <br>
				Doctor Doctor Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="docName" class="form-control" name="docName">
				<br> <br> Doctor
				Specialization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="specialization" class="form-control"
					name="specialization"> <br>
					Hospital &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							name="Hosptial" id ="Hospital"class="form-control">
							
				<br> Room No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				name="Room_No" id="Room_No" class="form-control">



			
				
				<br> Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" name="datee" class="form-control" id="datee" >
					<br>
				
				
				Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" id="timee"
					name="timee"> 
					
					to Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="time" id ="timee2" name="timee2"> <br> <br>
			


					<br>
<input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn btn-primary btn-lg btn-block">
<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">

					
						
				</div>
			</form>
		</fieldset>
		<br> <br> <br>
		
		<div class="row">
<div class="col-12" id="colDoctor">

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