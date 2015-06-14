package com.bresiu.puzzle;

import android.app.Application;

import com.bresiu.puzzle.injections.Graph;

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
		this.mGraph = Graph.Initializer.init();
	}

	public static PuzzleApplication getInstance() {
		return instance;
	}

	public Graph getGraph() {
		return this.mGraph;
	}
}