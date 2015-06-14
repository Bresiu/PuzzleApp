package com.bresiu.puzzle.injections;

import com.bresiu.puzzle.data.DataStore;
import com.bresiu.puzzle.fragments.JobsListFragment;
import com.bresiu.puzzle.fragments.JobsSearchFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bresiu on 09-06-2015
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface Graph {

	void inject(JobsSearchFragment jobsSearchFragment);

	void inject(JobsListFragment jobsListFragment);

	void inject(DataStore dataStore);

	final class Initializer {
		public static Graph init() {
			return DaggerGraph.builder().build();
		}
	}
}
