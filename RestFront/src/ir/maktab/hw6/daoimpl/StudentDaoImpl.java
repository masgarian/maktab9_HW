package ir.maktab.hw6.daoimpl;

import java.util.ArrayList;
import java.sql.*;

import ir.maktab.hw6.dao.*;
import ir.maktab.hw6.model.Student;

public class StudentDaoImpl implements StudentDAO {

	String DB_URL = "jdbc:mysql://localhost/uni";
	String DB_USER = "root";
	String DB_PASS = "";

	@Override
	public void add(Student student) {
		dbinit();
		String sql = String.format(
				"INSERT IGNORE INTO students (Id,Name,Department,TeacherId) VALUES(%1$d,'%2$s','%3$s',%4$d)",
				student.getId(), student.getName(), student.getDepartment(), student.getTeacherId());
		
		Statement statement=null;
		Connection connection=null;
		executeUpdate(sql,statement,connection);
		closeStatementConnection(statement, connection);
	}

	@Override
	public void delete(Student student) {
		dbinit();
		String sql = String.format("DELETE FROM students WHERE id=%1$d", student.getId());
		Statement statement=null;
		Connection connection=null;
		executeUpdate(sql,statement,connection);
		closeStatementConnection(statement, connection);
	}

	public void delete(String name) {
		dbinit();
		String sql = String.format("DELETE FROM students WHERE Name='%1$S' ", name);
		Statement statement=null;
		Connection connection=null;
		executeUpdate(sql,statement,connection);
		closeStatementConnection(statement, connection);
	}

	public void delete(int id) {
		dbinit();
		String sql = String.format("DELETE FROM students WHERE id=%1$d", id);
		Statement statement=null;
		Connection connection=null;
		executeUpdate(sql,statement,connection);
		closeStatementConnection(statement, connection);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		dbinit();
		String sql = String.format(
				"UPDATE students SET Name= '%1$s', Department= '%2$s' , TeacherId='%3$d' WHERE id= %4$d",
				student.getName(), student.getDepartment(), student.getTeacherId(), student.getId());
		Statement statement=null;
		Connection connection=null;
		executeUpdate(sql,statement,connection);
		closeStatementConnection(statement, connection);
		

	}

	@Override
	public Student get(int id) {
		// TODO Auto-generated method stub
		dbinit();
		String sql = String.format("SELECT * FROM students WHERE id='%1$d'", id);
		Student student = new Student();

		Statement statement=null;
		Connection connection = null;
		ResultSet resultSet = executeQuery(sql,statement,connection);
		try {
			resultSet.next();
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setDepartment(resultSet.getString("department"));
			student.setTeacherId(resultSet.getInt("TeacherId"));

			closeStatementConnection(statement,connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	public Student get(String name) {
		// TODO Auto-generated method stub
		dbinit();
		String sql = String.format("SELECT * FROM students WHERE name='%1$S'", name);
		Student student = new Student();

		Statement statement =null;
		Connection connection=null;
		ResultSet resultSet = executeQuery(sql,statement,connection);
		try {
			resultSet.next();
			student.setId(resultSet.getInt("id"));
			student.setName(resultSet.getString("name"));
			student.setDepartment(resultSet.getString("department"));
			student.setTeacherId(resultSet.getInt("TeacherId"));

			
			closeStatementConnection(statement,connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public ArrayList<Student> getAll() {
		dbinit();
		String sql = String.format("SELECT * FROM students");
		ArrayList<Student> students = new ArrayList<>();

		Connection connection=null;
		Statement statement = null;
		ResultSet resultSet = executeQuery(sql,statement,connection);
		try {
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("Id"));
				student.setName(resultSet.getString("Name"));
				student.setDepartment(resultSet.getString("Department"));
				student.setTeacherId(resultSet.getInt("TeacherId"));

				students.add(student);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeStatementConnection(statement,connection);
		return students;
	}

	private ResultSet executeQuery(String sql,Statement statement, Connection connection) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	private void closeStatementConnection(Statement statement,Connection connection) {
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException se2) {
		} // nothing we can do

		// finally block used to close resources

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // end finally try
		// end try
	}

	private void executeUpdate(String sql,Statement statement,Connection connection) {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			statement = connection.createStatement();
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

			sql = "CREATE TABLE IF NOT EXISTS students( Id int,  Name varchar(45), Department varchar(45), TeacherId int, PRIMARY KEY(id) )";
			stmt.executeUpdate(sql);

			// sql = "CREATE TABLE IF NOT EXISTS teachers(" + "id int, " + "name
			// varchar(45)," + "address varchar(45),"
			// + "PRIMARY KEY(id)" + ")";
			// stmt.executeUpdate(sql);

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
