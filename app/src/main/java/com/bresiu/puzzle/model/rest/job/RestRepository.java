package com.bresiu.puzzle.model.rest.job;

import com.bresiu.puzzle.model.entity.job.JobResponse;
import com.bresiu.puzzle.model.rest.JobAdapterFactory;
import com.bresiu.puzzle.model.rest.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import javax.inject.Inject;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

/**
 * Created by Bresiu on 30-05-2015
 */
public class RestRepository implements Repository {
	private final JobsApi jobsApi;

	@Inject
	public RestRepository() {
		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(new JobAdapterFactory())
				.create();

		RestAdapter jobsApiAdapter = new RestAdapter.Builder()
				.setRequestInterceptor(new RequestInterceptor() {
					@Override
					public void intercept(RequestFacade request) {
						request.addHeader("Host", "data.usajobs.gov");
						request.addHeader("Accept", "application/json");
					}
				})
				.setEndpoint(JobsApi.END_POINT)
				.setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
				.setConverter(new GsonConverter(gson))
				.build();

		this.jobsApi = jobsApiAdapter.create(JobsApi.class);
	}

	@Override
	public Observable<JobResponse> getJobResponse(Map<String, String> options) {
		return this.jobsApi.getJobs(options);
	}
}
