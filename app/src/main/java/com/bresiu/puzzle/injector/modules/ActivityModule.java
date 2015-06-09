package com.bresiu.puzzle.injector.modules;

import android.content.Context;

import com.bresiu.puzzle.injector.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bresiu on 29-05-2015
 */
@Module
public class ActivityModule {
	private final Context mContext;

	public ActivityModule(Context mContext) {
		this.mContext = mContext;
	}

	@Provides
	@Activity
	Context provideActivityContext() {
		return this.mContext;
	}
}