package com.moneytap;

import android.app.Application;
import com.moneytap.network.WikipediaApiInstance;

/**
 * Created by Sai on 11/06/18.
 */
public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    WikipediaApiInstance.init();
  }
}
