package com.bresiu.puzzle.network.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bresiu on 10-06-2015
 */
public class NetworkStateManager {
	private final ConnectivityManager connectivityManager;

	public NetworkStateManager(ConnectivityManager connectivityManager) {
		this.connectivityManager = connectivityManager;
	}

	public boolean isConnectedOrConnecting() {
		NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo.isConnectedOrConnecting();
	}
}