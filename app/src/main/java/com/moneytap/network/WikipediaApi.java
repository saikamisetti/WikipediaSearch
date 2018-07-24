package com.moneytap.network;

import com.moneytap.model.PageDetailResponse;
import com.moneytap.model.WikipediaPageSearchResponse;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This class is to declare all the API end points.
 */
public interface WikipediaApi {
  @GET("https://en.wikipedia.org//w/api.php?action=query&format=json&prop=pageimages%7Cpageterms"
      + "&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail"
      + "&pithumbsize=50&pilimit=10&wbptterms=description&gpslimit=10")
  Observable<Response<WikipediaPageSearchResponse>> searchForString(
      @Query("gpssearch") String searchString);

  @GET("https://en.wikipedia.org/w/api.php?action=query&prop=info&inprop=url&format=json")
  Observable<Response<PageDetailResponse>> getPageDetails(@Query("pageids") int pageId);
}
