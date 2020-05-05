$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	 	
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide(); 
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
 $("#DOC").submit();
 $("#alertSuccess").text("Record Aded");
 $("#alertSuccess").show();
});

// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
 $("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
 $("#docNic").val($(this).closest("tr").find('td:eq(2)').text());
 $("#docName").val($(this).closest("tr").find('td:eq(3)').text());
 $("#specialization").val($(this).closest("tr").find('td:eq(4)').text());
 $("#Hospital").val($(this).closest("tr").find('td:eq(5)').text());
 $("#Room_No").val($(this).closest("tr").find('td:eq(8)').text());
 $("#datee").val($(this).closest("tr").find('td:eq(1)').text());
 $("#timee").val($(this).closest("tr").find('td:eq(6)').text());
 $("#timee2").val($(this).closest("tr").find('td:eq(7)').text());
});
// CLIENTMODEL=========================================================================
function validateItemForm()
{
// CODE
if ($("#docNic").val().trim() == "")
 {
 return "Insert NIC.";
 }
// NAME
if ($("#docName").val().trim() == "")
 {
 return "Insert  Doctor Name.";
 } 
// PRICE-------------------------------
if ($("#Room_No").val().trim() == "")
 {
 return "Insert Room No.";
 }
// is numerical value
var tmpPrice = $("#Room_No").val().trim();
if (!$.isNumeric(tmpPrice))
 {
 return "Insert a numerical value for Room No.";
 }

return true;
}
