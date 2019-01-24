package com.capco.travel.model;

public class LoginDTO {
	
	private EmployeeDetailsBO employeDetailsBO;
	private Status status;
	/**
	 * @return the employeDetailsBO
	 */
	public EmployeeDetailsBO getEmployeDetailsBO() {
		return employeDetailsBO;
	}
	/**
	 * @param employeDetailsBO the employeDetailsBO to set
	 */
	public void setEmployeDetailsBO(EmployeeDetailsBO employeDetailsBO) {
		this.employeDetailsBO = employeDetailsBO;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginDTO [employeDetailsBO=" + employeDetailsBO + ", status=" + status + "]";
	}
	

}
