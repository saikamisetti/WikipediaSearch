package com.moneytap.model;

import com.squareup.moshi.Json;
import java.io.Serializable;

public class Thumbnail implements Serializable{

  @Json(name = "width")
  private int width;

  @Json(name = "source")
  private String source;

  @Json(name = "height")
  private int height;

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return
        "Thumbnail{" +
            "width = '" + width + '\'' +
            ",source = '" + source + '\'' +
            ",height = '" + height + '\'' +
            "}";
  }
}