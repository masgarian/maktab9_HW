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

import ir.maktab.hw6.daoimpl.TeacherDaoImpl;
import ir.maktab.hw6.model.Teacher;

@Path("/profs")
public class TeacherResource {

	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Teacher read(@PathParam("id") int id) {
		Teacher student = new TeacherDaoImpl().retrieveTeacher(id);
		return student;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Teacher> readAll() {
		System.out.println("teacher get rest");
		ArrayList<Teacher> teachers = new TeacherDaoImpl().getAllTeachers();
		for (Teacher s : teachers) {
			System.out.println(s);
		}
		return teachers;
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean update(@PathParam("id") int id, Teacher teacher) {
		try {
			teacher.setId(id);
			System.out.println(teacher);
			new TeacherDaoImpl().updateTeacher(teacher);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean creat(Teacher teacher) {
		try {
			new TeacherDaoImpl().createTeacher(teacher);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@DELETE
	public boolean deleteAll() {
		boolean res = false;
		try {
			TeacherDaoImpl dao = new TeacherDaoImpl();
			ArrayList<Teacher> teachers = dao.getAllTeachers();
			for (Teacher s : teachers) {
				dao.deletTeacher(s);
				res = true;
			}
		} catch (Exception e) {
			
			return false;
		}
		return res;
	}

	@DELETE
	@Path("{id}")
	public boolean delete(@PathParam("id") int id) {
		boolean res = false;
		try {
			new TeacherDaoImpl().deletTeacher(id);
			res = true;
		} catch (Exception e) {
			
			return false;
		}
		return res;
	}
}

