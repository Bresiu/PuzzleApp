package com.bresiu.puzzle.network;

import com.bresiu.puzzle.model.entity.JobResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;

/**
 * Created by Bresiu on 30-05-2015
 */
public class RestRepository {
	private final JobsApi jobsApi;

	public RestRepository() {
		Gson gson = new GsonBuilder()
				.registerTypeAdapterFactory(new JobAdapterFactory())
				.create();

		RestAdapter jobsApiAdapter = new RestAdapter.Builder()
				.setRequestInterceptor(request -> {
					request.addHeader("Host", "data.usajobs.gov");
					request.addHeader("Accept", "application/json");
				})
				.setEndpoint(JobsApi.END_POINT)
				.setLogLevel(RestAdapter.LogLevel.NONE)
				.setConverter(new GsonConverter(gson))
				.build();

		this.jobsApi = jobsApiAdapter.create(JobsApi.class);
	}

	public Observable<JobResponse> search(Map<String, String> options) {
		return this.jobsApi.getJobs(options);
	}
}
