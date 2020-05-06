package DoctorService;


import DoctorModel.Doctor;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

@Path("/Doctor") 
public class DoctorService {
	
		Doctor docObj = new Doctor();
		
		@GET
		@Path("/test")
		@Produces(MediaType.TEXT_HTML)
		public String readItems()
		 {
		 return "Hello";
		 } 
		
		
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readSession()
		 {
		 return docObj.readSession();
		 }
		
		
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertSession(@FormParam("nic") String nic,
		@FormParam("name") String name,
		 @FormParam("specialization") String Specialization,
		 @FormParam("hospital") String hospital,
		 @FormParam("room") String room,
		 @FormParam("datee") String datee,
		 @FormParam("Time1") String time,
		 @FormParam("time2") String time2)
		 
		{
		 String output = docObj.addSession(nic,name,Specialization,hospital,room,datee,time,time2);
		return output;
		}
		
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateSession(String docData)
		{
		//Convert the input string to a JSON object
		 JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject();
		//Read the values from the JSON object
		 String nic = docObject.get("nic").getAsString();
		 String name = docObject.get("name").getAsString();
		 String hospital = docObject.get("hospital").getAsString();
		 String datee = docObject.get("datee").getAsString();
		 String time = docObject.get("time").getAsString();
		 String time2 = docObject.get("time2").getAsString();
		 String roomno = docObject.get("roomno").getAsString();
		 String specialization = docObject.get("specialization").getAsString();
		 
		 String output = docObj.updateSession(nic,name,specialization,hospital,datee,time,time2,roomno);
		return output;
		}
		
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteSession(String docData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(docData, "", Parser.xmlParser());

		//Read the value from the element <itemID>
		 String nic = doc.select("nic").text();
		 String output = docObj.deleteSession(nic);
		return output;
		}
}
