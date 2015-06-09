package com.bresiu.puzzle;

import android.app.Application;

import com.bresiu.puzzle.injector.AppModule;
import com.bresiu.puzzle.injector.components.AppComponent;
import com.bresiu.puzzle.injector.components.DaggerAppComponent;

/**
 * Created by Bresiu on 29-05-2015
 */
public class PuzzleApplication extends Application {
	private AppComponent mAppComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		this.initializeInjector();
	}

	private void initializeInjector() {
		this.mAppComponent = DaggerAppComponent.builder()
				.appModule(new AppModule(this))
				.build();
	}

	public AppComponent getAppComponent() {
		return this.mAppComponent;
	}
}