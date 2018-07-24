package com.moneytap.model;

import com.squareup.moshi.Json;

public class RedirectsItem {

  @Json(name = "index")
  private int index;

  @Json(name = "from")
  private String from;

  @Json(name = "to")
  private String to;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  @Override
  public String toString() {
    return
        "RedirectsItem{" +
            "index = '" + index + '\'' +
            ",from = '" + from + '\'' +
            ",to = '" + to + '\'' +
            "}";
  }
}