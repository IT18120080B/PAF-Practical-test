
package DoctorModel;
import DoctorModel.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String outputString = docObj.addSession(request.getParameter("docNic"), request.getParameter("docName"),
				request.getParameter("specialization"), request.getParameter("Hosptial"), request.getParameter("Room_No"),
				request.getParameter("datee"), request.getParameter("timee"), request.getParameter("timee2"));

		response.getWriter().write(outputString);
	}

	// -----------------------------------------------------------------------------------------------------------

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);

		String outputString = docObj.updateSession(paras.get("hidUsersIDSave").toString(),
//				 paras.get("nic").toString(),
				paras.get("docName").toString(), paras.get("specialization").toString(), paras.get("Hosptial").toString(),
				paras.get("Room_No").toString(), paras.get("datee").toString(), paras.get("timee").toString(),
				paras.get("timee2").toString());

		response.getWriter().write(outputString);

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		 String output = docObj.deleteSession(paras.get("nic").toString());
		response.getWriter().write(output); 
		
	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
