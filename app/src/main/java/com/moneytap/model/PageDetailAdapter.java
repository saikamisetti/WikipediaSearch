package com.moneytap.model;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sai on 21/06/18.
 */
public class PageDetailAdapter {

  private JsonAdapter<PageDetail> pageDetailJsonAdapter;

  public PageDetailAdapter(Moshi moshi) {
    pageDetailJsonAdapter =
        moshi.adapter(PageDetail.class);
  }

  public @FromJson @PageDetailQualifier PageDetail fromJson(JsonReader reader) throws
      IOException {
    //while (reader.hasNext()) {
      switch (reader.peek()) {
        case BEGIN_OBJECT:
          reader.beginObject();
          reader.skipName();
          return pageDetailJsonAdapter.fromJson(reader);
        case END_OBJECT:
          reader.skipValue();
          break;
        case STRING:
          reader.skipName();
          return pageDetailJsonAdapter.fromJson(reader);
        default:
          return null;
      }
    //}
    return null;
  }

  @ToJson public void toJson(JsonWriter writer, @PageDetailQualifier PageDetail pageDetail) {
    return;
  }
}
