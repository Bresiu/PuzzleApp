package com.bresiu.puzzle.injector.components;

import android.content.Context;

import com.bresiu.puzzle.injector.Activity;
import com.bresiu.puzzle.injector.modules.ActivityModule;
import com.bresiu.puzzle.injector.modules.JobsSearchModule;
import com.bresiu.puzzle.views.activities.JobsSearchActivity;

import dagger.Component;

/**
 * Created by Bresiu on 31-05-2015
 */
@Activity
@Component(dependencies = AppComponent.class, modules = {JobsSearchModule.class, ActivityModule.class})
public interface JobsSearchComponent extends ActivityComponent {
	void inject(JobsSearchActivity activity);

	Context activityContext();
}