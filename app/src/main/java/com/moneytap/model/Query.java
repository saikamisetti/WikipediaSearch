package com.moneytap.model;

import com.squareup.moshi.Json;
import java.util.List;

public class Query {
  @Json(name = "redirects")
  private List<RedirectsItem> redirectsItemList;
  @Json(name = "pages")
  private List<WikipediaPage> wikipediaPages;


  public List<RedirectsItem> getRedirectsItemList() {
    return redirectsItemList;
  }

  public void setRedirectsItemList(List<RedirectsItem> redirectsItemList) {
    this.redirectsItemList = redirectsItemList;
  }

  public List<WikipediaPage> getWikipediaPages() {
    return wikipediaPages;
  }

  public void setWikipediaPages(List<WikipediaPage> wikipediaPages) {
    this.wikipediaPages = wikipediaPages;
  }

  @Override
  public String toString() {
    return
        "Query{" +
            "pages = '" + wikipediaPages + '\'' +
            "redirects = '" + redirectsItemList + '\'' +
            "}";
  }
}
