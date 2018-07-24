package com.moneytap.feature.wikipediasearch;

import com.moneytap.model.PageDetailResponse;
import com.moneytap.model.WikipediaPageSearchResponse;
import com.moneytap.network.WikipediaApiInstance;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Sai on 22/07/18.
 */
public class SearchPresenter implements SearchContract.SearchPresenter {

  private SearchContract.SearchView view;
  private CompositeDisposable compositeDisposable;

  @Override public void subscribe(SearchContract.SearchView view) {
    this.view = view;
    compositeDisposable = new CompositeDisposable();
  }

  @Override public void unsubscribe() {
    compositeDisposable.dispose();
  }

  @Override public void load() {

  }

  @Override public void fetchUrlForPage(int pageId) {
    WikipediaApiInstance.getInstance().getPageDetails(pageId).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(new Consumer<Response<PageDetailResponse>>() {
          @Override public void accept(Response<PageDetailResponse> pageDetailResponseResponse)
              throws Exception {
            view.showProgress(true);
          }
        })
        .subscribe(new Observer<Response<PageDetailResponse>>() {
          @Override public void onSubscribe(Disposable d) {
            compositeDisposable.add(d);
          }

          @Override public void onNext(Response<PageDetailResponse> pageDetailResponseResponse) {
            view.onPageUrl(pageDetailResponseResponse.body().getQuery().getPages().getFullurl());
            view.showProgress(false);
          }

          @Override public void onError(Throwable e) {
            view.showError(new Error(e.getMessage()));
          }

          @Override public void onComplete() {

          }
        });
  }

  @Override public void searchForString(String query) {
    WikipediaApiInstance.getInstance()
        .searchForString(query)
        .subscribeOn(Schedulers.io())
        .observeOn(
            AndroidSchedulers.mainThread())
        .doOnNext(new Consumer<Response<WikipediaPageSearchResponse>>() {
          @Override
          public void accept(
              Response<WikipediaPageSearchResponse> wikipediaPageSearchResponseResponse)
              throws Exception {
            view.showProgress(true);
          }
        })
        .subscribe(
            new Observer<Response<WikipediaPageSearchResponse>>() {
              @Override public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
              }

              @Override
              public void onNext(
                  Response<WikipediaPageSearchResponse> wikipediaPageSearchResponseResponse) {
                view.onWikiPages(
                    wikipediaPageSearchResponseResponse.body().getQuery().getWikipediaPages());
                view.showProgress(false);
              }

              @Override public void onError(Throwable e) {
                view.showError(new Error(e.getMessage()));
              }

              @Override public void onComplete() {

              }
            });
  }
}
