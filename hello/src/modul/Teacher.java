package modul;

public class Teacher {
	private String teacherId;
	private String teacherName;
	private String department;
	private String position;
	public Teacher(String teacherId, String teacherName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}
	public Teacher() {
		super();
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
