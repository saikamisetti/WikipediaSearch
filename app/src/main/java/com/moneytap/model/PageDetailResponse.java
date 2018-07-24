package com.moneytap.model;

public class PageDetailResponse {
  private String batchcomplete;
  private QueryPageDetail query;

  public String getBatchcomplete() {
    return batchcomplete;
  }

  public void setBatchcomplete(String batchcomplete) {
    this.batchcomplete = batchcomplete;
  }

  public QueryPageDetail getQuery() {
    return query;
  }

  public void setQuery(QueryPageDetail query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return
        "PageDetailResponse{" +
            "batchcomplete = '" + batchcomplete + '\'' +
            ",query = '" + query + '\'' +
            "}";
  }
}
