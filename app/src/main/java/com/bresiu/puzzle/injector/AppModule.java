package com.bresiu.puzzle.injector;

import com.bresiu.puzzle.PuzzleApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bresiu on 29-05-2015
 */
@Module
public class AppModule {

	private final PuzzleApplication mPuzzleApplication;

	public AppModule(PuzzleApplication puzzleApplication) {
		this.mPuzzleApplication = puzzleApplication;
	}

	@Provides
	@Singleton
	PuzzleApplication providePuzzleApplicationContext() {
		return this.mPuzzleApplication;
	}
}