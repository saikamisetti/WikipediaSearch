package com.moneytap.model;

import com.squareup.moshi.Json;

public class JsonMemberContinue {

  @Json(name = "continue")
  private String jsonMemberContinue;

  @Json(name = "gpsoffset")
  private int gpsoffset;

  public String getJsonMemberContinue() {
    return jsonMemberContinue;
  }

  public void setJsonMemberContinue(String jsonMemberContinue) {
    this.jsonMemberContinue = jsonMemberContinue;
  }

  public int getGpsoffset() {
    return gpsoffset;
  }

  public void setGpsoffset(int gpsoffset) {
    this.gpsoffset = gpsoffset;
  }

  @Override
  public String toString() {
    return
        "JsonMemberContinue{" +
            "continue = '" + jsonMemberContinue + '\'' +
            ",gpsoffset = '" + gpsoffset + '\'' +
            "}";
  }
}