package com.moneytap.model;

import com.squareup.moshi.Json;

public class QueryPageDetail {

  @Json(name = "pages")
  private @PageDetailQualifier PageDetail pageDetail;

  public PageDetail getPages() {
    return pageDetail;
  }

  public void setPageDetail(PageDetail pages) {
    this.pageDetail = pages;
  }

  @Override
  public String toString() {
    return
        "QueryPageDetail{" +
            "pageDetail = '" + pageDetail + '\'' +
            "}";
  }
}