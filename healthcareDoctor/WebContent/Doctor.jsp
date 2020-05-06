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
<script src="Components/jquery-3.5.0.min.js"></script>
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
			<form method="post" id="DOC">


				Doctor NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input id="docNic"
					type="text" class="form-control" name="docNic"> <br>

				Doctor Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
					id="docName" class="form-control" name="docName"> <br>
				Doctor Specialization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="text" id="specialization" class="form-control"
					name="specialization"> <br> Hospital
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="Hosptial"
					id="Hospital" class="form-control"> <br> Room
				No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="Room_No"
					id="Room_No" class="form-control"> <br>
				Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="date"
					name="datee" class="form-control" id="datee"> <br>

				<div class="form-row">
					<div class="form-group col-md-6">
						Session start Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time"
							id="timee" class="form-control" name="timee">

					</div>
					<div class="form-group col-md-6">
						Session end Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="time"
							id="timee2" class="form-control" name="timee2"> <br>
						<br>

					</div>
				</div>
				<br> <input id="btnSave" name="btnSave" type="button"
					value="Save" class="btn btn-primary btn-lg btn-block"> <input
					type="hidden" id="hidDocIDSave" name="hidDocIDSave" value="">

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

			</form>
		</fieldset>
		<br> <br> <br>








		<div class="container" id="DoctorGrid">
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