package com.capco.travel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This Class is the ForexDetails Business Class which maps all the fields with the DB table columns using hibernate
 * @author e5544700
 *
 */

@Entity
@Table(name = "forex_details")
public class ForexDetailsBO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int uid;
	
	@Column(name="request_id")
	private Integer requestId;
	
	/*@Column(name="requested_by")
	private Integer requestedBy;*/

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "to_date",nullable=false)
	private Date forexToDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "from_date",nullable=false)
	private Date forexFromDate;

	@Column(name = "currency",nullable=false)
	private String forexCurrency;

	@Column(name = "country",nullable=false)
	private String forexCountry;

	@Column(name = "no_of_days",nullable=false)
	private int forexNoOfDays;

	@Column(name = "amount",nullable=false)
	private double forexAmount;

	@Column(name = "remarks")
	private String forexRemarks;

	@Column(name = "collection_center",nullable=false)
	private String forexCollectionCenter;

	@Column(name = "bank_desk",nullable=false)
	private String forexBankDesk;	
	
	@Column(name="created_on",nullable=false)
	private Date createdOn;

	@Column(name="modified_on")
	private Date modifiedOn;
	
	@Column(name = "is_active",nullable=false)
	private Boolean isActive;
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the requestId
	 */
	public final Integer getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId to set
	 */
	public final void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the uId
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uId to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the requestedBy
	 */
	/*public Integer getRequestedBy() {
		return requestedBy;
	}

	*//**
	 * @param requestedBy to set
	 *//*
	public void setRequestedBy(Integer requestedBy) {
		this.requestedBy = requestedBy;
	}
*/
	/**
	 * @return the forexToDate
	 */
	public final Date getForexToDate() {
		return forexToDate;
	}

	/**
	 * @param forexToDate the forexToDate to set
	 */
	public final void setForexToDate(Date forexToDate) {
		this.forexToDate = forexToDate;
	}

	/**
	 * @return the forexFromDate
	 */
	public final Date getForexFromDate() {
		return forexFromDate;
	}

	/**
	 * @param forexFromDate the forexFromDate to set
	 */
	public final void setForexFromDate(Date forexFromDate) {
		this.forexFromDate = forexFromDate;
	}

	/**
	 * @return the forexCurrency
	 */
	public final String getForexCurrency() {
		return forexCurrency;
	}

	/**
	 * @param forexCurrency the forexCurrency to set
	 */
	public final void setForexCurrency(String forexCurrency) {
		this.forexCurrency = forexCurrency;
	}

	/**
	 * @return the forexCountry
	 */
	public final String getForexCountry() {
		return forexCountry;
	}

	/**
	 * @param forexCountry the forexCountry to set
	 */
	public final void setForexCountry(String forexCountry) {
		this.forexCountry = forexCountry;
	}

	/**
	 * @return the forexNoOfDays
	 */
	public final int getForexNoOfDays() {
		return forexNoOfDays;
	}

	/**
	 * @param forexNoOfDays the forexNoOfDays to set
	 */
	public final void setForexNoOfDays(int forexNoOfDays) {
		this.forexNoOfDays = forexNoOfDays;
	}

	/**
	 * @return the forexAmount
	 */
	public final double getForexAmount() {
		return forexAmount;
	}

	/**
	 * @param forexAmount the forexAmount to set
	 */
	public final void setForexAmount(double forexAmount) {
		this.forexAmount = forexAmount;
	}

	/**
	 * @return the forexRemarks
	 */
	public final String getForexRemarks() {
		return forexRemarks;
	}

	/**
	 * @param forexRemarks the forexRemarks to set
	 */
	public final void setForexRemarks(String forexRemarks) {
		this.forexRemarks = forexRemarks;
	}

	/**
	 * @return the forexCollectionCenter
	 */
	public final String getForexCollectionCenter() {
		return forexCollectionCenter;
	}

	/**
	 * @param forexCollectionCenter the forexCollectionCenter to set
	 */
	public final void setForexCollectionCenter(String forexCollectionCenter) {
		this.forexCollectionCenter = forexCollectionCenter;
	}

	/**
	 * @return the forexBankDesk
	 */
	public final String getForexBankDesk() {
		return forexBankDesk;
	}

	/**
	 * @param forexBankDesk the forexBankDesk to set
	 */
	public final void setForexBankDesk(String forexBankDesk) {
		this.forexBankDesk = forexBankDesk;
	}

	/**
	 * @return the createdOn
	 */
	public final Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public final void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedOn
	 */
	public final Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public final void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForexDetailsBO [uid=" + uid + ", requestId=" + requestId + ", forexToDate=" + forexToDate
				+ ", forexFromDate=" + forexFromDate + ", forexCurrency=" + forexCurrency + ", forexCountry="
				+ forexCountry + ", forexNoOfDays=" + forexNoOfDays + ", forexAmount=" + forexAmount + ", forexRemarks="
				+ forexRemarks + ", forexCollectionCenter=" + forexCollectionCenter + ", forexBankDesk=" + forexBankDesk
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", isActive=" + isActive + "]";
	}	
}
