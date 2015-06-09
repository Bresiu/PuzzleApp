package com.bresiu.puzzle.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.R;
import com.bresiu.puzzle.injector.components.DaggerJobsSearchComponent;
import com.bresiu.puzzle.injector.modules.ActivityModule;
import com.bresiu.puzzle.injector.modules.JobsSearchModule;
import com.bresiu.puzzle.model.entity.job.JobResponse;
import com.bresiu.puzzle.model.rest.job.RestRepository;
import com.bresiu.puzzle.mvp.presenters.JobsSearchPresenter;
import com.bresiu.puzzle.mvp.views.JobsSearchView;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Bresiu on 29-05-2015
 */
public class JobsSearchActivity extends AppCompatActivity implements JobsSearchView {
	@InjectView(R.id.app_bar)
	public Toolbar mToolbar;

	@Inject
	public JobsSearchPresenter mJobsSearchPresenter;

	@Inject
	public RestRepository restRepository;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.job_search_activity);
		ButterKnife.inject(this);

		this.initializeToolbar();
		this.initializeDependencyInjector();
		this.initializePresenter();
	}

	@Override
	protected void onStart() {
		super.onStart();
		this.mJobsSearchPresenter.onStart();
	}

	private void initializeToolbar() {
		setSupportActionBar(this.mToolbar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.jobs_search_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
			case R.id.action_settings:
				Toast.makeText(this, "You just hit " + item.getTitle(), Toast.LENGTH_SHORT).show();
				HashMap<String, String> options = new HashMap<>();
				options.put("series", "2210");
				Observable<JobResponse> jobResponseObservable = this.restRepository.getJobResponse(options);
				jobResponseObservable
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(response -> Log.d("Dupa", response.toString()));
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void initializePresenter() {
		this.mJobsSearchPresenter.attachView(this);
	}

	private void initializeDependencyInjector() {
		PuzzleApplication puzzleApplication = (PuzzleApplication) getApplication();

		DaggerJobsSearchComponent.builder()
				.jobsSearchModule(new JobsSearchModule())
				.activityModule(new ActivityModule(this))
				.appComponent(puzzleApplication.getAppComponent())
				.build()
				.inject(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		this.mJobsSearchPresenter.onStop();
	}
}