package com.map2;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @Column(name= "emp_id")
	private int employeeId;
    
    @Column(name= "emp_name")
	private String emloyeeName;
    
    @ManyToMany
    @JoinTable(
    		
    		name= "emp_learn" , 
    		joinColumns = {@JoinColumn(name ="eid")},
    		inverseJoinColumns = {@JoinColumn(name= "pid")}
    
    		)
    private List<Project> project ;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmloyeeName() {
		return emloyeeName;
	}

	public void setEmloyeeName(String emloyeeName) {
		this.emloyeeName = emloyeeName;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int employeeId, String emloyeeName, List<Project> project) {
		super();
		this.employeeId = employeeId;
		this.emloyeeName = emloyeeName;
		this.project = project;
	}
    
    
}
