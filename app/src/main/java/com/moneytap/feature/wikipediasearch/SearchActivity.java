package com.moneytap.feature.wikipediasearch;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.moneytap.feature.WikiWebView;
import com.moneytap.feature.wikipediasearch.util.SearchSuggestionProvider;
import com.moneytap.model.WikipediaPage;
import com.moneytap.wikipediasearch.R;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchContract.SearchView {

  private static final String PAGES_KEY = "pagesKey";
  @BindView(R.id.recycler_view) RecyclerView recyclerView;
  @BindView(R.id.tv_empty) TextView tvEmpty;
  @BindView(R.id.root_view) View rootView;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  ArrayList<WikipediaPage> wikiPages = new ArrayList<>();
  SearchAdapter adapter;
  SearchContract.SearchPresenter presenter;
  Unbinder unbinder;
  SearchView searchView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    unbinder = ButterKnife.bind(this);
    presenter = new SearchPresenter();
    presenter.subscribe(this);
    setupRecyclerView();
    progressBar.setVisibility(View.GONE);
    if (!isNetworkAvailable()) {
      if (savedInstanceState != null
          && savedInstanceState.getParcelableArrayList(PAGES_KEY) != null) {
        onWikiPages((List<WikipediaPage>) savedInstanceState.getSerializable(PAGES_KEY));
      }
    }
    Intent intent = getIntent();
    handleIntent(intent);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    outState.putSerializable(PAGES_KEY, wikiPages);
    super.onSaveInstanceState(outState);
  }

  /**
   * Method to check network connectivity.
   * @return boolean true if there is internet connectivity
   */
  public boolean isNetworkAvailable() {
    final ConnectivityManager connectivityManager =
        ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));
    return connectivityManager.getActiveNetworkInfo() != null
        && connectivityManager.getActiveNetworkInfo().isConnected();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.options_menu, menu);
    SearchManager searchManager =
        (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    searchView =
        (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setSearchableInfo(
        searchManager.getSearchableInfo(getComponentName()));
    searchView.setIconifiedByDefault(false);

    return true;
  }

  @Override protected void onNewIntent(Intent intent) {
    handleIntent(intent);
  }

  private void handleIntent(Intent intent) {
    if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
      String query = intent.getStringExtra(SearchManager.QUERY);
      SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
          SearchSuggestionProvider.AUTHORITY, SearchSuggestionProvider.MODE);
      suggestions.saveRecentQuery(query, null);
      searchView.setQuery(query, false);
      searchQuery(query);
    }
  }

  private void searchQuery(String query) {
    presenter.searchForString(query);
  }

  private void setupRecyclerView() {
    adapter = new SearchAdapter(wikiPages, presenter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
  }

  @Override public void showProgress(boolean show) {
    progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
  }

  @Override public void showError(Error error) {
    Snackbar.make(rootView, R.string.error_msg,
        Snackbar.LENGTH_SHORT).show();
  }

  @Override public void onWikiPages(List<WikipediaPage> pageList) {
    wikiPages.clear();
    wikiPages.addAll(pageList);
    adapter.notifyDataSetChanged();
    if (wikiPages.isEmpty()) {
      tvEmpty.setVisibility(View.VISIBLE);
    } else {
      tvEmpty.setVisibility(View.GONE);
    }
  }

  @Override public void onPageUrl(String url) {
    Intent intent = new Intent(this, WikiWebView.class);
    intent.putExtra(WikiWebView.URL_KEY, url);
    startActivity(intent);
  }

  @Override protected void onDestroy() {
    unbinder.unbind();
    presenter.unsubscribe();
    super.onDestroy();
  }
}
