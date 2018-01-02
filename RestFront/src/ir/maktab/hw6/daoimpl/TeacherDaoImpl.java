/**
 * 
 */
package ir.maktab.hw6.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ir.maktab.hw6.dao.TeacherDAO;
import ir.maktab.hw6.model.Teacher;

/**
 * @author Matin03
 *
 */
public class TeacherDaoImpl implements TeacherDAO {

	String DB_URL = "jdbc:mysql://localhost/uni";
	String DB_USER = "root";
	String DB_PASS = "";

	public TeacherDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ir.maktab.hw6.dao.TeacherDAO#createTeacher(ir.maktab.hw6.model.Teacher)
	 */
	@Override
	public void createTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		dbinit();
		String sql = String.format("INSERT IGNORE INTO teachers (Id,Name,Address) VALUES(%1$d,'%2$s','%3$s')",
				teacher.getId(), teacher.getName(), teacher.getAddress());
		executeUpdate(sql);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ir.maktab.hw6.dao.TeacherDAO#retrieveTeacher(int)
	 */
	@Override
	public Teacher retrieveTeacher(int id) {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM teachers WHERE id='%1$d'", id);
		Teacher teacher = new Teacher();

		ResultSet resultSet = executeQuery(sql);
		try {
			resultSet.next();
			teacher.setId(resultSet.getInt("id"));
			teacher.setName(resultSet.getString("name"));
			teacher.setAddress(resultSet.getString("address"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;

	}

	public Teacher retrieveTeacher(String name) {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM teachers WHERE name='%1$s'", name);
		Teacher teacher = new Teacher();

		ResultSet resultSet = executeQuery(sql);
		try {
			resultSet.next();
			teacher.setId(resultSet.getInt("id"));
			teacher.setName(resultSet.getString("name"));
			teacher.setAddress(resultSet.getString("address"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ir.maktab.hw6.dao.TeacherDAO#updateTeacher(ir.maktab.hw6.model.Teacher)
	 */
	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = String.format("UPDATE teachers SET Name= '%1$s', Address= '%2$s'  WHERE id= %3$d",
				teacher.getName(), teacher.getAddress(), teacher.getId());
		executeUpdate(sql);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ir.maktab.hw6.dao.TeacherDAO#deletTeacher(ir.maktab.hw6.model.Teacher)
	 */
	@Override
	public void deletTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM teachers WHERE id=%1$d", teacher.getId());
		executeUpdate(sql);

	}

	public void deletTeacher(String name) {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM teachers WHERE name=%1$s", name);
		executeUpdate(sql);

	}

	public void deletTeacher(int id) {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM teachers WHERE id=%1$d", id);
		executeUpdate(sql);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ir.maktab.hw6.dao.TeacherDAO#getAllTeachers()
	 */
	@Override
	public ArrayList<Teacher> getAllTeachers() {
		dbinit();
		String sql = String.format("SELECT * FROM teachers");
		ArrayList<Teacher> teachers = new ArrayList<>();

		ResultSet resultSet = executeQuery(sql);
		try {
			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("Id"));
				teacher.setName(resultSet.getString("Name"));
				teacher.setAddress(resultSet.getString("Address"));

				teachers.add(teacher);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}
	


	private ResultSet executeQuery(String sql) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void executeUpdate(String sql) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void dbinit() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE IF NOT EXISTS uni";
			stmt.executeUpdate(sql);

			sql = "USE uni ";
			stmt.executeUpdate(sql);

			sql = "CREATE TABLE IF NOT EXISTS teachers( Id int,  Name varchar(45), Address varchar(45), PRIMARY KEY(Id) )";
			stmt.executeUpdate(sql);

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("DB initiated!");

	}

}
