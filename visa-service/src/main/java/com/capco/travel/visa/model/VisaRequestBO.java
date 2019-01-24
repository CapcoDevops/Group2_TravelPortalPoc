package com.capco.travel.visa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is the VisaRequest Business class to map fields with DB columns
 * 
 */

@Entity
@Table(name = "VISA_REQUEST")
public class VisaRequestBO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "uid")
	private int uId;
	
	@Column(name="request_id")
	private int requestId;

	
	@Column(name = "travel_destination")
	private String travelDestination;
	
	@Column(name = "visa_type")
	private String visaType;
	
	@Column(name = "type_of_visit")
	private String typeOfVisit;
	
	@Column(name = "business_purpose")
	private String businessPurpose;
	
	@Column(name="collection_desk")
	private String collectionDesk;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "modified_on")
	private Date modifiedOn;
	
	@Column(name = "remarks")
	private String visaRemarks;
	
	@Column(name = "is_active")
	private Boolean isActive;

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

	/**
	 * @return the travelDestination
	 */
	public String getTravelDestination() {
		return travelDestination;
	}

	/**
	 * @param travelDestination the travelDestination to set
	 */
	public void setTravelDestination(String travelDestination) {
		this.travelDestination = travelDestination;
	}

	/**
	 * @return the visaType
	 */
	public String getVisaType() {
		return visaType;
	}

	/**
	 * @param visaType the visaType to set
	 */
	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	/**
	 * @return the typeOfVisit
	 */
	public String getTypeOfVisit() {
		return typeOfVisit;
	}

	/**
	 * @param typeOfVisit the typeOfVisit to set
	 */
	public void setTypeOfVisit(String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
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
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the businessPurpose
	 */
	public String getBusinessPurpose() {
		return businessPurpose;
	}

	/**
	 * @param businessPurpose the businessPurpose to set
	 */
	public void setBusinessPurpose(String businessPurpose) {
		this.businessPurpose = businessPurpose;
	}

	/**
	 * @return the collectionDesk
	 */
	public String getCollectionDesk() {
		return collectionDesk;
	}

	/**
	 * @param collectionDesk the collectionDesk to set
	 */
	public void setCollectionDesk(String collectionDesk) {
		this.collectionDesk = collectionDesk;
	}

	/**
	 * @return the visaRemarks
	 */
	public String getVisaRemarks() {
		return visaRemarks;
	}

	/**
	 * @param visaRemarks the visaRemarks to set
	 */
	public void setVisaRemarks(String visaRemarks) {
		this.visaRemarks = visaRemarks;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "VisaRequestBO [uId=" + uId + ", requestId=" + requestId + ", travelDestination=" + travelDestination
				+ ", visaType=" + visaType + ", typeOfVisit=" + typeOfVisit + ", businessPurpose=" + businessPurpose
				+ ", collectionDesk=" + collectionDesk + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ ", visaRemarks=" + visaRemarks + ", isActive=" + isActive + "]";
	}
	
	
	
	
	
}
