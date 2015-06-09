package com.bresiu.puzzle;

import com.bresiu.puzzle.data.DataStoreModule;
import com.bresiu.puzzle.viewmodels.JobsSearchViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bresiu on 09-06-2015
 */
@Singleton
@Component(modules = {DataStoreModule.class})
public interface Graph {
	void inject(JobsSearchViewModel jobsSearchViewModel);

	final class Initializer {
		public static Graph init() {
			return DaggerGraph.builder().build();
		}
	}
}
