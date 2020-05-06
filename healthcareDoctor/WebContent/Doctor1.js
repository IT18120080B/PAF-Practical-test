//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
});

$(document).on("click", "#submitusers", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidUsersIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "DoctorApi",
		type : type,
		data : $("#DOC").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#DoctorGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#DOC")[0].reset();
}

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "DoctorApi",
		type : "DELETE",
		data : "did=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#DoctorGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
		{
			$("#hidUserIDUpdate").val(
					$(this).closest("tr").find('#hidUserIDUpdate').val());
			$("#docNic").val($(this).closest("tr").find('td:eq(1)').text());
			$("#docName").val($(this).closest("tr").find('td:eq(2)').text());
			$("#specialization").val($(this).closest("tr").find('td:eq(3)').text());
			$("#Hosptial").val($(this).closest("tr").find('td:eq(4)').text());
			$("#Room_No").val($(this).closest("tr").find('td:eq(7)').text());
			$("#datee").val($(this).closest("tr").find('td:eq(0)').text());
			$("#timee").val($(this).closest("tr").find('td:eq(5)').text());
			$("#timee2").val($(this).closest("tr").find('td:eq(6)').text());
		
		});
// CLIENTMODEL=========================================================================
function validateItemForm() {
	// NIC
	if ($("#docNic").val().trim() == "") {
		return "Insert Doctor NIC CardNumber";
	}
	// doctor name
	if ($("#docName").val().trim() == "") {
		return "Insert Doctor Name.";
	}
	// doc specialization
	if ($("#specialization").val().trim() == "") {
		return "Insert your Specialization.";
	}

	// hospital
	if ($("#Hosptial").val().trim() == "") {
		return "Insert Hospital Name.";
	}
	//Room number
	if ($("#Room_No").val().trim() == "") {
		return "Insert Room Number.";
	}
	//Date
	if ($("#datee").val().trim() == "") {
		return "Insert your working day.";
	}
	//Start time
	if ($("#timee").val().trim() == "") {
		return "Insert youe Session starting time.";
	}
	
	//End Time
	if ($("#timee2").val().trim() == "") {
		return "Insert your session end time.";
	}
	return true;
}
