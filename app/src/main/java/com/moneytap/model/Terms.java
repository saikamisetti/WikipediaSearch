package com.moneytap.model;

import com.squareup.moshi.Json;
import java.io.Serializable;
import java.util.List;

public class Terms implements Serializable{

  @Json(name = "description")
  private List<String> description;

  public List<String> getDescription() {
    return description;
  }

  public void setDescription(List<String> description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return
        "Terms{" +
            "description = '" + description + '\'' +
            "}";
  }
}