package com.bresiu.puzzle.model.rest.job;

import com.bresiu.puzzle.model.entity.job.JobResponse;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Created by Bresiu on 30-05-2015
 */
public interface JobsApi {
	String END_POINT = "https://data.usajobs.gov";

	@GET("/api/jobs")
	Observable<JobResponse> getJobs(@QueryMap Map<String, String> options);
}