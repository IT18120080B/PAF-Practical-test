<%@page import="DoctorModel.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				
					
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary btn-lg btn-block">

				<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				
				<div id="alertSuccess" class="alert alert-success"></div>
 				<div id="alertError" class="alert alert-danger"></div>

					
						
				</div>
			</form>
		</fieldset>
		<br> <br> <br>
		
		

</div>
		
		
		

		<div class="container" id = "DoctorGrid">
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