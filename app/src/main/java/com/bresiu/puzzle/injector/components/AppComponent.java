package com.bresiu.puzzle.injector.components;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.injector.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bresiu on 29-05-2015
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
	PuzzleApplication app();
}