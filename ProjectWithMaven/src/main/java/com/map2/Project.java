package com.map2;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "project")
public class Project {
    @Id
    @Column(name = "pid")
	private int projectId;
    @Column(name= "project_name")
	private String projectName;
	@ManyToMany(mappedBy = "project")
    private List<Employees> employees;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	public Project(int projectId, String projectName, List<Employees> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employees = employees;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
 }
