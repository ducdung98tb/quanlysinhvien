package modul;

public class ClassStudy {
	private String classId;
	private String className;
	private int credit;
	private String classroom;
	private String time;
	private String teacherId;
	
	public ClassStudy(String classId, String className, int credit, String classroom, String time, String teacherId) {
		super();
		this.classId = classId;
		this.className = className;
		this.credit = credit;
		this.classroom = classroom;
		this.time = time;
		this.teacherId = teacherId;
	}
	public ClassStudy() {
		super();
	}

	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
}
