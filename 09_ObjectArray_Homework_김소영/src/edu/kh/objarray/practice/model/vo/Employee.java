package edu.kh.objarray.practice.model.vo;

public class Employee {

	private int empNo;
	private String empName;
	private String empDept;
	private String empJob;
	private int salary;
	
	public Employee() {}
	public Employee(int empNo, String empName, String empDept, String empJob, int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.empDept = empDept;
		this.empJob = empJob;
		this.salary = salary;
		
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
