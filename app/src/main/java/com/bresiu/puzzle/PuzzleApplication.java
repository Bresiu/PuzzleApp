package com.bresiu.puzzle;

import android.app.Application;

/**
 * Created by Bresiu on 29-05-2015
 */
public class PuzzleApplication extends Application {
	private static PuzzleApplication instance;
	private Graph mGraph;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static PuzzleApplication getInstance() {
		return instance;
	}

	public Graph getGraph() {
		return this.mGraph;
	}
}