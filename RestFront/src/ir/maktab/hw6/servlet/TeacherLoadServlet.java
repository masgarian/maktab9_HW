package ir.maktab.hw6.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.maktab.hw6.daoimpl.TeacherDaoImpl;
import ir.maktab.hw6.model.Teacher;

/**
 * Servlet implementation class TeacherLoadServlet
 */
@WebServlet("/tload")
public class TeacherLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherLoadServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		// writer.append("Served at: ").append(request.getContextPath());
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Teacher teacher = new TeacherDaoImpl().retrieveTeacher(id);

			response.setContentType("text/html");
			writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.css\"> \r\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap-theme.css\">\r\n"
					+ "<title>My CRUD Web UI</title>\r\n" + "	<div class=\"container\">\r\n"
					+ "		<table class=\"table table-striped\" name=\"table\">\r\n" + "			<tr>\r\n"
					+ "				<th>ID</th>\r\n" + "				" 
					+ "				<th>Name</th>\r\n"
					+ "				<th>Address</th>\r\n" 
					+ "				<th></th>\r\n" 
					+ "			</tr>\r\n" + "			<tr>\r\n"
					+ "				<th>" + teacher.getId() + "</th>\r\n" 
					+ "				<th>" + teacher.getName() +"</th>\r\n" 
					+ "				<th>" + teacher.getAddress() + "</th>\r\n" 
					+ "				<th></th>\r\n" + "			</tr>\r\n"
					+ "</table>" + "</div>");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
