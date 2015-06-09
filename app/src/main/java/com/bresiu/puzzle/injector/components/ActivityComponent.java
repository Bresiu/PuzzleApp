package com.bresiu.puzzle.injector.components;

import android.content.Context;

import com.bresiu.puzzle.injector.Activity;
import com.bresiu.puzzle.injector.modules.ActivityModule;

import dagger.Component;

/**
 * Created by Bresiu on 29-05-2015
 */
@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
	Context context();
}