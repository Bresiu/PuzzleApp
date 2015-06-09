package com.bresiu.puzzle.model.entity.job;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bresiu on 30-05-2015
 */
public class Job {
	@SerializedName("DocumentID")
	private String documentID;
	@SerializedName("JobTitle")
	private String jobTitle;
	@SerializedName("OrganizationName")
	private String organizationName;
	@SerializedName("AgencySubElement")
	private String agencySubElement;
	@SerializedName("SalaryMin")
	private String salaryMin;           // $74,872.00
	@SerializedName("SalaryMax")
	private String salaryMax;           // $115,742.00
	@SerializedName("SalaryBasis")
	private String salaryBasis;         // Per Year
	@SerializedName("StartDate")
	private String startDate;           // 2/16/2013
	@SerializedName("EndDate")
	private String endDate;             // 12/31/2013
	@SerializedName("WhoMayApplyText")
	private String whoMayApplyText;
	@SerializedName("PayPlan")
	private String payPlan;             // GS
	@SerializedName("Series")
	private String series;              // 2210
	@SerializedName("Grade")
	private String grade;               // 12/13
	@SerializedName("WorkType")
	private String workType;            // Career/Career Conditional
	@SerializedName("WorkSchedule")
	private String workSchedule;        // Full Time
	@SerializedName("Locations")
	private String locations;           // Washington DC Metro Area, District of Columbia
	@SerializedName("AnnouncementNumber")
	private String announcementNumber;  // HHS-OS-DE-11-440116
	@SerializedName("JobSummary")
	private String jobSummary;
	@SerializedName("ApplyOnlineURL")
	private String applyOnlineURL;      // https://www.usajobs.gov/GetJob/ViewDetails/12951900?PostingChannelID=RESTAPI

	public String getDocumentID() {
		return this.documentID;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public String getAgencySubElement() {
		return this.agencySubElement;
	}

	public String getSalaryMin() {
		return this.salaryMin;
	}

	public String getSalaryMax() {
		return this.salaryMax;
	}

	public String getSalaryBasis() {
		return this.salaryBasis;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public String getWhoMayApplyText() {
		return this.whoMayApplyText;
	}

	public String getPayPlan() {
		return this.payPlan;
	}

	public String getSeries() {
		return this.series;
	}

	public String getGrade() {
		return this.grade;
	}

	public String getWorkType() {
		return this.workType;
	}

	public String getWorkSchedule() {
		return this.workSchedule;
	}

	public String getLocations() {
		return this.locations;
	}

	public String getAnnouncementNumber() {
		return this.announcementNumber;
	}

	public String getJobSummary() {
		return this.jobSummary;
	}

	public String getApplyOnlineURL() {
		return this.applyOnlineURL;
	}

	@Override
	public String toString() {
		return "DocumentID= " + this.documentID + "\n" +
				"JobTitle= " + this.jobTitle + "\n" +
				"OrganizationName= " + this.organizationName + "\n" +
				"AgencySubElement= " + this.agencySubElement + "\n" +
				"SalaryMin= " + this.salaryMin + "\n" +
				"SalaryMax= " + this.salaryMax + "\n" +
				"SalaryBasis= " + this.salaryBasis + "\n" +
				"StartDate= " + this.startDate + "\n" +
				"EndDate= " + this.endDate + "\n" +
				"WhoMayApplyText= " + this.whoMayApplyText + "\n" +
				"PayPlan= " + this.payPlan + "\n" +
				"Series= " + this.series + "\n" +
				"Grade= " + this.grade + "\n" +
				"WorkType= " + this.workType + "\n" +
				"WorkSchedule= " + this.workSchedule + "\n" +
				"Locations= " + this.locations + "\n" +
				"AnnouncementNumber= " + this.announcementNumber + "\n" +
				"JobSummary= " + this.jobSummary + "\n" +
				"ApplyOnlineURL= " + this.applyOnlineURL + "\n" +
				"SalaryMin= " + this.salaryMin + "\n" +
				"SalaryMax= " + this.salaryMax + "\n" +
				"SalaryBasis= " + this.salaryBasis + "\n" +
				"StartDate= " + this.startDate + "\n" +
				"EndDate= " + this.endDate + "\n" +
				"WhoMayApplyText= " + this.whoMayApplyText + "\n" +
				"PayPlan= " + this.payPlan + "\n" +
				"Series= " + this.series + "\n" +
				"Grade= " + this.grade + "\n" +
				"WorkType= " + this.workType + "\n" +
				"WorkSchedule= " + this.workSchedule + "\n" +
				"Locations= " + this.locations + "\n" +
				"AnnouncementNumber= " + this.announcementNumber + "\n" +
				"JobSummary= " + this.jobSummary + "\n" +
				"ApplyOnlineURL= " + this.applyOnlineURL + "\n";
	}
}