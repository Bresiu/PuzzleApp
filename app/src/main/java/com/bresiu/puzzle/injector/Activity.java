package com.bresiu.puzzle.injector;

/**
 * Created by Bresiu on 29-05-2015
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface Activity {
}