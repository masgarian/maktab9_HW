package ir.maktab.hw6.model;

public class Student {

	private int id;
	private String name;
	private String department;
	private int teacherId;

	public Student() {
		super();

	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Student(int id, String name, String department, int teacherId) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.teacherId = teacherId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Student[id:%1$d, name:%2$s, department:%3$s, Teacher Id:%4$d", id,name,department,teacherId);
	}

}