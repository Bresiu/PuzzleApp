package com.bresiu.puzzle.mvp.presenters;

import android.content.Context;
import android.content.Intent;

import com.bresiu.puzzle.mvp.views.View;
import com.bresiu.puzzle.views.RecyclerClickListener;

import javax.inject.Inject;


/**
 * Created by Bresiu on 29-05-2015
 */
public class JobsSearchPresenter implements Presenter, RecyclerClickListener {
	private final Context mContext;
	private View mJobsSearchView;
	private Intent mIntent;

	@Inject
	public JobsSearchPresenter(Context context) {
		this.mContext = context;
	}

	@Override
	public void onStart() {

	}

	@Override
	public void onStop() {

	}

	@Override
	public void attachView(View view) {
		this.mJobsSearchView = view;
	}

	@Override
	public void attachIncomingIntent(Intent intent) {
		this.mIntent = intent;
	}

	@Override
	public void onMenuItemClick() {

	}
}
