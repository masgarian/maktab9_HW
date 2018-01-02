package ir.maktab.hw6.api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ir.maktab.hw6.daoimpl.StudentDaoImpl;
import ir.maktab.hw6.model.Student;

@Path("/students")
public class StudentResource {

	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student read(@PathParam("id") int id) {
		Student student = new StudentDaoImpl().get(id);
		return student;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Student> readAll() {
		System.out.println("student get rest");
		ArrayList<Student> students = new StudentDaoImpl().getAll();
		for (Student s : students) {
			System.out.println(s);
		}
		return students;
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean update(@PathParam("id") int id, Student student) {
		try {
			student.setId(id);
			System.out.println(student);
			new StudentDaoImpl().update(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean creat(Student student) {
		try {
			new StudentDaoImpl().add(student);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@DELETE
	public boolean deleteAll() {
		boolean res = false;
		try {
			StudentDaoImpl dao = new StudentDaoImpl();
			ArrayList<Student> students = dao.getAll();
			for (Student s : students) {
				dao.delete(s);
				res = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return res;
	}

	@DELETE
	@Path("{id}")
	public boolean delete(@PathParam("id") int id) {
		boolean res = false;
		try {
			new StudentDaoImpl().delete(id);
			res = true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return res;
	}
}
