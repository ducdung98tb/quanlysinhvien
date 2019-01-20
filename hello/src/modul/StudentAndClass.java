package modul;

public class StudentAndClass {
	private String studentId;
	private String classId;
	
	public StudentAndClass() {
		super();
	}
	public StudentAndClass(String studentId, String classId) {
		super();
		this.studentId = studentId;
		this.classId = classId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
}
