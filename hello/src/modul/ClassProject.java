package modul;

public class ClassProject {
	private String projectId;
	private String projectName;
	private int credit;
	private String teacherId;
	public ClassProject(String projectId, String projectName, int credit, String teacherId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.credit = credit;
		this.teacherId = teacherId;
	}
	public ClassProject() {
		super();
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
}
