package modul;

import java.util.Date;

public class Student {
	private String studentId;
	private String studentName;
	private String program;
	private String major;
	private Date dateOfBirth;
	private String projectId;
	public Student(String studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public Student() {
		super();
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}
