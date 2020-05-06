

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import DoctorModel.*;











@WebServlet("/DoctorApi")
public class DoctorApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Doctor docObj = new Doctor();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String outputString = docObj.addSession( request.getParameter("nic"),request.getParameter("name"),
				request.getParameter("Specialization"),request.getParameter("hospital"),
				request.getParameter("room"),request.getParameter("datee"),request.getParameter("time"),
				request.getParameter("time2"));
				
		response.getWriter().write(outputString);
	}

	//-----------------------------------------------------------------------------------------------------------
	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Map paras = getParasMap(request); 
		
		
		String outputString=docObj.updateSession(paras.get("hidUsersIDSave").toString(),
				//paras.get("nic").toString(), 
				paras.get("name").toString(), 
				paras.get("Specialization").toString(),
				paras.get("hospital").toString(), 
				paras.get("room").toString(), 
				paras.get("datee").toString(), 
				paras.get("time").toString(),
				paras.get("time2").toString());

response.getWriter().write(outputString);
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
