package ir.maktab.hw6.dao;
import java.util.ArrayList;
import ir.maktab.hw6.model.Teacher;

public interface TeacherDAO {

	public void createTeacher(Teacher student);
	public Teacher retrieveTeacher(int id);
	public void updateTeacher(Teacher student);
	public void deletTeacher(Teacher student);
	public ArrayList<Teacher> getAllTeachers();

}



