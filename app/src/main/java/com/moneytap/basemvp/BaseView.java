package com.moneytap.basemvp;

/**
 * Created by Sai on 11/06/18.
 */
public interface BaseView<P extends BasePresenter> {

    /**
     * Show that data load is in progress.
     *
     * @param show true if data load is in progress, false otherwise.
     */
    void showProgress(boolean show);

    /**
     * Show that there is an error loading data.
     *
     * @param error Sync error.
     */
    void showError(Error error);
}
