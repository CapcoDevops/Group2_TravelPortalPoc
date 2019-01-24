package com.capco.travel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This class is the MainRequest Business class to map fields with DB columns
 * 
 */

@Entity
@Table(name = "MAIN_REQUEST")
public class MainRequestBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "request_id")
	private Integer requestId;

	@Column(name = "requested_by")
	private Integer requestedBy;

	@Column(name = "requested_for")
	private String requestedFor;

	@Column(name = "current_status")
	private String currentStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	@Column(name = "created_on")
	private Date createdOn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	@Column(name = "modified_on")
	private Date modifiedOn;

	@Column(name = "approver_id")
	private Integer approverId;

	@Column(name = "billable")
	private Boolean billable;
	
	@Column(name = "request_type")
	private String requestType;
	
	@Column(name = "project_code")
	private String projectCode;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "remarks")
	private String remark;

	/*@OneToOne(fetch = FetchType.EAGER, mappedBy = "mainRequestBO", cascade = CascadeType.ALL, orphanRemoval = true)*/
	@Transient
	private FlightDetailsBO flightDetailsBO;

	/*@OneToOne(fetch = FetchType.EAGER, mappedBy = "mainRequestBO", cascade = CascadeType.ALL, orphanRemoval = true)*/
	@Transient
	private CabDetailsBO cabDetailsBO;

	/*@OneToOne(fetch = FetchType.EAGER, mappedBy = "mainRequestBO", cascade = CascadeType.ALL, orphanRemoval = true)*/
	@Transient
	private AccomodationDetailsBO accomoDetailsBO;

	/*@OneToOne(fetch = FetchType.EAGER, mappedBy = "mainRequestBO", cascade = CascadeType.ALL, orphanRemoval = true)*/
	@Transient
	private ForexDetailsBO forexDetailsBO;

	/*@OneToOne(fetch = FetchType.EAGER, mappedBy = "mainRequestBO", cascade = CascadeType.ALL, orphanRemoval = true)*/
	@Transient
	private VisaRequestBO visaRequestBO;
	
	private String cabStatus;
	private String flightStatus;
	private String visaStatus;
	private String accommodationStatus;
	private String forexStatus;
	
	

	/**
	 * @return the cabStatus
	 */
	public String getCabStatus() {
		return cabStatus;
	}

	/**
	 * @param cabStatus the cabStatus to set
	 */
	public void setCabStatus(String cabStatus) {
		this.cabStatus = cabStatus;
	}

	/**
	 * @return the flightStatus
	 */
	public String getFlightStatus() {
		return flightStatus;
	}

	/**
	 * @param flightStatus the flightStatus to set
	 */
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	/**
	 * @return the visaStatus
	 */
	public String getVisaStatus() {
		return visaStatus;
	}

	/**
	 * @param visaStatus the visaStatus to set
	 */
	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	/**
	 * @return the accommodationStatus
	 */
	public String getAccommodationStatus() {
		return accommodationStatus;
	}

	/**
	 * @param accommodationStatus the accommodationStatus to set
	 */
	public void setAccommodationStatus(String accommodationStatus) {
		this.accommodationStatus = accommodationStatus;
	}

	/**
	 * @return the forexStatus
	 */
	public String getForexStatus() {
		return forexStatus;
	}

	/**
	 * @param forexStatus the forexStatus to set
	 */
	public void setForexStatus(String forexStatus) {
		this.forexStatus = forexStatus;
	}

	public FlightDetailsBO getFlightDetailsBO() {
		return flightDetailsBO;
	}

	public void setFlightDetailsBO(FlightDetailsBO flightDetailsBO) {
		this.flightDetailsBO = flightDetailsBO;
	}

	public CabDetailsBO getCabDetailsBO() {
		return cabDetailsBO;
	}

	public void setCabDetailsBO(CabDetailsBO cabDetailsBO) {
		this.cabDetailsBO = cabDetailsBO;
	}

	public ForexDetailsBO getForexDetailsBO() {
		return forexDetailsBO;
	}

	public void setForexDetailsBO(ForexDetailsBO forexDetailsBO) {
		this.forexDetailsBO = forexDetailsBO;
	}

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "requested_by") private EmployeeDetailsBO
	 * employeeDetailsBO;
	 */
	/**
	 * @return the requestId
	 */
	public Integer getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the requestedBy
	 */
	public Integer getRequestedBy() {
		return requestedBy;
	}

	/**
	 * @param requestedBy
	 *            the requestedBy to set
	 */
	public void setRequestedBy(Integer requestedBy) {
		this.requestedBy = requestedBy;
	}

	/**
	 * @return the requestedFor
	 */
	public String getRequestedFor() {
		return requestedFor;
	}

	/**
	 * @param requestedFor
	 *            the requestedFor to set
	 */
	public void setRequestedFor(String requestedFor) {
		this.requestedFor = requestedFor;
	}

	/**
	 * @return the currentStatus
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus
	 *            the currentStatus to set
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn
	 *            the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the approverId
	 */
	public Integer getApproverId() {
		return approverId;
	}

	/**
	 * @param approverId
	 *            the approverId to set
	 */
	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the billable
	 */
	public Boolean getBillable() {
		return billable;
	}

	/**
	 * @param billable the billable to set
	 */
	public void setBillable(Boolean billable) {
		this.billable = billable;
	}

	/**
	 * @return the flightDetailsBO
	 */
	/*public FlightDetailsBO getFlightDetailsBO() {
		return flightDetailsBO;
	}

	*//**
	 * @param flightDetailsBO
	 *            the flightDetailsBO to set
	 *//*
	public void setFlightDetailsBO(FlightDetailsBO flightDetailsBO) {
		flightDetailsBO.setMainRequestBO(this);
		this.flightDetailsBO = flightDetailsBO;
	}

	*//**
	 * @return the cabDetailsBO
	 *//*
	public CabDetailsBO getCabDetailsBO() {
		return cabDetailsBO;
	}

	*//**
	 * @param cabDetailsBO
	 *            the cabDetailsBO to set
	 *//*
	public void setCabDetailsBO(CabDetailsBO cabDetailsBO) {
		cabDetailsBO.setMainRequestBO(this);
		this.cabDetailsBO = cabDetailsBO;
	}

	

	/**
	 * @return the forexDetailsBO
	 *//*
	public ForexDetailsBO getForexDetailsBO() {
		return forexDetailsBO;
	}

	*//**
	 * @param forexDetailsBO
	 *            the forexDetailsBO to set
	 *//*
	public void setForexDetailsBO(ForexDetailsBO forexDetailsBO) {
		forexDetailsBO.setMainRequestBO(this);
		this.forexDetailsBO = forexDetailsBO;
	}*/

	/**
	 * @return the visaRequestBO
	 */
	public VisaRequestBO getVisaRequestBO() {
		return visaRequestBO;
	}

	/**
	 * @return the accomoDetailsBO
	 */
	public AccomodationDetailsBO getAccomoDetailsBO() {
		return accomoDetailsBO;
	}

	/**
	 * @param accomoDetailsBO the accomoDetailsBO to set
	 */
	public void setAccomoDetailsBO(AccomodationDetailsBO accomoDetailsBO) {
		this.accomoDetailsBO = accomoDetailsBO;
	}

	/**
	 * @param visaRequestBO the visaRequestBO to set
	 */
	public void setVisaRequestBO(VisaRequestBO visaRequestBO) {
		/*visaRequestBO.setMainRequestBO(this);*/
		this.visaRequestBO = visaRequestBO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "MainRequestBO [requestId=" + requestId + ", requestedBy=" + requestedBy + ", requestedFor="
				+ requestedFor + ", currentStatus=" + currentStatus + ", createdOn=" + createdOn + ", modifiedOn="
				+ modifiedOn + ", approverId=" + approverId + ", billable=" + billable + ", remark=" + remark
				+ ", flightDetailsBO=" + flightDetailsBO + ", cabDetailsBO=" + cabDetailsBO + ", accomoDetailsBO="
				+ accomoDetailsBO + ", forexDetailsBO=" + forexDetailsBO + ", visaRequestBO=" + visaRequestBO + "]";
	}*/

	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return requestType;
	}

	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the employeeDetailsBO
	 *//*
	 * public EmployeeDetailsBO getEmployeeDetailsBO() { return employeeDetailsBO; }
	 * 
	 * public void setEmployeeDetailsBO(EmployeeDetailsBO employeeDetailsBO) {
	 * Set<MainRequestBO> set = new HashSet<MainRequestBO>(); set.add(this);
	 * employeeDetailsBO.setMainRequestBO(set); this.employeeDetailsBO =
	 * employeeDetailsBO; }
	 */


}