package com.bresiu.puzzle.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bresiu.puzzle.R;
import com.bresiu.puzzle.model.entity.Job;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Bresiu on 14-06-2015
 */
public class JobsListAdapter extends RecyclerView.Adapter<JobsListAdapter.JobViewHolder> {
	private final List<Job> jobs;
	private Context context;

	public JobsListAdapter(List<Job> jobs, Context context) {
		this.jobs = jobs;
		this.context = context;
	}

	@Override
	public JobViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View rootView = LayoutInflater.from(this.context).inflate(R.layout.item_job, parent, false);
		return new JobViewHolder(rootView);
	}

	@Override
	public void onBindViewHolder(JobViewHolder holder, int position) {
		holder.bindAvenger(this.jobs.get(position));
	}

	@Override
	public int getItemCount() {
		return this.jobs.size();
	}

	public class JobViewHolder extends RecyclerView.ViewHolder {
		@InjectView(R.id.job_title)
		TextView jobTitle;

		public JobViewHolder(View itemView) {
			super(itemView);
			ButterKnife.inject(this, itemView);
		}

		public void bindAvenger(Job job) {
			this.jobTitle.setText(job.getJobTitle());
		}
	}
}
