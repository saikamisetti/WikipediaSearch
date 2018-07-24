package com.moneytap.model;

import com.squareup.moshi.Json;

public class WikipediaPageSearchResponse {

  @Json(name = "batchcomplete")
  private boolean batchcomplete;

  @Json(name = "continue")
  private JsonMemberContinue jsonMemberContinue;

  @Json(name = "query")
  private Query query;

  public boolean isBatchcomplete() {
    return batchcomplete;
  }

  public void setBatchcomplete(boolean batchcomplete) {
    this.batchcomplete = batchcomplete;
  }

  public JsonMemberContinue getJsonMemberContinue() {
    return jsonMemberContinue;
  }

  public void setJsonMemberContinue(JsonMemberContinue jsonMemberContinue) {
    this.jsonMemberContinue = jsonMemberContinue;
  }

  public Query getQuery() {
    return query;
  }

  public void setQuery(Query query) {
    this.query = query;
  }

  @Override
  public String toString() {
    return
        "WikipediaPageSearchResponse{" +
            "batchcomplete = '" + batchcomplete + '\'' +
            ",continue = '" + jsonMemberContinue + '\'' +
            ",query = '" + query + '\'' +
            "}";
  }
}