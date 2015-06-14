package com.bresiu.puzzle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.R;
import com.bresiu.puzzle.data.DataStore;
import com.bresiu.puzzle.model.entity.Job;
import com.bresiu.puzzle.views.JobsListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Bresiu on 14-06-2015
 */
public class JobsListFragment extends Fragment {
	@Inject
	public DataStore dataStore;

	@InjectView(R.id.job_recycler)
	RecyclerView jobRecycler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PuzzleApplication.getInstance().getGraph().inject(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jobs_list_fragment, container, false);
		ButterKnife.inject(this, view);

		this.initializeRecyclerView();
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		this.showJobsList(this.dataStore.getJobResponse().getJobData());
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}

	private void initializeRecyclerView() {
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PuzzleApplication.getInstance());
		this.jobRecycler.setLayoutManager(linearLayoutManager);
	}

	public void showJobsList(List<Job> jobs) {
		JobsListAdapter jobsListAdapter = new JobsListAdapter(jobs, PuzzleApplication.getInstance());
		this.jobRecycler.setAdapter(jobsListAdapter);
	}
}
