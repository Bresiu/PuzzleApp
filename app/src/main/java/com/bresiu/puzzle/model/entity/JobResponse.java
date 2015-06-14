package com.bresiu.puzzle.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Bresiu on 30-05-2015
 */
public class JobResponse {
	@SerializedName("TotalJobs")
	private Integer totalJobs;
	@SerializedName("JobData")
	private ArrayList<Job> jobData;
	@SerializedName("Pages")
	private Integer pages;

	public Integer getTotalJobs() {
		return this.totalJobs;
	}

	public ArrayList<Job> getJobData() {
		return this.jobData;
	}

	public Integer getPages() {
		return this.pages;
	}

	@Override
	public String toString() {
		return "JobResponse= " +
				"TotalJobs= " + this.totalJobs +
				"JobData size= " + this.jobData.size() +
				//"JobData= " + this.jobData.toString() +
				"Pages= " + this.pages;
	}
}
