package com.bresiu.puzzle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.R;
import com.bresiu.puzzle.data.DataStore;
import com.bresiu.puzzle.network.RestRepository;

import java.util.Collections;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Bresiu on 09-06-2015
 */
public class JobsSearchFragment extends Fragment {
	@Inject
	public RestRepository restRepository;
	@Inject
	public DataStore dataStore;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PuzzleApplication.getInstance().getGraph().inject(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jobs_search_fragment, container, false);
		ButterKnife.inject(this, view);
		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

	@OnClick(R.id.search_button)
	public void sayHi() {
		this.restRepository
				.search(Collections.singletonMap("NumberOfJobs", "50"))
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(jobResponse -> {
					this.dataStore.setJobResponse(jobResponse);
					this.switchToJobsList();
				});

	}

	private void switchToJobsList() {
		getFragmentManager()
				.beginTransaction()
				.replace(R.id.container, new JobsListFragment(), "JobsListFragment")
				.commit();
	}
}