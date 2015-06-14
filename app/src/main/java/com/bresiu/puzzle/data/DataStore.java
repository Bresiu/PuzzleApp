package com.bresiu.puzzle.data;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.model.entity.JobResponse;

/**
 * Created by Bresiu on 10-06-2015
 */
public class DataStore {
	private JobResponse jobResponse;

	public DataStore() {
		PuzzleApplication.getInstance().getGraph().inject(this);
	}

	public void setJobResponse(JobResponse jobResponse) {
		this.jobResponse = jobResponse;
	}

	public JobResponse getJobResponse() {
		return this.jobResponse;
	}
}