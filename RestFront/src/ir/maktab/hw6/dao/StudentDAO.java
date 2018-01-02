package ir.maktab.hw6.dao;
import java.util.ArrayList;
import ir.maktab.hw6.model.Student;
public interface StudentDAO {
	
	public void add(Student student);
	public void delete(Student student);
	public void update (Student student);
	public Student get(int id);
	public ArrayList<Student> getAll();

}
