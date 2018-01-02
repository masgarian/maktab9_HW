package ir.maktab.hw6.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ir.maktab.hw6.daoimpl.TeacherDaoImpl;
import ir.maktab.hw6.model.Teacher;

/**
 * Servlet implementation class TeacherUpdateServlet
 */
@WebServlet("/tup")
public class TeacherUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		try {
			Teacher teacher = new Teacher(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
					request.getParameter("address"));
			
			new TeacherDaoImpl().updateTeacher(teacher);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
