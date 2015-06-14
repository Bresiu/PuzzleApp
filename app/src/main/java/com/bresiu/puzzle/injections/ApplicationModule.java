package com.bresiu.puzzle.injections;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import com.bresiu.puzzle.PuzzleApplication;
import com.bresiu.puzzle.data.DataStore;
import com.bresiu.puzzle.network.RestRepository;
import com.bresiu.puzzle.network.utils.NetworkStateManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bresiu on 10-06-2015
 */
@Module
public class ApplicationModule {
	@Provides
	public Context provideContext() {
		return PuzzleApplication.getInstance();
	}

	@Provides
	@Singleton
	public RestRepository provideRestRepository() {
		return new RestRepository();
	}

	@Provides
	@Singleton
	public DataStore provideDataStore() {
		return new DataStore();
	}

	@Provides
	@Singleton
	public SharedPreferences providePreferenceManager(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context);
	}

	@Provides
	@Singleton
	public ConnectivityManager provideConnectivityManager(Context context) {
		return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	}

	@Provides
	@Singleton
	NetworkStateManager provideNetworkStateManager(ConnectivityManager connectivityManagerCompat) {
		return new NetworkStateManager(connectivityManagerCompat);
	}
}