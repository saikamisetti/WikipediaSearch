package com.moneytap.model;

import com.squareup.moshi.Json;
import java.io.Serializable;

public class WikipediaPage implements Serializable{

  @Json(name = "thumbnail")
  private Thumbnail thumbnail;

  @Json(name = "ns")
  private int ns;

  @Json(name = "terms")
  private Terms terms;

  @Json(name = "index")
  private int index;

  @Json(name = "pageid")
  private int pageid;

  @Json(name = "title")
  private String title;

  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  public int getNs() {
    return ns;
  }

  public void setNs(int ns) {
    this.ns = ns;
  }

  public Terms getTerms() {
    return terms;
  }

  public void setTerms(Terms terms) {
    this.terms = terms;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public int getPageid() {
    return pageid;
  }

  public void setPageid(int pageid) {
    this.pageid = pageid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return
        "PageDetailResponse{" +
            "thumbnail = '" + thumbnail + '\'' +
            ",ns = '" + ns + '\'' +
            ",terms = '" + terms + '\'' +
            ",index = '" + index + '\'' +
            ",pageid = '" + pageid + '\'' +
            ",title = '" + title + '\'' +
            "}";
  }
}