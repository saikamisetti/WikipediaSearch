package com.moneytap.model;

import java.util.List;

public class Pages {

  private List<Pages> pagesList;

  public List<Pages> getPagesList() {
    return pagesList;
  }

  public void setPagesList(List<Pages> pagesList) {
    this.pagesList = pagesList;
  }

  @Override
  public String toString() {
    return
        "Pages{" +
            "" + pagesList + '\'' +
            "}";
  }
}