package com.moneytap.model;

import com.squareup.moshi.Json;

public class PageDetail {

  @Json(name = "touched")
  private String touched;

  @Json(name = "ns")
  private int ns;

  @Json(name = "canonicalurl")
  private String canonicalurl;

  @Json(name = "contentmodel")
  private String contentmodel;

  @Json(name = "fullurl")
  private String fullurl;

  @Json(name = "pagelanguagehtmlcode")
  private String pagelanguagehtmlcode;

  @Json(name = "length")
  private int length;

  @Json(name = "pageid")
  private int pageid;

  @Json(name = "title")
  private String title;

  @Json(name = "lastrevid")
  private int lastrevid;

  @Json(name = "pagelanguage")
  private String pagelanguage;

  @Json(name = "pagelanguagedir")
  private String pagelanguagedir;

  @Json(name = "editurl")
  private String editurl;

  public String getTouched() {
    return touched;
  }

  public void setTouched(String touched) {
    this.touched = touched;
  }

  public int getNs() {
    return ns;
  }

  public void setNs(int ns) {
    this.ns = ns;
  }

  public String getCanonicalurl() {
    return canonicalurl;
  }

  public void setCanonicalurl(String canonicalurl) {
    this.canonicalurl = canonicalurl;
  }

  public String getContentmodel() {
    return contentmodel;
  }

  public void setContentmodel(String contentmodel) {
    this.contentmodel = contentmodel;
  }

  public String getFullurl() {
    return fullurl;
  }

  public void setFullurl(String fullurl) {
    this.fullurl = fullurl;
  }

  public String getPagelanguagehtmlcode() {
    return pagelanguagehtmlcode;
  }

  public void setPagelanguagehtmlcode(String pagelanguagehtmlcode) {
    this.pagelanguagehtmlcode = pagelanguagehtmlcode;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
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

  public int getLastrevid() {
    return lastrevid;
  }

  public void setLastrevid(int lastrevid) {
    this.lastrevid = lastrevid;
  }

  public String getPagelanguage() {
    return pagelanguage;
  }

  public void setPagelanguage(String pagelanguage) {
    this.pagelanguage = pagelanguage;
  }

  public String getPagelanguagedir() {
    return pagelanguagedir;
  }

  public void setPagelanguagedir(String pagelanguagedir) {
    this.pagelanguagedir = pagelanguagedir;
  }

  public String getEditurl() {
    return editurl;
  }

  public void setEditurl(String editurl) {
    this.editurl = editurl;
  }

  @Override
  public String toString() {
    return
        "PageDetail{" +
            "touched = '" + touched + '\'' +
            ",ns = '" + ns + '\'' +
            ",canonicalurl = '" + canonicalurl + '\'' +
            ",contentmodel = '" + contentmodel + '\'' +
            ",fullurl = '" + fullurl + '\'' +
            ",pagelanguagehtmlcode = '" + pagelanguagehtmlcode + '\'' +
            ",length = '" + length + '\'' +
            ",pageid = '" + pageid + '\'' +
            ",title = '" + title + '\'' +
            ",lastrevid = '" + lastrevid + '\'' +
            ",pagelanguage = '" + pagelanguage + '\'' +
            ",pagelanguagedir = '" + pagelanguagedir + '\'' +
            ",editurl = '" + editurl + '\'' +
            "}";
  }
}