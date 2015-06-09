package com.bresiu.puzzle.viewmodels;

import android.util.Log;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Bresiu on 09-06-2015
 */
public abstract class AbstractViewModel {
	private static final String TAG = AbstractViewModel.class.getSimpleName();
	private CompositeSubscription compositeSubscription;

	final public void subscribeToDataStore() {
		Log.v(TAG, "subscribeToDataStore");
		this.unsubscribeFromDataStore();
		this.compositeSubscription = new CompositeSubscription();
		this.subscribeToDataStoreInternal(this.compositeSubscription);
	}

	public void dispose() {
		Log.v(TAG, "dispose");

		if (this.compositeSubscription != null) {
			Log.e(TAG, "Disposing without calling unsubscribeFromDataStore first");

			// Unsubscribe in case we are still for some reason subscribed
			this.unsubscribeFromDataStore();
		}
	}

	abstract void subscribeToDataStoreInternal(CompositeSubscription compositeSubscription);

	public void unsubscribeFromDataStore() {
		Log.v(TAG, "unsubscribeToDataStore");
		if (this.compositeSubscription != null) {
			this.compositeSubscription.clear();
			this.compositeSubscription = null;
		}
	}
}
