package com.bresiu.puzzle.model.rest;

import com.bresiu.puzzle.model.entity.job.JobResponse;

import java.util.Map;

import rx.Observable;


/**
 * Created by Bresiu on 30-05-2015
 */
public interface Repository {
	Observable<JobResponse> getJobResponse(Map<String, String> options);
}
