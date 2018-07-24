package com.moneytap.feature.wikipediasearch;

import com.moneytap.basemvp.BasePresenter;
import com.moneytap.basemvp.BaseView;
import com.moneytap.model.WikipediaPage;
import java.util.List;

/**
 * Created by Sai on 22/07/18.
 */
public class SearchContract {
  interface SearchView extends BaseView<SearchPresenter> {
    void onWikiPages(List<WikipediaPage> pageList);
    void onPageUrl(String url);
  }

  interface SearchPresenter extends BasePresenter<SearchView> {
    void fetchUrlForPage(int pageId);
    void searchForString(String query);
  }
}
