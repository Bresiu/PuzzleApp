package com.bresiu.puzzle.mvp.presenters;

import android.content.Intent;

import com.bresiu.puzzle.mvp.views.View;

/**
 * Created by Bresiu on 29-05-2015
 */
public interface Presenter {

	void onStart();

	void onStop();

	void attachView(View v);

	void attachIncomingIntent(Intent intent);
}