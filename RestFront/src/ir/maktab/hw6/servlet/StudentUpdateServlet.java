package ir.maktab.hw6.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ir.maktab.hw6.daoimpl.StudentDaoImpl;
import ir.maktab.hw6.model.Student;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/up")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentUpdateServlet() {
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

		try {
			Student student = new Student(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
					request.getParameter("department"), Integer.parseInt(request.getParameter("teacherId")));
			
			new StudentDaoImpl().update(student);
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
