package com.moneytap.feature.wikipediasearch.util;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by Sai on 23/07/18.
 */
public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {
  public final static String AUTHORITY =
      "com.moneytap.wikipediasearch.SearchSuggestionProvider";
  public final static int MODE = DATABASE_MODE_QUERIES;

  public SearchSuggestionProvider() {
    setupSuggestions(AUTHORITY, MODE);
  }
}
